package com.mekanapp.userservice.controller;

import com.mekanapp.userservice.dto.AccountCreateDto;
import com.mekanapp.userservice.service.AccountService;
import com.mekanapp.userservice.api.AccountApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {

    private final AccountService service;

    @Override
    public ResponseEntity<UUID> createAccount(AccountCreateDto accountCreateDto) {
        return ResponseEntity.ok(service.createUser(accountCreateDto));
    }
}
