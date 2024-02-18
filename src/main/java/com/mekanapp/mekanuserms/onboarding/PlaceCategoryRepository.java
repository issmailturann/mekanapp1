package com.mekanapp.mekanuserms.onboarding;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaceCategoryRepository extends JpaRepository<PlaceCategory, UUID> {
}
