package com.mekanapp.userservice.service;

import com.mekanapp.userservice.constant.AccountStatuses;
import com.mekanapp.userservice.dto.AccountCreateDto;
import com.mekanapp.userservice.model.Account;
import com.mekanapp.userservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class AccountService {

    private final AccountRepository repository;

    public UUID createUser(AccountCreateDto accountCreateDto) {
        Account newAccount = new Account();
        BeanUtils.copyProperties(accountCreateDto, newAccount);
        newAccount.setStatus(AccountStatuses.ACTIVE.toString());
        Account responseAccount = repository.save(newAccount);
        return responseAccount.getId();
    }

}
