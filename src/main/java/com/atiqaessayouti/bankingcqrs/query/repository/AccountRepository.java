package com.atiqaessayouti.bankingcqrs.query.repository;

import com.atiqaessayouti.bankingcqrs.query.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
