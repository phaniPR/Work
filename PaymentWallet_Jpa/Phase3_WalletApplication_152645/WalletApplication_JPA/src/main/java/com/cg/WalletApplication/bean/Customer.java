package com.cg.WalletApplication.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

@Table(name="Customer_Wallet")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Mobile_No",length=10)
	private String mobileNumber;
	@Column(name="Customer_Name",length=30)
	private String name;
	
	@Embedded
	private Wallet wallet ;
	
	
/*	CREATE TABLE TRANSACTIONS
	(
	 ID int NOT NULL,
	 Mobile_no varchar2(10) references customer_wallet(MOBILE_NO),
	 TimeStampOfTrans Timestamp,
	 Type char(10),
	 Amount Number(19,2),
	  PRIMARY KEY (ID)
	);*/
	public Customer() {
		wallet = new Wallet();
		
	}
	



	public Customer(String mobileNumber, String name, String password, String emailId, Wallet wallet) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.wallet = wallet;
		
	}




	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}




	
	
	



}
