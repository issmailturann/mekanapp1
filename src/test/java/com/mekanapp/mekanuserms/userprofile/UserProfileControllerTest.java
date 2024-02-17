package com.mekanapp.mekanuserms.userprofile;

import com.mekanapp.mekanuserms.place.PlaceCreateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserProfileControllerTest {

    @Mock
    UserProfileService mockUserProfileService;

    @InjectMocks
    UserProfileController underTest;

    @Test
    void createUserDetails() {
        //GIVEN
        LocalDate date = LocalDate.now();
        UserProfileCreateDto userProfileCreateDto = new UserProfileCreateDto(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"), "Yazılım Mühendisi", "05375959569" , date, "Erkek", "Yazılım", "Sessiz Mekan");
        UUID expectedId = UUID.randomUUID();

        when(mockUserProfileService.createUserDetails(userProfileCreateDto)).thenReturn(expectedId);

        //WHEN
        ResponseEntity<UUID> actualId = underTest.createUserDetails(userProfileCreateDto);

        //THEN
        assertEquals(expectedId, actualId.getBody());
    }

    @Test
    void getUserDetailsByUserId() {
        //GIVEN
        UUID userId = UUID.randomUUID();
        LocalDateTime dateTime = LocalDateTime.now();
        UserProfileDto expectedUserProfileDto = new UserProfileDto(userId, "Yazılım Mühendisi", "Yazılım", "Sessiz Mekan", dateTime);

        when(mockUserProfileService.getUserDetails(userId)).thenReturn(expectedUserProfileDto);

        //WHEN
        ResponseEntity<UserProfileDto> actual = underTest.getUserDetailsByUserId(userId);

        //THEN
        assertEquals(expectedUserProfileDto, actual.getBody());
    }
}