package com.cg.WalletApplication.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.cg.WalletApplication.Exception.BankException;
import com.cg.WalletApplication.bean.Customer;

public interface IWalletRepo {


	String addCustomer(Customer customer);

	void beginTransaction();

	void commitTransaction();

	Customer showBalance(String mobileNum);

	Customer findCustomer(String mobileNum);

	void deposit(Customer customer, BigDecimal amount) throws SQLException, ClassNotFoundException, WalletException;

	boolean withdraw(Customer customer, BigDecimal amount) throws ClassNotFoundException, SQLException, WalletException;

	boolean customerExists(String receiverMobile);

	boolean transfer(String senderMobile, String receiverMobile, BigDecimal amount) throws ClassNotFoundException, SQLException, WalletException;

	String printTransactions(Customer customer) throws ClassNotFoundException, SQLException;

	

}
