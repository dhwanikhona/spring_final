package com.banking.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class SavingsTransaction {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int savingsTransactionId;
	private Date date;
	private BigDecimal availableBalance;
	private double transactionAmount;
	private String transactionType;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "savings_account_id")
    private SavingsAccount savingsAccount;
	
	public SavingsTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SavingsTransaction(Date date, BigDecimal availableBalance, double transactionAmount, String transactionType,SavingsAccount savingsAccount) {
		super();
		this.date = date;
		this.availableBalance = availableBalance;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.savingsAccount = savingsAccount;
	}


	public int getSavingsTransactionId() {
		return savingsTransactionId;
	}

	public void setSavingsTransactionId(int savingsTransactionId) {
		this.savingsTransactionId = savingsTransactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	
	
	
//	@Override
//	public String toString() {
//		return "SavingsTransaction [savingsTransactionId=" + savingsTransactionId + ", date=" + date
//				+ ", availableBalance=" + availableBalance + ", transactionAmount=" + transactionAmount
//				+ ", savingsAccount=" + savingsAccount + "]";
//	}
	


}

