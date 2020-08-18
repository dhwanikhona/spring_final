package com.banking.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SavingsTransfers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int savingsTransfersId;
	private Date date;
	private String recipient;
	private long recipientAccountNumber;
	private Double transferAmount;
	private String status;
	private String tranferflow;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "savings_account_id")
	private SavingsAccount savingsAccount;
	
	public SavingsTransfers() {
		// TODO Auto-generated constructor stub
	}



	public SavingsTransfers(Date date, String recipient, long recipientAccountNumber,
			Double transferAmount, String status, String tranferflow, SavingsAccount savingsAccount) {
		super();

		this.date = date;
		this.recipient = recipient;
		this.recipientAccountNumber = recipientAccountNumber;
		this.transferAmount = transferAmount;
		this.status = status;
		this.tranferflow = tranferflow;
		this.savingsAccount = savingsAccount;
	}



	public int getSavingsTransfersId() {
		return savingsTransfersId;
	}

	public void setSavingsTransfersId(int savingsTransfersId) {
		this.savingsTransfersId = savingsTransfersId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public long getRecipientAccountNumber() {
		return recipientAccountNumber;
	}

	public void setRecipientAccountNumber(long recipientAccountNumber) {
		this.recipientAccountNumber = recipientAccountNumber;
	}

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTranferflow() {
		return tranferflow;
	}

	public void setTranferflow(String tranferflow) {
		this.tranferflow = tranferflow;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}



	
	
}
