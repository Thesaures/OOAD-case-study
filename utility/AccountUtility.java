package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.BankService;

public class AccountUtility {

	public static void main(String[] args) {
		ArrayList<Service> serviceList= new ArrayList<Service>();
		ArrayList<Product> productList= new ArrayList<Product>();
		Customer customer = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*******Welcome to Bank*******");
		char mainChoice =0;
		do {
			System.out.println("1.Create Service 2.Create Product 3.Create Customer 4.Manage Accounts 5.Display Customer 6.Exit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1:
				BankService.createService(serviceList);
				break;
			case 2:
				BankService.createProduct(serviceList,productList);
				break;
			case 3:
				customer= BankService.createCustomer(productList,customer);
			    break;
			case 4:
				BankService.manageAccounts(customer);
				break;
			case 5:
				BankService.display(customer);
				break;
			case 6:
				System.exit(0);
				break;
			}
			System.out.println("Do you want to continue?(y/n)");
			mainChoice = scanner.next().charAt(0);
			scanner.nextLine();
		}while(mainChoice == 'y');

	}

}
