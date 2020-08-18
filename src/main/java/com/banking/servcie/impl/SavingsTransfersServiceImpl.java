package com.banking.servcie.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.dao.SavingsAccountDAO;
import com.banking.dao.SavingsTransfersDAO;
import com.banking.model.SavingsAccount;
import com.banking.model.SavingsTransfers;
import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsTransfersService;

@Service
public class SavingsTransfersServiceImpl implements SavingsTransfersService{
	
	@Autowired
	private SavingsTransfersDAO savingsTransfersDao;
	
	@Autowired
	private SavingsAccountDAO savingsAccountDao;

	@Autowired
	private RegisterService registerService;
	
	

	@Override
	public void toSomeoneElseTransfer(long recipientAccountNumber,Double amount, String recipient,int savingsAccountId) {
		
//		User user = registerService.findByUsername(principal.getName());
		long userAccountNumber = savingsAccountDao.findById(savingsAccountId).get().getAccountNumber();
		
		BigDecimal amountToBeTransfered = new BigDecimal(amount);
		
		
		SavingsAccount userSavingsAccount = savingsAccountDao.findByAccountNumber(userAccountNumber);
		SavingsAccount recipientSavingsAccount = savingsAccountDao.findByAccountNumber(recipientAccountNumber);
		Date date = new Date();
		if(userSavingsAccount.getAccountBalance().compareTo(amountToBeTransfered)==1||userSavingsAccount.getAccountBalance().compareTo(amountToBeTransfered)==0) {
			userSavingsAccount.setAccountBalance(userSavingsAccount.getAccountBalance().subtract(amountToBeTransfered));
			
			if(recipientSavingsAccount!=null) {
				recipientSavingsAccount.setAccountBalance(recipientSavingsAccount.getAccountBalance().add(amountToBeTransfered));
				savingsAccountDao.save(recipientSavingsAccount);
				
				savingsAccountDao.save(userSavingsAccount);	
				SavingsTransfers savingsTransfers = new SavingsTransfers(date, recipient, recipientAccountNumber, amount,"Finsihed", "sent",userSavingsAccount);
				savingsTransfersDao.save(savingsTransfers);
				
				SavingsAccount sa = savingsAccountDao.findById(savingsAccountId).get();
				User user = registerService.findBySavingsAccount(sa);
				SavingsTransfers savingsTransfers1 = new SavingsTransfers(date,user.getFirstName() , userAccountNumber, amount,"Finsihed","recieved", recipientSavingsAccount);
				savingsTransfersDao.save(savingsTransfers1);
			}
			
			else {
				savingsAccountDao.save(userSavingsAccount);
				SavingsTransfers savingsTransfers = new SavingsTransfers(date, recipient, recipientAccountNumber, amount,"Finsihed","sent",userSavingsAccount);
				savingsTransfersDao.save(savingsTransfers);
			}	
			
			
			
		}else {
			SavingsTransfers savingsTransfers = new SavingsTransfers(date, recipient, recipientAccountNumber, amount,"Cancelled,Inadequate balance", "sent", userSavingsAccount);
			savingsTransfersDao.save(savingsTransfers);
		}
				
	}

	public List<SavingsTransfers> findSavingsTransfersList(String username) {
        User user = registerService.findByUsername(username);
        List<SavingsTransfers> savingsTransfersList = user.getSavingsAccount().getSavingsTransfersList();

        return savingsTransfersList;
    }
}
