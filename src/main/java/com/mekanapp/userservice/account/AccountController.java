package com.mekanapp.userservice.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @Override
    public ResponseEntity<AccountDto> getAccountById(UUID id) {
        return ResponseEntity.ok(service.getAccount(id));
    }

    @Override
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(service.getAccounts());
    }

    @Override
    public ResponseEntity<AccountDto> updateAccountById(UUID id, AccountUpdateDto accountUpdateDto) {
        return ResponseEntity.ok(service.updateAccount(id, accountUpdateDto));
    }

    @Override
    public ResponseEntity<Boolean> deleteAccountById(UUID id) {
        return ResponseEntity.ok(service.deleteAccount(id));
    }
}
