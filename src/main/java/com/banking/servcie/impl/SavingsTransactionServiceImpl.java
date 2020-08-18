package com.banking.servcie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.SavingsTransactionDAO;
import com.banking.model.SavingsTransaction;
import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsTransactionService;


@Service
public class SavingsTransactionServiceImpl implements SavingsTransactionService {
	
    @Autowired
    private RegisterService registerService;
    
    @Autowired
    private SavingsTransactionDAO savingsTransactionDao;

    
    public List<SavingsTransaction> findSavingsTransactionList(String username) {
        User user = registerService.findByUsername(username);
        List<SavingsTransaction> savingsTransactionList = user.getSavingsAccount().getSavingsTransactionList();

        return savingsTransactionList;
    }
    
    public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction) {
        savingsTransactionDao.save(savingsTransaction);
    }
    
    public void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction) {
        savingsTransactionDao.save(savingsTransaction);
    }


}
