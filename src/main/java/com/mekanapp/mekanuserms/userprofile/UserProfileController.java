package com.mekanapp.mekanuserms.userprofile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserProfileController implements UserProfileApi {

    private final UserProfileService service;

    @Override
    public ResponseEntity<UUID> createUserDetails(UserProfileCreateDto userProfileCreateDto) {
        return ResponseEntity.ok(service.createUserDetails(userProfileCreateDto));
    }

    @Override
    public ResponseEntity<UserProfileDto> getUserDetailsByUserId(UUID userId) {
        return ResponseEntity.ok(service.getUserDetails(userId));
    }
}
