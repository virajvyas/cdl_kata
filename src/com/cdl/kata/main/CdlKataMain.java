package com.cdl.kata.main;

import java.util.Scanner;

import com.cdl.kata.model.Basket;
import com.cdl.kata.model.ProductAndOfferInventory;
import com.cdl.kata.model.ProductItem;
import com.cdl.kata.services.InventoryGeneratorService;
import com.cdl.kata.services.ProductAndOfferInventoryService;
import com.cdl.kata.services.ProductItemService;
import com.cdl.kata.services.ShopingBasketService;

public class CdlKataMain {

	public static void main(String[] args) {
		try (Scanner inputScanner = new Scanner(System.in)) {
			
			ProductAndOfferInventory productAndOfferInventory = InventoryGeneratorService.generateInitialInventories();
			
			System.out.println("Please enter product that you want to buy.");
			System.out.println("All Valid products are: " + ProductAndOfferInventoryService.getAllProductName(productAndOfferInventory));
			
			Basket basket = new Basket();
			String inputproduct = null;
			while (!"wq".equals(inputproduct)) {
				System.out.println("Your product: ");
				inputproduct = inputScanner.nextLine();
				ProductItem productIterm = ProductItemService.getProductItem(inputproduct, productAndOfferInventory);
				if(productIterm == null) {
					System.out.println("Please enter valid product");
					System.out.println("All Valid products are: " + ProductAndOfferInventoryService.getAllProductName(productAndOfferInventory));
				} else {
					basket = ShopingBasketService.calculateNewBasket(productIterm, basket, productAndOfferInventory);
				}
				
			}
			
			System.out.println("Your product total is : " + ShopingBasketService.getBasketTotal(basket));
		}
		
	}

}
