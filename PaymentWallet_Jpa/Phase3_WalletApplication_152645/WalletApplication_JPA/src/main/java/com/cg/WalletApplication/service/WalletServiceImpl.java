package com.cg.WalletApplication.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.WalletApplication.Exception.BankException;
import com.cg.WalletApplication.Exception.IBankException;
import com.cg.WalletApplication.bean.Customer;
import com.cg.WalletApplication.dao.IWalletDao;
import com.cg.WalletApplication.dao.WalletDaoImpl;

public class WalletServiceImpl implements IWalletService {
	static IWalletRepo iWalletRepo = null;

	static {

		iWalletRepo = new WalletRepo();
	}

	public void validateName(String name) throws WalletException {
		Pattern pattern = Pattern.compile("[a-zA-Z]{1,}");
		Matcher matcher = pattern.matcher(name);
		if (!(matcher.matches())) {
			throw new WalletException(IWalletException.nameException);
		}
	}

	public void validateMobile(String mobileNumber) throws WalletException {

		Pattern pattern = Pattern.compile("[7-9]{1}[0-9]{9}");
		Matcher matcher = pattern.matcher(mobileNumber);
		if (!(matcher.matches())) {
			throw new WalletException(IBankException.mobileNumberException);
		}
	}


	public String addCustomer(Customer customer) throws WalletException {
		String result = null;
		iWalletDao.beginTransaction();
		result = iWalletRepo.addCustomer(customer);
		iWalletRepo.commitTransaction();

		/*
		 * else throw new BankException(IBankException.ACCOUNTEXISTS);
		 */
		return result;
	}

	public Customer showBalance(String mobileNum, String password) throws WalletException {
		Customer result = null;
		result = iWalletRepo.showBalance(mobileNum, password);

		if (result == null)
			throw new WalletException(IWalletException.invalidDetails);

		return result;
	}

	public Customer check(String mobileNum) throws WalletException {
		Customer result = null;
		result = iWalletRepo.findCustomer(mobileNum);

		if (result == null)
			throw new WalletException(IBankException.invalidDetails);
		return result;
	}

	public void deposit(Customer customer, BigDecimal amount)
			throws ClassNotFoundException, SQLException, WalletException {
		iWalletRepo.beginTransaction();
		iWalletRepo.deposit(customer, amount);
		iWalletRepo.commitTransaction();

	}

	public boolean withDraw(Customer customer, BigDecimal amount)
			throws WalletException, ClassNotFoundException, SQLException {
		boolean result = false;
		iWalletRepo.beginTransaction();
		result = iWalletRepo.withdraw(customer, amount);
		iWalletDao.commitTransaction();
		if (result == false) {
			throw new WalletException(IWalletException.insufficientFunds);
		}
		return result;
	}

	public boolean isFound(String receiverMobile) throws WalletException {
		boolean result = false;
		iWalletRepo.beginTransaction();
		if (iWalletRepo.customerExists(receiverMobile)) {
			result = true;
		}
		iWalletRepo.commitTransaction();
		if (result == false)
			throw new WalletException(IWalletException.mobileNumberNotExists);

		return result;
	}

	public boolean transfer(String senderMobile, String receiverMobile, BigDecimal amount)
			throws InterruptedException, WalletException, ClassNotFoundException, SQLException {
		
		boolean result=false;
	
		iWalletRepo.beginTransaction();
		result=iWalletRepo.transfer(senderMobile,receiverMobile,amount);
		iWalletRepo.commitTransaction();
		return result;
	}

	public String printTransactions(Customer customer) throws ClassNotFoundException, SQLException {
		
		iWalletRepo.beginTransaction();
	    String builder = iWalletRepo.printTransactions(customer);
		iWalletRepo.commitTransaction();
		return builder;
	}



}
