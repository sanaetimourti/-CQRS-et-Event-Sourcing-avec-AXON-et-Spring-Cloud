package com.atiqaessayouti.bankingcqrs.commons.dtos;

import com.atiqaessayouti.bankingcqrs.commons.enums.AccountStatus;

public record UpdateAccountStatusDTO(String accountId, AccountStatus accountStatus) {
}
