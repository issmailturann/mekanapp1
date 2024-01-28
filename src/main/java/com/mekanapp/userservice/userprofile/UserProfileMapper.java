package com.mekanapp.userservice.userprofile;

import com.mekanapp.userservice.shared.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper extends BaseMapper<UserProfile, UserProfileDto> {



}
