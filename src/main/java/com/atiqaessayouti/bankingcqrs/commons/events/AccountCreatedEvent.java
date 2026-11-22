package com.atiqaessayouti.bankingcqrs.commons.events;

import com.atiqaessayouti.bankingcqrs.commons.enums.AccountStatus;

public record AccountCreatedEvent(String accountId, double initialBalance, String currency, AccountStatus accountStatus) {
}
