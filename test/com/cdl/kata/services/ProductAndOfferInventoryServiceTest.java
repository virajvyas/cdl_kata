package com.cdl.kata.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cdl.kata.model.ProductAndOfferInventory;
import com.cdl.kata.model.ProductCatagory;
import com.cdl.kata.model.ProductItem;
import com.cdl.kata.model.StockItem;

public class ProductAndOfferInventoryServiceTest {

	@Test
	public void testGetAllProductNameCase1() {
		ProductAndOfferInventory productAndOfferInventory = new ProductAndOfferInventory();
		ProductCatagory productCatagory1 = new ProductCatagory("Cat1", "Catagory1");
		ProductCatagory productCatagory2 = new ProductCatagory("Cat2", "Catagory2");
		
		ProductItem productItem1 = new ProductItem("A", 50, productCatagory1);
		ProductItem productItem2 = new ProductItem("B", 30, productCatagory2);
		
		productAndOfferInventory.addAvailableItem(new StockItem(productItem1, 200));
		productAndOfferInventory.addAvailableItem(new StockItem(productItem2, 400));
		
		assertEquals(ProductAndOfferInventoryService.getAllProductName(productAndOfferInventory), "A, B");
	}
	
	@Test
	public void testGetAllProductNameCase2() {
		ProductAndOfferInventory productAndOfferInventory = new ProductAndOfferInventory();
		ProductCatagory productCatagory1 = new ProductCatagory("Cat1", "Catagory1");
		
		ProductItem productItem1 = new ProductItem("A", 50, productCatagory1);
		
		productAndOfferInventory.addAvailableItem(new StockItem(productItem1, 200));
		
		assertEquals(ProductAndOfferInventoryService.getAllProductName(productAndOfferInventory), "A");
	}

}
