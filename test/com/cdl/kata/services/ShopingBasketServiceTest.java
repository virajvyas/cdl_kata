package com.cdl.kata.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cdl.kata.model.Basket;
import com.cdl.kata.model.Offers;
import com.cdl.kata.model.ProductAndOfferInventory;
import com.cdl.kata.model.ProductCatagory;
import com.cdl.kata.model.ProductItem;
import com.cdl.kata.model.StockItem;

public class ShopingBasketServiceTest {

	@Test
	public void testCalculateNewBasket() {
		Map<ProductItem, Integer> productMap = new HashMap<>();
		Map<Offers, Integer> offersMap = new HashMap<>();
		productMap.put(getProduct1(), 2);
		productMap.put(getProduct2(), 1);

		Basket existingBasket = new Basket();
		existingBasket.setOffersMap(offersMap);
		existingBasket.setProductMap(productMap);

		existingBasket = ShopingBasketService.calculateNewBasket(getProduct1(), existingBasket,
				getProductAndOfferInventory());
		
		assertNotNull(existingBasket);
		assertEquals(existingBasket.getOffersMap().entrySet().size(), 1);
		assertEquals(existingBasket.getProductMap().entrySet().size(), 1);
		
		assertTrue(existingBasket.getProductMap().get(getProduct2()) == 1);
		assertEquals(existingBasket.getOffersMap().keySet().iterator().next().getName(), "Offer1");
		
		//Add again
		existingBasket = ShopingBasketService.calculateNewBasket(getProduct1(), existingBasket,
				getProductAndOfferInventory());

		assertNotNull(existingBasket);
		assertEquals(existingBasket.getOffersMap().entrySet().size(), 1);
		assertEquals(existingBasket.getProductMap().entrySet().size(), 2);
		
		assertEquals(existingBasket.getProductMap().get(getProduct2()), new Integer(1));
		assertEquals(existingBasket.getProductMap().get(getProduct1()), new Integer(1));
		assertEquals(existingBasket.getOffersMap().keySet().iterator().next().getName(), "Offer1");
	}
	
	@Test
	public void testGetBasketTotal() {
		Map<ProductItem, Integer> productMap = new HashMap<>();
		Map<Offers, Integer> offersMap = new HashMap<>();
		productMap.put(getProduct1(), 2);
		productMap.put(getProduct2(), 1);

		Basket existingBasket = new Basket();
		existingBasket.setOffersMap(offersMap);
		existingBasket.setProductMap(productMap);

		existingBasket = ShopingBasketService.calculateNewBasket(getProduct1(), existingBasket,
				getProductAndOfferInventory());
		
		assertTrue(ShopingBasketService.getBasketTotal(existingBasket) == 160);
	}

	private ProductItem getProduct1() {
		ProductCatagory productCatagory1 = new ProductCatagory("Cat1", "Catagory1");
		return new ProductItem("A", 50, productCatagory1);
	}

	private ProductItem getProduct2() {
		ProductCatagory productCatagory2 = new ProductCatagory("Cat2", "Catagory2");
		return new ProductItem("B", 30, productCatagory2);
	}

	private ProductAndOfferInventory getProductAndOfferInventory() {
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
