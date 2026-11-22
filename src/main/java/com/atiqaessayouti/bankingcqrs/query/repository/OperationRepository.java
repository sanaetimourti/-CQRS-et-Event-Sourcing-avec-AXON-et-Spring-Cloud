package com.atiqaessayouti.bankingcqrs.query.repository;

import com.atiqaessayouti.bankingcqrs.query.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Long> {
 List<Operation> findByAccountId(String accountId);
}
