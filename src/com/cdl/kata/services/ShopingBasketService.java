package com.cdl.kata.services;

import com.cdl.kata.model.Basket;
import com.cdl.kata.model.ProductAndOfferInventory;
import com.cdl.kata.model.ProductItem;

/**
 * I am service related to Basket.
 * 
 * @author virajvyas
 *
 */
public class ShopingBasketService {
	
	private ShopingBasketService() {
		//private constructor for the service.
	}
	
	/**
	 * Calculates new basket using supplied old Masket and new ProductItem.
	 * 
	 * @param newItem
	 * @param existingBasket
	 * @param productAndOfferInventory
	 * 
	 * @return Newly calculated basket
	 */
	public static Basket calculateNewBasket(ProductItem newItem, Basket existingBasket, ProductAndOfferInventory productAndOfferInventory) {
		Basket returnBasket = existingBasket;
		
		return returnBasket;
	}
	
	/**
	 * returns total amount for the basket.
	 * 
	 * @param basket
	 */
	public static float getBasketTotal(Basket basket) {
		return 0;
	}

}
