package com.atiqaessayouti.bankingcqrs.commons.events;

public record AccountDebitedEvent(String accountId, double amount) {
}
