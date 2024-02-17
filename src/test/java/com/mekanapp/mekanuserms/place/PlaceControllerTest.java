package com.mekanapp.mekanuserms.place;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaceControllerTest {

    @Mock
    PlaceService mockPlaceService;

    @InjectMocks
    PlaceController underTest;

    @Test
    void createPlace() {
        //GIVEN
        PlaceCreateDto placeCreateDto = new PlaceCreateDto("Kafeland", "VadiIstanbul Sarıyer / İstanbul", "05554817339");
        UUID expectedId = UUID.randomUUID();

        when(mockPlaceService.createPlace(placeCreateDto)).thenReturn(expectedId);

        //WHEN
        ResponseEntity<UUID> actualId = underTest.createPlace(placeCreateDto);

        //THEN
        assertEquals(expectedId, actualId.getBody());
    }

    @Test
    void getPlace() {
        // GIVEN
        String placeName = "TestPlace";
        Pageable page = PageRequest.of(0, 10); // Example page, adjust as needed
        Page<PlaceDto> expectedPage = new PageImpl<>(Collections.singletonList(new PlaceDto(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"), "Kahve Dünyası" ,"VadiIstanbul Sarıyer / İstanbul", "05374865472", "ACTIVE")));

        when(mockPlaceService.getPlaces(placeName, page)).thenReturn(expectedPage);

        // WHEN
        ResponseEntity<Page<PlaceDto>> response = underTest.getPlace(page, placeName);

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPage, response.getBody());

        // THIS METHOD CREATED BY CHAT GPT
    }

    @Test
    void updatePlaceById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        PlaceUpdateDto placeUpdateDto = new PlaceUpdateDto("Kahve Dünyası", "Şehit Servet Aktaş Sok. No:10", "05554817339");
        PlaceDto expected = new PlaceDto(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"), "Kahve Dünyası" ,"VadiIstanbul Sarıyer / İstanbul", "05374865472", "ACTIVE");

        when(mockPlaceService.updatePlace(id, placeUpdateDto)).thenReturn(expected);

        //WHEN
        ResponseEntity<PlaceDto> actual = underTest.updatePlaceById(id, placeUpdateDto);

        //THEN
        assertEquals(expected, actual.getBody());
    }

    @Test
    void deletePlaceById() {
        //GIVEN
        UUID id = UUID.randomUUID();

        when(mockPlaceService.deletePlace(id)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> result = underTest.deletePlaceById(id);

        //THEN
        assertEquals(Boolean.TRUE, result.getBody());
    }
}