package com.mekanapp.mekanuserms.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Mock
    AccountService mockAccountService;

    @InjectMocks
    AccountController underTest;

    @Test
    void createAccount() {
        //GIVEN
        AccountCreateDto accountCreateDto = new AccountCreateDto("Mehmet Baran", "Özdeniz", "ozdeniz.mb", "159753");
        UUID expectedId = UUID.randomUUID();

        when(mockAccountService.createUser(accountCreateDto)).thenReturn(expectedId);

        //WHEN
        ResponseEntity<UUID> actualId = underTest.createAccount(accountCreateDto);

        //THEN
        assertEquals(expectedId, actualId.getBody());

    }

    @Test
    void getAccountById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        AccountDto expected = new AccountDto(id, "Mehmet Baran", "Özdeniz", "ozdeniz.mb", "ACTIVE");

        when(mockAccountService.getAccount(id)).thenReturn(expected);

        //WHEN
        ResponseEntity<AccountDto> actual = underTest.getAccountById(id);

        //THEN
        assertEquals(expected, actual.getBody());
    }

    @Test
    void getAllAccounts() {
        //GIVEN
        //WHEN
        //THEN
    }

    @Test
    void updateAccountById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        AccountUpdateDto accountUpdateDto = new AccountUpdateDto("Baran", "Ozdeniz", "123456");
        AccountDto expected = new AccountDto(id, "Baran", "Ozdeniz", "ozdeniz.mb", "ACTIVE");

        when(mockAccountService.updateAccount(id, accountUpdateDto)).thenReturn(expected);

        //WHEN
        ResponseEntity<AccountDto> actual = underTest.updateAccountById(id, accountUpdateDto);

        //THEN
        assertEquals(expected, actual.getBody());
    }

    @Test
    void deleteAccountById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        when(mockAccountService.deleteAccount(id)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> result = underTest.deleteAccountById(id);

        //THEN
        assertEquals(Boolean.TRUE, result.getBody());
    }
}