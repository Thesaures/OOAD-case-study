package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsAccount;
import com.ilp.entity.Service;

public class BankService {

	public static void createService(ArrayList<Service> serviceList) {
		Scanner scanner = new Scanner(System.in);
		char serviceChoice;
		do {
		System.out.println("Service Code");
		String serviceCode = scanner.nextLine();
		System.out.println("Service Name");
		String serviceName = scanner.nextLine();
		System.out.println("Service Rate");
		int  serviceRate = scanner.nextInt();
		scanner.nextLine();
		Service service = new Service(serviceCode,serviceName, serviceRate);
		serviceList.add(service);
		System.out.println("do you want to create another service?(y/n)");
		serviceChoice = scanner.next().charAt(0);
		scanner.nextLine();
		}while(serviceChoice == 'y');
	}

	public static void createProduct(ArrayList<Service> serviceList, ArrayList<Product> productList) {
		ArrayList<Service> productServiceList= new ArrayList<Service>();
		Scanner scanner = new Scanner(System.in);
		char productChoice;
		do {
			System.out.println("Enter Product Name");
			String productName = scanner.nextLine();
			System.out.println("Enter Product Code");
			String productCode = scanner.nextLine();
			
			// list services
			for(Service service :serviceList) {
				System.out.println(service.getServiceName());
			}
			
			char serviceChoice;
			// enter the service
			do {
			System.out.println("Enter the service name you want");
			String serviceName = scanner.nextLine();
			for(Service service :serviceList) {
				if(serviceName.equalsIgnoreCase(service.getServiceName())) {
					productServiceList.add(service);
				}
			}if(productName.equals("SavingsAccount")) {
	        	
	        	Product product = new SavingsAccount(productCode,productName, productServiceList);
	        	productList.add(product);
	        	System.out.println("product "+product);
	        	System.out.println("productList "+productList);
	        }
	        else if(productName.equals("CurrentAccount")) {
	        	
	        	Product product = new CurrentAccount(productCode,productName, productServiceList);
	        	productList.add(product);
	        }
	        else
	        {
	        	if(productName.equals("LoanAccount")) {
	            	
	            	Product product = new LoanAccount(productCode,productName, productServiceList);
	            	productList.add(product);
	            }
	        }
			
			
			System.out.println("Do you want to add another service ??(y/n)");
			serviceChoice = scanner.next().charAt(0);
			scanner.nextLine();
			}while(serviceChoice == 'y');
			System.out.println("Do you want to add another service ??(y/n)");
			productChoice = scanner.next().charAt(0);
			scanner.nextLine();
		}while(productChoice == 'y');
        
        
		
	}

	public static Customer createCustomer(ArrayList<Product> productList, Customer customer) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accountList = new ArrayList<Account>();
		System.out.println("Enter the customer ID : ");
		String customerId = scanner.nextLine();
		System.out.println("Customer Id not available.Create a new Account");
		char accountChoice;
		do {
		System.out.println("Wchich account do you want");
		for(Product product:productList) {
			System.out.println(product.getProductName());
		}
		int productChoice = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter account number");
		String accountNo = scanner.nextLine();
		System.out.println("Enter account type");
		String accountType = scanner.nextLine();
		System.out.println("Enter account balance");
		double balance = scanner.nextDouble();
		scanner.nextLine();
		Account account;
		switch(productChoice) {
		case 1:
			account = new Account(accountNo, accountType,balance,productList.get(0));
			accountList.add(account);
			System.out.println("Savings Account Created");
			break;
		case 2:
			account = new Account(accountNo, accountType,balance,productList.get(1));
			accountList.add(account);
			System.out.println("current account Account Created");
			break;
		case 3:
			account = new Account(accountNo, accountType,balance,productList.get(2));
			accountList.add(account);
			System.out.println("loan account Account Created");
			break;
		 
		}System.out.println("Do you want to create another Account?(y/n)");
		accountChoice = scanner.next().charAt(0);
		}while(accountChoice == 'y');
		
		System.out.println("Customer Code");
		scanner.nextLine();
		String customerCode = scanner.nextLine();
		System.out.println("Customer Name");
		String customerName = scanner.nextLine();
		customer= new Customer(customerCode,customerName,accountList);
		return customer;
		
		
		
}

	public static void manageAccounts(Customer customer) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the customer ID : ");
//		String customerId = scanner.nextLine();
		System.out.println();
		ArrayList<Account> accountList =new ArrayList<Account>() ;
		for(Account account :customer.getAccountList()) {
			accountList=customer.getAccountList();
			System.out.println(account.getAccountType());
		}
		System.out.println("Which type Account do you want?");
		String accountName = scanner.nextLine();
	    for(Account account :accountList) {
			if(account.getAccountType().equals(accountName)) {
				manageCustomerAccount(account);
			}
		}
	}

	private static void manageCustomerAccount(Account account) {
		Scanner scanner = new Scanner(System.in);
		if(account.getProduct() instanceof SavingsAccount || account.getProduct() instanceof CurrentAccount) {
			System.out.println("1.Deposit 2.Withdraw 3.Display Balance");
			int savingsChoice = scanner.nextInt();
			switch(savingsChoice) {
			case 1:
				deposit(account);
				break;
			case 2:
				withdraw(account);
				break;
			case 3:
				System.out.println("Your Account balance is : "+account.getBalance());
				break;
			}
		}
		else {
			System.out.println("1.Deposit 2.Display Balance");
			int savingsChoice = scanner.nextInt();
			switch(savingsChoice) {
			case 1:
				deposit(account);
				break;
			case 2:
				System.out.println("Your Account balance is : "+account.getBalance());
				break;
			}
			
		}
		
	}

	private static void withdraw(Account account) {
		Scanner scanner = new Scanner(System.in);
		if(account.getProduct() instanceof SavingsAccount) {
			System.out.println("enter the amount you want to withdraw :");
			double withdrawMoney = scanner.nextDouble() ;
			double savingsBalance =  account.getBalance() ;
			SavingsAccount savingsAccount = (SavingsAccount) account.getProduct();
			double balanceMoney = savingsBalance-withdrawMoney;
			if(balanceMoney<savingsAccount.getMinimumBalance()) {
				System.out.println("Sorry!!!!!!!!!!!!! A mininmum balance of Rs 1000 should be mainted in the account.");
			}
			else {
				account.setBalance(balanceMoney);
				System.out.println("Your balance is: "+account.getBalance());
			}
		}
	    else {
			System.out.println("enter the amount you want to withdraw :");
			double withdrawMoney = scanner.nextDouble() ;
			double currentBalance =  account.getBalance() ;
			double balanceMoney = currentBalance-withdrawMoney;
			if(currentBalance < withdrawMoney) {
				System.out.println("Insufficient balance.");
			}
			else {
				account.setBalance(balanceMoney);
				System.out.println("Your balance is: "+account.getBalance());
			}
		}
		
	}

	private static void deposit(Account account) {
		Scanner scanner = new Scanner(System.in);
		if(account.getProduct() instanceof SavingsAccount || account.getProduct() instanceof CurrentAccount) {
			System.out.println("enter the amount you want to deposit :");
			double depositMoney = scanner.nextDouble() ;
			double currentBalance =  account.getBalance() ;
			currentBalance = currentBalance+depositMoney;
			account.setBalance(currentBalance);
			System.out.println("Your balance is: "+account.getBalance());
		}
		else {
			System.out.println("enter the amount you want to deposit :");
			double depositMoney = scanner.nextDouble() ;
			double currentBalance =  account.getBalance() ;
			System.out.println("Which way you deposit?(1.cash 2.cheque)");
			int depositWay = scanner.nextInt();
			switch(depositWay) {
			case 1:
				depositMoney = scanner.nextDouble() ;
				currentBalance =  account.getBalance() ;
				currentBalance = currentBalance+depositMoney;
				account.setBalance(currentBalance);
				System.out.println("Your balance is: "+account.getBalance());
				break;
			case 2:
				LoanAccount loanAccount = (LoanAccount)account.getProduct();
				double percent = ((loanAccount.getChequeDeposit()*depositMoney)/100);
				depositMoney=depositMoney-percent;
				currentBalance = currentBalance+depositMoney;
				account.setBalance(currentBalance);
				System.out.println("Your balance is: "+account.getBalance());
				break;
			}
		}
		
		
	}

	public static void display(Customer customer) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your id: ");
		String customerId = scanner.nextLine();
		if(customerId.equals(customer.getCustomerCode())) {
			System.out.println("you have no account");
		}
		else {
			System.out.println("Customer Name: "+customer.getCustomerName());
			System.out.println("Your Customer Code is: "+customer.getCustomerCode());
			System.out.println("You have following accounts");
			for(Account account :customer.getAccountList()) {
				System.out.println("Acount number :"+account.getAccountNo());
				System.out.print("  Acount Type :"+account.getAccountType());
				System.out.print("  Acount Balance :"+account.getBalance());
				System.out.println();
				
			}
		}
		
	}
	
}
