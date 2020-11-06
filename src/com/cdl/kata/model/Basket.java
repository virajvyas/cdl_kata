package com.cdl.kata.model;

import java.util.HashMap;
import java.util.Map;

public class Basket {
	private Map<ProductItem, Integer> productMap = new HashMap<>();
	private Map<Offers, Integer> offersMap = new HashMap<>();
	
	public Map<ProductItem, Integer> getProductMap() {
		return productMap;
	}
	
	public Integer getProductCount(ProductItem productItem) {
		return productMap.get(productItem);
	}
	
	public void addProductAndCount(ProductItem productItem, Integer count) {
		removeProductItem(productItem);
		productMap.put(productItem, count);
	}

	public void removeProductItem(ProductItem productItem) {
		if(productMap.containsKey(productItem)) {
			productMap.remove(productItem);
		}
	}
	
	
	
	public void setProductMap(Map<ProductItem, Integer> productMap) {
		this.productMap = productMap;
	}
	public Map<Offers, Integer> getOffersMap() {
		return offersMap;
	}
	
	public Integer getOfferCount(Offers offers) {
		return offersMap.get(offers);
	}
	
	public void addOfferAndCount(Offers offer, Integer count) {
		if(offersMap.containsKey(offer)) {
			offersMap.remove(offer);
		}
		
		offersMap.put(offer, count);
	}
	
	
	public void setOffersMap(Map<Offers, Integer> offersMap) {
		this.offersMap = offersMap;
	}
	
	
}
