package com.atiqaessayouti.bankingcqrs.commons.events;

public record AccountCreditedEvent(String accountId, double amount) {
}
