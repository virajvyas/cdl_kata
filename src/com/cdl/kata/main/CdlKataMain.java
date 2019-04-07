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

	private static final String EXIT_STRING = "exit";

	public static void main(String[] args) {
		try (Scanner inputScanner = new Scanner(System.in)) {
			
			ProductAndOfferInventory productAndOfferInventory = InventoryGeneratorService.generateInitialInventories();
			
			System.out.println("Please enter product that you want to buy.");
			
			
			Basket basket = new Basket();
			String inputproduct = null;
			while (!EXIT_STRING.equals(inputproduct)) {
				System.out.println("Your product from [" + ProductAndOfferInventoryService.getAllProductName(productAndOfferInventory) +"]. For checkout type: "+EXIT_STRING);
				inputproduct = inputScanner.nextLine();
				ProductItem productIterm = ProductItemService.getProductItem(inputproduct, productAndOfferInventory);
				
				
				if(productIterm == null) {
					System.out.println("Please enter valid product");
					System.out.println("All Valid products are: " + ProductAndOfferInventoryService.getAllProductName(productAndOfferInventory));
				} else if (!EXIT_STRING.equals(inputproduct)) {
					basket = ShopingBasketService.calculateNewBasket(productIterm, basket, productAndOfferInventory);
				} 
				
			}
			
			System.out.println("Your product total is : " + ShopingBasketService.getBasketTotal(basket));
		}
		
	}

}
