package com.mekanapp.mekanuserms.onboarding;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaceCategoryController implements PlaceCategoryApi {

    private final PlaceCategoryService service;

    @Override
    public ResponseEntity<UUID> createPlaceCategory(PlaceCategoryCreateDto placeCategoryCreateDto) {
        return ResponseEntity.ok(service.createPlaceCategory(placeCategoryCreateDto));
    }

    @Override
    public ResponseEntity<PlaceCategoryDto> updatePlaceCategory(PlaceCategoryUpdateDto placeCategoryUpdateDto) {
        return ResponseEntity.ok(service.updatePlaceCategory(placeCategoryUpdateDto));
    }

    @Override
    public ResponseEntity<Page<PlaceCategoryDto>> getAllCategory(Pageable pageable) {
        return ResponseEntity.ok(service.getAllCategory(pageable));
    }
}
