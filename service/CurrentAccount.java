package com.ilp.service;

import java.util.ArrayList;

import com.ilp.entity.Product;
import com.ilp.entity.Service;

public class CurrentAccount extends Product {

	public CurrentAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		
	}

}
