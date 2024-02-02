package com.mekanapp.mekanuserms.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Page<AccountDto> findByUsernameNot(String username, Pageable page);

    Account findByUsername(String username);

}
