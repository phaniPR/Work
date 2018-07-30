package com.cg.WalletApplication.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.cg.WalletApplication.Exception.BankException;
import com.cg.WalletApplication.bean.Customer;

public interface IWalletService {


	void checkName(String name) throws BankException;

	void checkMobileNumber(String mobileNumber) throws BankException;

	String addCustomer(Customer customer) throws BankException;

	Customer showBalance(String mobileNum) throws BankException;

	Customer check(String mobileNum) throws BankException;

	void deposit(Customer customer, BigDecimal amount) throws ClassNotFoundException, SQLException, BankException;

	boolean withDraw(Customer customer, BigDecimal amount) throws BankException, ClassNotFoundException, SQLException;

	boolean isFound(String receiverMobile) throws BankException;

	boolean transfer(String senderMobile, String receiverMobile, BigDecimal amount) throws InterruptedException, BankException, ClassNotFoundException, SQLException;

	String printTransactions(Customer customer) throws ClassNotFoundException, SQLException;

}
