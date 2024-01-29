package com.mekanapp.mekanuserms.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public ResponseEntity<AccountDto> getAccountById(UUID id) {
        return ResponseEntity.ok(service.getAccount(id));
    }

    @Override
    public ResponseEntity<Page<AccountDto>> getAllAccounts(Pageable page, UUID id) {
        return ResponseEntity.ok(service.getAccounts(page, id));
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
