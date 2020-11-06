package com.cdl.kata.services;

import com.cdl.kata.model.ProductAndOfferInventory;
import com.cdl.kata.model.StockItem;

/**
 * Service related to ProductAndOfferInventory.
 * 
 * @author virajvyas
 *
 */
public class ProductAndOfferInventoryService {
	
	private ProductAndOfferInventoryService() {
		//private constructor for the service.
	}
	
	/**
	 * @return comma separated all products name.
	 */
	public static String getAllProductName(ProductAndOfferInventory productAndOfferInventory) {
		StringBuffer sb = new StringBuffer();
		boolean isFirst = true;
		for(StockItem stockItem : productAndOfferInventory.getAvailableItems()) {
			if(isFirst) {
				sb.append(stockItem.getProductItem().getName());
				isFirst = false;
			} else {
				sb.append(", ");
				sb.append(stockItem.getProductItem().getName());
			}
		}
		
		return sb.toString();
	}

}
