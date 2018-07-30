package com.cg.mypayment.beans;

import java.math.BigDecimal;

public class Customer extends Wallet{
	

	private String name;
	private String mobileNo;
	
	Wallet wallet;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(BigDecimal amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNo=" + mobileNo + ", wallet=" +wallet + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}



}
