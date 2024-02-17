package com.mekanapp.mekanuserms.userprofile;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceTest {

    @Mock
    UserProfileRepository mockUserProfileRepository;

    @Mock
    UserProfileMapper mockUserProfileMapper;

    @InjectMocks
    UserProfileService underTest;

    @Test
    void createUserDetails() {
        //GIVEN
        LocalDate date = LocalDate.now();
        UserProfileCreateDto userProfileCreateDto = new UserProfileCreateDto(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"), "Yazılım Mühendisi", "05375959569" , date, "Erkek", "Yazılım", "Sessiz Mekan");
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileCreateDto, userProfile);

        LocalDateTime dateTime = LocalDateTime.now();
        UserProfile expectedUserProfile = new UserProfile();
        expectedUserProfile.setId(UUID.fromString("d0d72c34-787d-4176-90cf-994ff0857d91"));
        expectedUserProfile.setUserId(UUID.fromString("76dac035-6d77-4d9f-9304-405c6d669571"));
        expectedUserProfile.setBiography("Yazılım Mühendisi");
        expectedUserProfile.setPhoneNumber("05375959569");
        expectedUserProfile.setDateOfBirth(date);
        expectedUserProfile.setGender("Erkek");
        expectedUserProfile.setPleasures_and_hobbies("Yazılım");
        expectedUserProfile.setPreferred_places("Sessiz Mekan");
        expectedUserProfile.setCreatedDate(dateTime);
        expectedUserProfile.setUpdatedDate(dateTime);

        when(mockUserProfileRepository.save(userProfile)).thenReturn(expectedUserProfile);

        //WHEN
        UUID actualId = underTest.createUserDetails(userProfileCreateDto);

        //THEN
        assertEquals(expectedUserProfile.getUserId(), actualId);
    }

    @Test
    void getUserDetails() {
        //GIVEN
        UUID id = UUID.randomUUID();
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        UserProfile expectedUserProfile = new UserProfile();
        expectedUserProfile.setId(UUID.fromString("d0d72c34-787d-4176-90cf-994ff0857d91"));
        expectedUserProfile.setUserId(id);
        expectedUserProfile.setBiography("Yazılım Mühendisi");
        expectedUserProfile.setPhoneNumber("05375959569");
        expectedUserProfile.setDateOfBirth(date);
        expectedUserProfile.setGender("Erkek");
        expectedUserProfile.setPleasures_and_hobbies("Yazılım");
        expectedUserProfile.setPreferred_places("Sessiz Mekan");
        expectedUserProfile.setCreatedDate(dateTime);
        expectedUserProfile.setUpdatedDate(dateTime);


        when(mockUserProfileRepository.findByUserId(id)).thenReturn(expectedUserProfile);

        //WHEN
        UserProfileDto actual = underTest.getUserDetails(id);

        //THEN
        assertEquals(mockUserProfileMapper.toDto(expectedUserProfile), actual);
    }
}