package com.atiqaessayouti.bankingcqrs.commons.events;

import com.atiqaessayouti.bankingcqrs.commons.enums.AccountStatus;

public record AccountStatusUpdatedEvent(String accountId, AccountStatus fromStatus, AccountStatus toStatus) {
}
