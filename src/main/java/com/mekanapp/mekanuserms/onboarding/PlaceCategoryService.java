package com.mekanapp.mekanuserms.onboarding;

import com.mekanapp.mekanuserms.exception.AppException;
import com.mekanapp.mekanuserms.exception.ErrorMessages;
import com.mekanapp.mekanuserms.place.PlaceCreateDto;
import com.mekanapp.mekanuserms.place.PlaceUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PlaceCategoryService {

    private final PlaceCategoryRepository repository;
    private final PlaceCategoryMapper mapper;

    // Admin tarafından ulaşılıp kategori eklenebilecek. Auth ile admin erişimi verilmeli.
    public UUID createPlaceCategory(PlaceCategoryCreateDto placeCategoryCreateDto) {
        PlaceCategory placeCategory = new PlaceCategory();
        BeanUtils.copyProperties(placeCategoryCreateDto, placeCategory);
        placeCategory.setStatus(PlaceCategoryStatuses.ACTIVE.toString());

        PlaceCategory response = repository.save(placeCategory);

        return response.getId();
    }

    // Admin tarafından ulaşılıp kategorinin statusu passive edilerek ulaşıma kapatılabilir.
    public PlaceCategoryDto updatePlaceCategory(PlaceCategoryUpdateDto placeCategoryUpdateDto) {
        PlaceCategory existCategory = repository.findByCategoryName(placeCategoryUpdateDto.categoryName());

        if(existCategory.getCategoryName().isEmpty()) {
            throw  AppException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PLACE_CATEGORY_NOT_FOUND);
        }

        existCategory.setStatus(PlaceCategoryStatuses.PASSIVE.toString());
        PlaceCategory response =repository.save(existCategory);

        return mapper.toDto(response);
    }

    // Kullanıcıya dönecek kategoriler burada belirlenir.
    public Page<PlaceCategoryDto> getAllCategory(Pageable pageable) {
        Page<PlaceCategory> response = repository.findAll(pageable);

        if(response.isEmpty()) {
            throw  AppException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PLACE_CATEGORY_NOT_FOUND);
        }
        else {
            return repository.findAll(pageable).map(mapper::toDto);
        }

    }

}
