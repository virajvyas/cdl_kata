package com.cdl.kata.services;

import com.cdl.kata.model.ProductAndOfferInventory;
import com.cdl.kata.model.ProductItem;

/**
 * I am service for the ProductItem
 * 
 * @author virajvyas
 *
 */
public class ProductItemService {
	
	private ProductItemService() {
		//private constructor for the service.
	}
	
	/**
	 * I am generating ProductItem using supplied productName
	 * 
	 * @param productName
	 * @return ProductItem for supplied ProductName. Null in case of invalid productName.
	 */
	public static ProductItem getProductItem(String productName, ProductAndOfferInventory productAndOfferInventory) {
		return null;
	}

}
