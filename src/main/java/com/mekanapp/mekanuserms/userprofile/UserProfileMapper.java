package com.mekanapp.mekanuserms.userprofile;

import com.mekanapp.mekanuserms.shared.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper extends BaseMapper<UserProfile, UserProfileDto> {



}
