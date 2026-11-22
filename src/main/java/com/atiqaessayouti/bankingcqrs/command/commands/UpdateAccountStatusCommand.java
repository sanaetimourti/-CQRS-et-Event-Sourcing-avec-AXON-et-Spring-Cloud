package com.atiqaessayouti.bankingcqrs.command.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.atiqaessayouti.bankingcqrs.commons.enums.AccountStatus;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter @AllArgsConstructor
public class UpdateAccountStatusCommand {
    @TargetAggregateIdentifier
    private String id;
    private AccountStatus accountStatus;
}
