package com.mekanapp.mekanuserms.userprofile;

import com.mekanapp.mekanuserms.exception.ErrorMessages;
import com.mekanapp.mekanuserms.exception.UserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserProfileService {

    private final UserProfileRepository repository;
    private final UserProfileMapper userProfileMapper;

    public UUID createUserDetails(UserProfileCreateDto userProfileCreateDto) {
        UserProfile newUserProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileCreateDto, newUserProfile);

        UserProfile responseUserProfile = repository.save(newUserProfile);

        return responseUserProfile.getUserId();
    }

    public UserProfileDto getUserDetails(UUID userId) {
        UserProfile existUserProfile = repository.findByUserId(userId);

        if(existUserProfile == null) {
            throw UserException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.USER_NOT_FOUND);
        }

        return userProfileMapper.toDto(existUserProfile);
    }

}
