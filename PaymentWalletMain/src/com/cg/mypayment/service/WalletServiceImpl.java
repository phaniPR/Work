package com.cg.mypayment.service;

import java.math.BigDecimal;

import com.cg.mypayment.beans.Customer;
import com.cg.mypayment.exception.WalletException;
import com.cg.mypayment.repo.WalletRepo;
import com.cg.mypayment.repo.WalletRepoImpl;


public class WalletServiceImpl implements WalletService {

	WalletRepo repo=new WalletRepoImpl() ;
	public boolean validatePhone(String phone) throws WalletException {
		String pattern = "\\d{10}";
		if (!(phone.matches(pattern))) {
			throw new WalletException("enter valid phone number");
		}
		return true;
	}

	public boolean validateMoney(BigDecimal amount) throws WalletException {
		String amou = amount.toString();
		if (!(amou.matches("\\d+"))) {
			throw new WalletException("enter valid Amount");
		}
		return true;
	}

	public boolean validateName(String name) throws WalletException {
		if (!(name.matches("[a-zA-Z]+"))) {
			throw new WalletException("enter valid name");
		}
		return true;

	}
		
	@Override
	public Customer createAccount(Customer customer) {
		
		return repo.save(customer);
		
	}

	@Override
	public Customer showBalance(String mobileno) throws WalletException {
		
		try {
			if(!validatePhone(mobileno))
			{
				throw new WalletException("Enter a Valid Number");
			}
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			System.out.println("Enter a valid number");
		}
		return repo.showBalance(mobileno);
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return repo.fundTransfer(sourceMobileNo, targetMobileNo, amount);
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return repo.depositAmount(mobileNo, amount);
	}

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return repo.withdrawAmount(mobileNo, amount);
	}

}
