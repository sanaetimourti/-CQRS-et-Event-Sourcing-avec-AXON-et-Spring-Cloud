package com.atiqaessayouti.bankingcqrs.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.atiqaessayouti.bankingcqrs.query.entities.Account;
import com.atiqaessayouti.bankingcqrs.query.entities.Operation;

import java.util.List;
@AllArgsConstructor @Getter
public class AccountStatement {
    private Account account;
    private List<Operation> operations;
}
