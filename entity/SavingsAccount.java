package com.ilp.entity;
import java.util.ArrayList;

public class SavingsAccount extends Product {
    private double minimumBalance;
	public SavingsAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		minimumBalance = 1000;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	

}
