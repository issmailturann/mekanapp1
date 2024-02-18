package com.mekanapp.mekanuserms.onboarding;

import com.mekanapp.mekanuserms.shared.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceCategoryMapper extends BaseMapper<PlaceCategory, PlaceCategoryDto> {
}
