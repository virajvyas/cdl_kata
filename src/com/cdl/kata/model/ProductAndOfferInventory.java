package com.cdl.kata.model;

import java.util.ArrayList;
import java.util.List;

/**
 * I am holding all valid products and offers.
 * @author virajvyas
 *
 */
public class ProductAndOfferInventory {
	
	List<StockItem> availableItems = new ArrayList<>();
	List<Offers> availableOffers = new ArrayList<>();
	
	public List<StockItem> getAvailableItems() {
		return availableItems;
	}
	public void addAvailableItem(StockItem stockItems) {
		availableItems.add(stockItems);
	}
	public List<Offers> getAvailableOffers() {
		return availableOffers;
	}
	public void addAvailableOffers(Offers offer) {
		this.availableOffers.add(offer);
	}
	
}
