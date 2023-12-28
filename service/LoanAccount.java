package com.ilp.service;

import java.util.ArrayList;

import com.ilp.entity.Product;
import com.ilp.entity.Service;

public class LoanAccount extends Product {
	private Double chequeDeposit;

	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		 super(productCode, productName, serviceList);
		 chequeDeposit = 0.3;
	}

	public Double getChequeDeposit() {
		return chequeDeposit;
	}

	public void setChequeDeposit(Double chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}
	

}
