package com.cdl.kata.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Offers {
	
	private String name;
	private List<ProductCatagory> appliedCatagories = new ArrayList<>();
	private List<ProductItem> productsInTheOffer  = new ArrayList<>();
	private int groupNumber;
	private float groupPrice;
	
	//These dates can be useful for the offer validity in future.
	private LocalDate offerStartDate = LocalDate.now();
	private LocalDate offerEndDate = LocalDate.now().plusDays(1);
	
	public Offers(String name, int groupNumber, float groupPrice) {
		this.name = name;
		this.groupNumber = groupNumber;
		this.groupPrice = groupPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ProductCatagory> getAppliedCatagories() {
		return appliedCatagories;
	}
	public void addAppliedCatagories(ProductCatagory productCatagory) {
		appliedCatagories.add(productCatagory);
	}
	public int getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public float getGroupPrice() {
		return groupPrice;
	}
	public void setGroupPrice(float groupPrice) {
		this.groupPrice = groupPrice;
	}
	public List<ProductItem> getProductsInTheOffer() {
		return productsInTheOffer;
	}
	public void addProductsInTheOffer(ProductItem productsItem) {
		productsInTheOffer.add(productsItem);
	}
	public LocalDate getOfferStartDate() {
		return offerStartDate;
	}
	public void setOfferStartDate(LocalDate offerStartDate) {
		this.offerStartDate = offerStartDate;
	}
	public LocalDate getOfferEndDate() {
		return offerEndDate;
	}
	public void setOfferEndDate(LocalDate offerEndDate) {
		this.offerEndDate = offerEndDate;
	}
	
	
	
}