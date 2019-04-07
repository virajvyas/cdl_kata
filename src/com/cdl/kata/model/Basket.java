package com.cdl.kata.model;

import java.util.HashMap;
import java.util.Map;

public class Basket {
	private Map<ProductItem, Integer> productMap = new HashMap<>();
	private Map<Offers, Integer> offersMap = new HashMap<>();
	
	public Map<ProductItem, Integer> getProductMap() {
		return productMap;
	}
	public void setProductMap(Map<ProductItem, Integer> productMap) {
		this.productMap = productMap;
	}
	public Map<Offers, Integer> getOffersMap() {
		return offersMap;
	}
	public void setOffersMap(Map<Offers, Integer> offersMap) {
		this.offersMap = offersMap;
	}
	
	
}
