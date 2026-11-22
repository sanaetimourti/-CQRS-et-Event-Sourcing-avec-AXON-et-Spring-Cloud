package com.atiqaessayouti.bankingcqrs.commons.dtos;

import lombok.*;
import com.atiqaessayouti.bankingcqrs.query.entities.OperationType;

import java.time.Instant;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OperationDTO {
    private Long id;
    private Instant date;
    private double amount;
    private OperationType type;
    private String accountId;
}
