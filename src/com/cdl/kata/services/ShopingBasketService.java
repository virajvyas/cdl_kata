package com.cdl.kata.services;

import java.util.Map.Entry;

import com.cdl.kata.model.Basket;
import com.cdl.kata.model.Offers;
import com.cdl.kata.model.ProductAndOfferInventory;
import com.cdl.kata.model.ProductCatagory;
import com.cdl.kata.model.ProductItem;

/**
 * I am service related to Basket.
 * 
 * @author virajvyas
 *
 */
public class ShopingBasketService {

	private ShopingBasketService() {
		// private constructor for the service.
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
	public static Basket calculateNewBasket(ProductItem newItem, Basket existingBasket,
			ProductAndOfferInventory productAndOfferInventory) {
		Basket returnBasket = existingBasket;
		
		Integer itemCount = getItemCount(newItem, returnBasket);

		Offers offer = getOfferForItem(newItem, productAndOfferInventory);

		if (offer == null) {
			returnBasket.addProductAndCount(newItem, itemCount);
		} else if (itemCount == offer.getGroupNumber()) {
			addOfferIntoBasket(newItem, returnBasket, offer);
		} else {
			returnBasket.addProductAndCount(newItem, itemCount);
		}

		return returnBasket;
	}
	
	/**
	 * returns total amount for the basket.
	 * 
	 * @param basket
	 */
	public static float getBasketTotal(Basket basket) {
		float returnValue = 0;
		
		for(Entry<ProductItem, Integer> productItemEntrys:basket.getProductMap().entrySet()) {
			returnValue += productItemEntrys.getKey().getPrice() * productItemEntrys.getValue();
		}
		
		for(Entry<Offers, Integer> offerEntrys:basket.getOffersMap().entrySet()) {
			returnValue += offerEntrys.getKey().getGroupPrice() * offerEntrys.getValue();
		}
		
		return returnValue;
	}

	private static Integer getItemCount(ProductItem newItem, Basket returnBasket) {
		Integer itemCount = returnBasket.getProductCount(newItem);
		if (itemCount == null) {
			itemCount = 0;
		}
		itemCount = itemCount + 1;
		return itemCount;
	}

	private static void addOfferIntoBasket(ProductItem newItem, Basket returnBasket, Offers offer) {
		returnBasket.removeProductItem(newItem);
		Integer offerCount = returnBasket.getOfferCount(offer);
		if (offerCount == null) {
			offerCount = 0;
		}
		offerCount = offerCount + 1;
		
		//This can be improved. 
		offer.addProductsInTheOffer(newItem);
		
		returnBasket.addOfferAndCount(offer, offerCount);
	}

	

	private static Offers getOfferForItem(ProductItem productItem, ProductAndOfferInventory productAndOfferInventory) {
		for (Offers offer : productAndOfferInventory.getAvailableOffers()) {
			boolean hasMatchingCatagory = false;
			for (ProductCatagory productCatagory : offer.getAppliedCatagories()) {
				if (productCatagory != null && productCatagory.getName().equals(productItem.getCaragory().getName())) {
					hasMatchingCatagory = true;
					break;
				}
			}
			if (hasMatchingCatagory) {
				return offer;
			}
		}

		return null;
	}

}
