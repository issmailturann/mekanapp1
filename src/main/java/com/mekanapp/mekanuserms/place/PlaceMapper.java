package com.mekanapp.mekanuserms.place;

import com.mekanapp.mekanuserms.shared.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper extends BaseMapper<Place, PlaceDto> {
}
