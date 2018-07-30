package com.cg.mypayment.repo;

import java.math.BigDecimal;

import com.cg.mypayment.beans.Customer;
import com.cg.mypayment.exception.WalletException;

public interface WalletRepo {
	
	public Customer save(Customer customer);
	public Customer showBalance(String mobileno) throws WalletException;
	public Customer fundTransfer(String sourceMobileNo,String targetMobileNo, BigDecimal amount);
	public Customer depositAmount(String mobileNo,BigDecimal amount);
	public Customer withdrawAmount(String mobileNo, BigDecimal amount);
}
