package com.mekanapp.userservice.account;

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
