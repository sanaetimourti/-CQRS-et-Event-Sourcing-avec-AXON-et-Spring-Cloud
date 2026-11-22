package com.atiqaessayouti.bankingcqrs.query.handlers;

import lombok.extern.slf4j.Slf4j;
import com.atiqaessayouti.bankingcqrs.commons.dtos.AccountStatement;
import com.atiqaessayouti.bankingcqrs.query.dtos.AccountEvent;
import com.atiqaessayouti.bankingcqrs.query.entities.Account;
import com.atiqaessayouti.bankingcqrs.query.entities.Operation;
import com.atiqaessayouti.bankingcqrs.query.queries.GetAccountStatement;
import com.atiqaessayouti.bankingcqrs.query.queries.GetAllAccounts;
import com.atiqaessayouti.bankingcqrs.query.queries.WatchEventQuery;
import com.atiqaessayouti.bankingcqrs.query.repository.AccountRepository;
import com.atiqaessayouti.bankingcqrs.query.repository.OperationRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountQueryHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    public AccountQueryHandler(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }
    @QueryHandler
    public List<Account> on(GetAllAccounts query){
        return accountRepository.findAll();
    }
    @QueryHandler
    public AccountStatement on(GetAccountStatement query){
        Account account = accountRepository.findById(query.getAccountId()).get();
        List<Operation> operations = operationRepository.findByAccountId(query.getAccountId());
        return new AccountStatement(account, operations);
    }

    @QueryHandler
    public AccountEvent on(WatchEventQuery query){
        return AccountEvent.builder().build();
    }


}
