package com.mekanapp.mekanuserms.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    AccountRepository mockAccountRepository;

    @Mock
    AccountMapper mockAccountMapper;

    @InjectMocks
    AccountService underTest;

    @Test
    void createUser() {

        //GIVEN
        AccountCreateDto accountCreateDto = new AccountCreateDto("Mehmet Baran", "Özdeniz", "ozdeniz.mb", "159753");
        Account account = new Account();
        BeanUtils.copyProperties(accountCreateDto, account);
        account.setStatus("ACTIVE");
        UUID id = UUID.randomUUID();

        Account returnedAccount = new Account();
        returnedAccount.setId(id);
        returnedAccount.setFirstName("Mehmet Baran");
        returnedAccount.setLastName("Özdeniz");
        returnedAccount.setUsername("ozdeniz.mb");
        returnedAccount.setPassword("159753");
        returnedAccount.setStatus("ACTIVE");

        when(mockAccountRepository.save(account)).thenReturn(returnedAccount);

        //WHEN
        UUID actual = underTest.createUser(accountCreateDto);

        System.out.println(returnedAccount.getId());
        System.out.println(actual);

        //THEN
        assertEquals(returnedAccount.getId(), actual);

    }

    @Test
    void getAccount() {

        //GIVEN
        UUID id = UUID.randomUUID();
        AccountDto expected = new AccountDto(id, "Mehmet Baran", "Özdeniz", "ozdeniz.mb", "ACTIVE");

        Account existAccount  = new Account();
        existAccount.setId(id);
        existAccount.setFirstName("Mehmet Baran");
        existAccount.setLastName("Özdeniz");
        existAccount.setUsername("ozdeniz.mb");
        existAccount.setPassword("159753");
        existAccount.setStatus("ACTIVE");

        when(mockAccountRepository.findById(id)).thenReturn(Optional.of(existAccount));
        when(mockAccountMapper.toDto(existAccount)).thenReturn(expected);

        //WHEN
        AccountDto actual = underTest.getAccount(id);

        System.out.println(expected);
        System.out.println(actual);

        //THEN
        assertEquals(expected, actual);

    }

    @Test
    void getAccounts() {
/*
        //GIVEN
        UUID id = UUID.randomUUID();
        Pageable pageable = mock(Pageable.class);

        Account existAccount  = new Account();
        existAccount.setId(id);
        existAccount.setFirstName("Mehmet Baran");
        existAccount.setLastName("Özdeniz");
        existAccount.setUsername("ozdeniz.mb");
        existAccount.setPassword("159753");
        existAccount.setStatus("ACTIVE");

        Page<AccountDto> expected = mock(Page.class);

        when(mockAccountRepository.findById(id)).thenReturn(Optional.of(existAccount));
        when(mockAccountRepository.findByUsernameNot(existAccount.getUsername(), pageable)).thenReturn(expected);

        Page<AccountDto> actual = underTest.getAccounts(pageable, id);

        assertEquals(expected, actual);
*/

    }

    @Test
    void updateAccount() {

        //GIVEN
        UUID id = UUID.randomUUID();
        AccountUpdateDto accountUpdateDto = new AccountUpdateDto("Baran", "Ozdeniz", "123456");

        Account existAccount  = new Account();
        existAccount.setId(id);
        existAccount.setFirstName("Mehmet Baran");
        existAccount.setLastName("Özdeniz");
        existAccount.setUsername("ozdeniz.mb");
        existAccount.setPassword("159753");
        existAccount.setStatus("ACTIVE");

        Account excepted  = new Account();
        excepted.setId(id);
        excepted.setFirstName("Baran");
        excepted.setLastName("Ozdeniz");
        excepted.setUsername("ozdeniz.mb");
        excepted.setPassword("123456");
        excepted.setStatus("ACTIVE");

        when(mockAccountRepository.findById(id)).thenReturn(Optional.of(existAccount));
        BeanUtils.copyProperties(accountUpdateDto, existAccount);
        when(mockAccountRepository.save(existAccount)).thenReturn(excepted);

        //WHEN
        AccountDto actual = underTest.updateAccount(id, accountUpdateDto);

        //THEN
        assertEquals(mockAccountMapper.toDto(excepted), actual);

    }

    @Test
    void deleteAccount() {

        //GIVEN
        UUID id = UUID.randomUUID();

        Account existAccount  = new Account();
        existAccount.setId(id);
        existAccount.setFirstName("Mehmet Baran");
        existAccount.setLastName("Özdeniz");
        existAccount.setUsername("ozdeniz.mb");
        existAccount.setPassword("159753");
        existAccount.setStatus("ACTIVE");

        when(mockAccountRepository.findById(id)).thenReturn(Optional.of(existAccount));

        //WHEN
        boolean result = underTest.deleteAccount(id);

        //THEN
        assertTrue(result);

    }
}