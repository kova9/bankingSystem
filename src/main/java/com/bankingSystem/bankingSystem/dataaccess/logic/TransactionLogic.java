package com.bankingSystem.bankingSystem.dataaccess.logic;

import com.bankingSystem.bankingSystem.dataaccess.entity.Transaction;
import com.bankingSystem.bankingSystem.enums.AccountId;
import com.bankingSystem.bankingSystem.dto.TransactionDto;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class TransactionLogic {

    public Transaction create(TransactionDto dto){
        Transaction transaction = new Transaction();

        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setAmount(dto.getAmount());
        transaction.setMessage(dto.getMessage());
        transaction.setCurrencyId(dto.getCurrencyId());
        transaction.setSenderAccountId(AccountId.fromCode(dto.getSenderAccountId()).getAccount());
        transaction.setReceiverAccountId(AccountId.fromCode(dto.getReceiverAccountId()).getAccount());
        transaction.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        transaction.setStorno(false);

        return transaction;
    }
}
