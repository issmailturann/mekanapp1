package com.mekanapp.mekanuserms.place;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaceServiceTest {

    @Mock
    PlaceRepository mockPlaceRepository;

    @Mock
    PlaceMapper mockPlaceMapper;

    @InjectMocks
    PlaceService underTest;

    @Test
    void createPlace() {
        //GIVEN
        PlaceCreateDto placeCreateDto = new PlaceCreateDto("Kafeland", "VadiIstanbul Sarıyer / İstanbul", "05554817339");
        Place place = new Place();
        BeanUtils.copyProperties(placeCreateDto, place);
        place.setPlaceStatus("ACTIVE");

        UUID id = UUID.randomUUID();
        Place returnedPlace = new Place();
        returnedPlace.setId(id);
        returnedPlace.setPlaceName("Kafeland");
        returnedPlace.setPlaceAddress("VadiIstanbul Sarıyer / İstanbul");
        returnedPlace.setPlacePhoneNumber("05554817339");
        returnedPlace.setPlaceStatus("ACTIVE");

        when(mockPlaceRepository.save(place)).thenReturn(returnedPlace);

        //WHEN
        UUID actual = underTest.createPlace(placeCreateDto);

        //THEN
        assertEquals(returnedPlace.getId(), actual);
    }

    @Test
    void getPlaces() {
        // GIVEN
        String placeName = "Kahve Dünyası";
        Pageable page = PageRequest.of(0, 10);

        Place place1 = new Place();
        place1.setId(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"));
        place1.setPlaceName("Kahve Dünyası");
        place1.setPlaceAddress("VadiIstanbul Sarıyer / İstanbul");
        place1.setPlacePhoneNumber("05374865472");
        place1.setPlaceStatus("ACTIVE");

        Place place2 = new Place();
        place2.setId(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"));
        place2.setPlaceName("Kahve Dünyası");
        place2.setPlaceAddress("VadiIstanbul Sarıyer / İstanbul");
        place2.setPlacePhoneNumber("05374865472");
        place2.setPlaceStatus("ACTIVE");

        List<Place> places = Arrays.asList(place1, place2);

        Page<PlaceDto> expectedPlacesPage = new PageImpl<>(places.stream().map(mockPlaceMapper::toDto).collect(Collectors.toList()), page, places.size());

        when(mockPlaceRepository.findByPlaceName(placeName, page)).thenReturn(expectedPlacesPage);

        // WHEN
        Page<PlaceDto> result = underTest.getPlaces(placeName, page);

        // THEN
        assertEquals(expectedPlacesPage, result);

        //THIS METHOD CREATED BY CHAT GPT
    }

    @Test
    void updatePlace() {
        //GIVEN
        UUID id = UUID.randomUUID();
        PlaceUpdateDto placeUpdateDto = new PlaceUpdateDto("Kahve Dünyası", "Şehit Servet Aktaş Sok. No:10", "05554817339");

        Place place = new Place();
        place.setId(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"));
        place.setPlaceName("Kahve Dünyası");
        place.setPlaceAddress("VadiIstanbul Sarıyer / İstanbul");
        place.setPlacePhoneNumber("05374865472");
        place.setPlaceStatus("ACTIVE");

        Place expectedPlace = new Place();
        place.setId(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"));
        place.setPlaceName("Kahve Dünyası");
        place.setPlaceAddress("Şehit Servet Aktaş Sok. No:10");
        place.setPlacePhoneNumber("05554817339");
        place.setPlaceStatus("ACTIVE");

        when(mockPlaceRepository.findById(id)).thenReturn(Optional.of(place));

        BeanUtils.copyProperties(placeUpdateDto, place);

        when(mockPlaceRepository.save(place)).thenReturn(expectedPlace);

        //WHEN
        PlaceDto actual = underTest.updatePlace(id, placeUpdateDto);

        //THEN
        assertEquals(mockPlaceMapper.toDto(expectedPlace), actual);
    }

    @Test
    void deletePlace() {
        //GIVEN
        UUID id = UUID.randomUUID();

        Place place = new Place();
        place.setId(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"));
        place.setPlaceName("Kahve Dünyası");
        place.setPlaceAddress("VadiIstanbul Sarıyer / İstanbul");
        place.setPlacePhoneNumber("05374865472");
        place.setPlaceStatus("ACTIVE");

        when(mockPlaceRepository.findById(id)).thenReturn(Optional.of(place));
        doNothing().when(mockPlaceRepository).deleteById(id);

        // WHEN
        Boolean result = underTest.deletePlace(id);

        // THEN
        assertTrue(result);
    }
}