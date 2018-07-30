package com.cg.mypayment.pl;

import java.math.BigDecimal;
import java.util.Scanner;

import com.cg.mypayment.beans.Customer;
import com.cg.mypayment.beans.Wallet;
import com.cg.mypayment.exception.WalletException;
import com.cg.mypayment.service.WalletService;
import com.cg.mypayment.service.WalletServiceImpl;

public class Client {

	public static void main(String[] args) {
		WalletService service=new WalletServiceImpl();
		printdetails();
		boolean result=true;
		Scanner sc=new Scanner(System.in);
	int choice=0;
		
		do {
			Customer customer=new Customer();
			System.out.println("Enter Your Choice");
			
			choice=sc.nextInt();
			
	
				
			
		
			switch(choice) {
			case 1:
	
				try {
					
				System.out.println("Enter your mobile number");
				String mobile=sc.next().trim();
				service.validatePhone(mobile);
				customer.setMobileNo(mobile);
				
				System.out.println("Enter your name");
				String name=sc.next();
				service.validateName(name);
				customer.setName(name);
				
					System.out.println("Enter amount");
					BigDecimal balance=sc.nextBigDecimal();
					result=service.validateMoney(balance);
						customer.setBalance(balance);
						
						 Customer cust=service.createAccount(customer);
						 System.out.println("Your Account is created \n Your Details are");
						 System.out.println("Name:" +cust.getName());
						 System.out.println("Mobile:" +cust.getMobileNo());
						 System.out.println("Balance is: " +cust.getBalance());
					}catch(WalletException exception) {
						System.out.println(exception.getMessage());
					}
			
				 break;
				
			case 2:
				
				System.out.println("Enter your mobile number");
				String mobile1=sc.next().trim();
				//Customer cust1=service.showBalance(mobile1);
				//System.out.println("Your Balance is:" +cust1.getBalance());
				break;
			case 3:
				System.out.println("Enter target mobile Number");
				String mobile2=sc.next().trim();
				System.out.println("Enter your mobile number");
				String mobile3=sc.next().trim();
				
				System.out.println("Enter the amount u wanted to transfer");
				BigDecimal amount=sc.nextBigDecimal();
		
				
				Customer cust2=service.fundTransfer(mobile3, mobile2, amount);
				System.out.println(cust2.getName()+ "your balance after transfering is: " +cust2.getBalance());
				
				break;
			case 4:
				System.out.println("Enter your mobile number");
				String mobile4=sc.next().trim();
				System.out.println("Enter Amount you wanted to deposit");
				BigDecimal amount1=sc.nextBigDecimal();
				Customer cust3=service.depositAmount(mobile4, amount1);
				System.out.println(cust3.getName()+ " Your New Balance is: " +cust3.getBalance());
				break;
			case 5:
				System.out.println("Enter your mobile number");
				String mobile5=sc.next().trim();
				System.out.println("Enter Amount you wanted to withdraw");
				BigDecimal amount2=sc.nextBigDecimal();
				Customer cust4=service.withdrawAmount(mobile5, amount2);
				System.out.println("Amount after transaction is:" +cust4.getBalance());
				break;
			case 6:
				System.exit(0);
				
			default:
				System.out.println("Enter a valid choice");
			}
			
				
				
			
			
		}while(choice!=6);
			
	}

	private static void printdetails() {
		System.out.println("--welcome--");
		System.out.println(" \n 1.Register \n 2.ShowBalance \n 3.FundTransfer \n 4.Deposit \n 5.Withdraw");
	}

}
