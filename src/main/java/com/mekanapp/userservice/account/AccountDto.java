package com.mekanapp.userservice.account;

import java.util.UUID;

public record AccountDto(
        UUID id,
        String firstName,
        String lastName,
        String username,
        String status
) {
}
