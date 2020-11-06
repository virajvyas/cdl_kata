package com.cdl.kata.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cdl.kata.model.ProductAndOfferInventory;

public class InventoryGeneratorServiceTest {

	private static final float FIFTY = 50.0f;

	@Test
	public void testGenerateInitialInventories() {
		ProductAndOfferInventory productAndOfferInventory = InventoryGeneratorService.generateInitialInventories();
		assertNotNull(productAndOfferInventory);
		assertNotNull(productAndOfferInventory.getAvailableItems());
		assertNotNull(productAndOfferInventory.getAvailableOffers());
		assertEquals(productAndOfferInventory.getAvailableItems().size(), 4);
		
		
		assertNotNull(productAndOfferInventory.getAvailableItems().get(0).getProductItem());
		assertNotNull(productAndOfferInventory.getAvailableItems().get(1).getProductItem());
		assertNotNull(productAndOfferInventory.getAvailableItems().get(2).getProductItem());
		assertNotNull(productAndOfferInventory.getAvailableItems().get(3).getProductItem());
		
		assertEquals(productAndOfferInventory.getAvailableItems().get(0).getProductItem().getName(), "A");
		assertEquals(productAndOfferInventory.getAvailableItems().get(0).getProductItem().getCaragory().getName(), "Cat1");
		assertTrue(productAndOfferInventory.getAvailableItems().get(0).getProductItem().getPrice() == FIFTY);
		
		assertEquals(productAndOfferInventory.getAvailableItems().get(1).getProductItem().getName(), "B");
		assertEquals(productAndOfferInventory.getAvailableItems().get(1).getProductItem().getCaragory().getName(), "Cat2");
		assertTrue(productAndOfferInventory.getAvailableItems().get(1).getProductItem().getPrice() == 30.0);
		
		assertEquals(productAndOfferInventory.getAvailableItems().get(2).getProductItem().getName(), "C");
		assertEquals(productAndOfferInventory.getAvailableItems().get(2).getProductItem().getCaragory().getName(), "Cat3");
		assertTrue(productAndOfferInventory.getAvailableItems().get(2).getProductItem().getPrice() == 20.0);
		
		assertEquals(productAndOfferInventory.getAvailableItems().get(3).getProductItem().getName(), "D");
		assertEquals(productAndOfferInventory.getAvailableItems().get(3).getProductItem().getCaragory().getName(), "Cat4");
		assertTrue(productAndOfferInventory.getAvailableItems().get(3).getProductItem().getPrice() == 15.0);
		
		
		assertEquals(productAndOfferInventory.getAvailableOffers().size(), 2);
		
		assertNotNull(productAndOfferInventory.getAvailableOffers().get(0).getAppliedCatagories());
		assertNotNull(productAndOfferInventory.getAvailableOffers().get(1).getAppliedCatagories());
		
		assertEquals(productAndOfferInventory.getAvailableOffers().get(0).getAppliedCatagories().get(0).getName(), "Cat1");
		assertTrue(productAndOfferInventory.getAvailableOffers().get(0).getGroupNumber() == 3);
		assertTrue(productAndOfferInventory.getAvailableOffers().get(0).getGroupPrice() == 130.0);
		
		assertEquals(productAndOfferInventory.getAvailableOffers().get(1).getAppliedCatagories().get(0).getName(), "Cat2");
		assertTrue(productAndOfferInventory.getAvailableOffers().get(1).getGroupNumber() == 2);
		assertTrue(productAndOfferInventory.getAvailableOffers().get(1).getGroupPrice() == 45.0);
		
		
	}

}
