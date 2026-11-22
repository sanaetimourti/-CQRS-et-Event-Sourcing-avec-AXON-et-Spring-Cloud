package com.atiqaessayouti.bankingcqrs.command.aggregates;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import com.atiqaessayouti.bankingcqrs.command.commands.CreateAccountCommand;
import com.atiqaessayouti.bankingcqrs.command.commands.CreditAccountCommand;
import com.atiqaessayouti.bankingcqrs.command.commands.DebitAccountCommand;
import com.atiqaessayouti.bankingcqrs.command.commands.UpdateAccountStatusCommand;
import com.atiqaessayouti.bankingcqrs.commons.enums.AccountStatus;
import com.atiqaessayouti.bankingcqrs.commons.events.AccountCreatedEvent;
import com.atiqaessayouti.bankingcqrs.commons.events.AccountCreditedEvent;
import com.atiqaessayouti.bankingcqrs.commons.events.AccountDebitedEvent;
import com.atiqaessayouti.bankingcqrs.commons.events.AccountStatusUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
//@Entity
@Slf4j
@Getter @Setter
public class AccountAggregate {
    @AggregateIdentifier
    //@Id
    private String accountId ;
    private double currentBalance;
    private String currency;
    private AccountStatus status;


    public AccountAggregate() {
        log.info("Account Aggregate Created");
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        log.info("CreateAccount Command Received");
        if (command.getInitialBalance()<0) throw  new IllegalArgumentException("Balance negative exception");
        AggregateLifecycle.apply(new AccountCreatedEvent(
           command.getId(),
           command.getInitialBalance(),
           command.getCurrency(),
           AccountStatus.CREATED
        ));

    }

    @CommandHandler
    public void handleCommand(DebitAccountCommand command){
        log.info("DebitAccountCommand Command Received");
        if (!this.getStatus().equals(AccountStatus.ACTIVATED)) throw  new RuntimeException("This account can not be debited because of the account is not activated. The current status is "+status);
        if (command.getAmount()>currentBalance) throw  new RuntimeException("Balance not sufficient exception");
        AggregateLifecycle.apply(new AccountDebitedEvent(
                command.getId(),
                command.getAmount()
        ));
    }
    @CommandHandler
    public void handleCommand(CreditAccountCommand command){
        log.info("CreditAccountCommand Command Received");
        if (!this.getStatus().equals(AccountStatus.ACTIVATED)) throw  new RuntimeException("This account can not be debited because of the account is not activated. The current status is "+status);
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getId(),
                command.getAmount()
        ));
    }
    @CommandHandler
    public void handleCommand(UpdateAccountStatusCommand command){
        log.info("UpdateAccountStatusCommand Command Received");
        if (this.getStatus().equals(command.getAccountStatus())) throw  new RuntimeException("This account is already the "+status+ " state");
        AggregateLifecycle.apply(new AccountStatusUpdatedEvent(
                command.getId(),
                status,
                command.getAccountStatus()
        ));
    }
    @EventSourcingHandler
    //@EventHandler
    public void on(AccountCreatedEvent event){
        log.info("AccountCreatedEvent occured");
        this.accountId =event.accountId();
        this.currentBalance = event.initialBalance();
        this.currency = event.currency();
        this.status = event.accountStatus();
    }
    @EventSourcingHandler
    //@EventHandler
    public void on(AccountDebitedEvent event){
        log.info("AccountDebitedEvent occured");
        this.accountId =event.accountId();
        this.currentBalance = this.currentBalance - event.amount();
    }
    @EventSourcingHandler
    //@EventHandler
    public void on(AccountCreditedEvent event){
        log.info("AccountCreditedEvent occured");
        this.accountId =event.accountId();
        this.currentBalance = this.currentBalance + event.amount();
    }

    @EventSourcingHandler
    //@EventHandler
    public void on(AccountStatusUpdatedEvent event){
        log.info("AccountStatusUpdatedEvent occured");
        this.accountId =event.accountId();
        this.status = event.toStatus();
    }


}
