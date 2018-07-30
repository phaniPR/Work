package com.cg.mypayment.service;

import java.math.BigDecimal;

import com.cg.mypayment.beans.Customer;
import com.cg.mypayment.exception.WalletException;

public interface WalletService {

	public Customer createAccount(Customer customer);
	public Customer showBalance(String mobileno) throws WalletException;
	public Customer fundTransfer(String sourceMobileNo,String targetMobileNo, BigDecimal amount);
	public Customer depositAmount(String mobileNo,BigDecimal amount);
	public Customer withdrawAmount(String mobileNo, BigDecimal amount);
	boolean validatePhone(String phoneNumber) throws WalletException;
	boolean validateMoney(BigDecimal balance) throws WalletException;
	boolean validateName(String name) throws WalletException;
}
