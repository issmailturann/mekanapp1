package com.mekanapp.mekanuserms.auth;

import com.mekanapp.mekanuserms.account.Account;
import com.mekanapp.mekanuserms.account.AccountRepository;
import com.mekanapp.mekanuserms.exception.AppException;
import com.mekanapp.mekanuserms.exception.ErrorMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account inDatabase = repository.findByUsername(username);

        if(inDatabase == null) {
            throw AppException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.USER_NOT_FOUND);
        }

        return inDatabase;
    }
}
