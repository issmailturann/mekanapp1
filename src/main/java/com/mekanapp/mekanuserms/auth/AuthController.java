package com.mekanapp.mekanuserms.auth;

import com.mekanapp.mekanuserms.account.Account;
import com.mekanapp.mekanuserms.account.AccountDto;
import com.mekanapp.mekanuserms.account.AccountMapper;
import com.mekanapp.mekanuserms.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AccountRepository repository;
    private final AccountMapper accountMapper;

    @Override
    public AccountDto handleAuthentication(Account account) {
        return accountMapper.toDto(account);
    }
}
