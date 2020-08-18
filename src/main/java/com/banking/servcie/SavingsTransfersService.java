package com.banking.servcie;

import java.security.Principal;
import java.util.List;

import com.banking.model.SavingsTransfers;

public interface SavingsTransfersService {
	
	public List<SavingsTransfers> findSavingsTransfersList(String username);

	public void toSomeoneElseTransfer(long receiverAccountNumber,Double amount,String recipient,int savingsAccountId);

}
