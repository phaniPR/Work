package com.cg.mypayment.repo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.cg.mypayment.beans.Customer;
import com.cg.mypayment.exception.WalletException;



public class WalletRepoImpl implements WalletRepo {

	public static HashMap<String,Customer> account=new HashMap<>();
	 public static Map<String,String> transactions=new HashMap<String, String>();
	
	
	@Override
	public Customer save(Customer customer) {
		
		 account.put(customer.getMobileNo(),customer );
		
		 
		 return customer;
	}


	@Override
	public Customer showBalance(String mobileno) throws WalletException {
		Customer customer=account.get(mobileno);
        if(customer!=null)
        {
            return customer;
        }
        else
        {
        	 throw new WalletException("Account with given Mobile number doesn't exist" );
        }
	}


	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
	
		Customer customer=account.get(sourceMobileNo);
		Customer customer2=account.get(targetMobileNo);
		if(customer!=null && customer2!=null) {
			BigDecimal high=(customer.getBalance()).max(amount);
			if(customer.getBalance()==high) {
				BigDecimal upadetBalance=customer.getBalance().subtract(amount);
				customer.setBalance(upadetBalance);
				BigDecimal updateBalance1=customer2.getBalance().add(amount);
				customer2.setBalance(updateBalance1);
			}
		

		}
		return customer;
	}


	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
	
		Customer customer=account.get(mobileNo);
		if(customer!=null)
		{
			BigDecimal deposit=customer.getBalance().add(amount);
			customer.setBalance(deposit);
		}
		
		
		return customer;
	}


	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		Customer customer=account.get(mobileNo);
	
		BigDecimal big=customer.getBalance().max(amount);
        if(customer.getBalance()==big){
        	BigDecimal newbal=customer.getBalance().subtract(amount);
        	customer.setBalance(newbal);
        }
	
return customer;

	}
}
