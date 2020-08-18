package com.banking.servcie;

import java.util.List;

import com.banking.model.SavingsTransaction;

public interface SavingsTransactionService {
	
    void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);
    void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction);
    List<SavingsTransaction> findSavingsTransactionList(String username);
}
