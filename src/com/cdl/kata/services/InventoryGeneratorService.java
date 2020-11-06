package com.cdl.kata.services;

import com.cdl.kata.model.Offers;
import com.cdl.kata.model.ProductAndOfferInventory;
import com.cdl.kata.model.ProductCatagory;
import com.cdl.kata.model.ProductItem;
import com.cdl.kata.model.StockItem;

/**
 * Generates inventory, this class can be replaced with DAO.
 *  
 * @author virajvyas
 *
 */
public class InventoryGeneratorService {
	
	private InventoryGeneratorService() {
		//Private constructor for the service.
	}
	
	public static ProductAndOfferInventory generateInitialInventories() {
		
		ProductAndOfferInventory productAndOfferInventory = new ProductAndOfferInventory();
		ProductCatagory productCatagory1 = new ProductCatagory("Cat1", "Catagory1");
		ProductCatagory productCatagory2 = new ProductCatagory("Cat2", "Catagory2");
		ProductCatagory productCatagory3 = new ProductCatagory("Cat3", "Catagory3");
		ProductCatagory productCatagory4 = new ProductCatagory("Cat4", "Catagory4");

		ProductItem productItem1 = new ProductItem("A", 50, productCatagory1);
		ProductItem productItem2 = new ProductItem("B", 30, productCatagory2);
		ProductItem productItem3 = new ProductItem("C", 20, productCatagory3);
		ProductItem productItem4 = new ProductItem("D", 15, productCatagory4);

		productAndOfferInventory.addAvailableItem(new StockItem(productItem1, 200));
		productAndOfferInventory.addAvailableItem(new StockItem(productItem2, 400));
		productAndOfferInventory.addAvailableItem(new StockItem(productItem3, 500));
		productAndOfferInventory.addAvailableItem(new StockItem(productItem4, 700));

		Offers offer1 = new Offers("Offer1", 3, 130);
		Offers offer2 = new Offers("Offer2", 2, 45);

		offer1.addAppliedCatagories(productCatagory1);
		offer2.addAppliedCatagories(productCatagory2);

		productAndOfferInventory.addAvailableOffers(offer1);
		productAndOfferInventory.addAvailableOffers(offer2);

		return productAndOfferInventory;
		
	}

}
