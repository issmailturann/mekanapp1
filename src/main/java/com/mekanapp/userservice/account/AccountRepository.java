package com.mekanapp.userservice.account;

import com.mekanapp.userservice.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {



}
