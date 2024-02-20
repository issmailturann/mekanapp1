package com.mekanapp.mekanuserms.onboarding;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaceCategoryRepository extends JpaRepository<PlaceCategory, UUID> {

    PlaceCategory findByCategoryName(String categoryName);

    Page<PlaceCategory> findByStatus(String status, Pageable pageable);

}
