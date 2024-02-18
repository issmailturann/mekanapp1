package com.mekanapp.mekanuserms.onboarding;

import com.mekanapp.mekanuserms.place.PlaceCreateDto;
import com.mekanapp.mekanuserms.place.PlaceUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PlaceCategoryService {

    private final PlaceCategoryRepository repository;

    // Admin tarafından ulaşılıp kategori eklenebilecek. Auth ile admin erişimi verilmeli.
    public UUID createPlaceCategory(PlaceCreateDto placeCreateDto) {
        return null;
    }

    // Admin tarafından ulaşılıp kategorinin statusu passive edilerek ulaşıma kapatılabilir.
    public PlaceCategoryDto updatePlaceCategory(PlaceUpdateDto placeUpdateDto) {
        return null;
    }

    // Kullanıcıya dönecek kategoriler burada belirlenir.
    public PlaceCategoryDto getAllCategory() {
        return null;
    }

}
