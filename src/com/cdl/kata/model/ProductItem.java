package com.cdl.kata.model;

public class ProductItem {
	private String name;
	private float price;
	private ProductCatagory caragory;

	
	
	public ProductItem(String name, float price, ProductCatagory caragory) {
		this.name = name;
		this.price = price;
		this.caragory = caragory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ProductCatagory getCaragory() {
		return caragory;
	}

	public void setCaragory(ProductCatagory caragory) {
		this.caragory = caragory;
	}

	@Override
	public int hashCode() {
		// This can be improved
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// This can be improved
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// This can be improved
		return super.toString();
	}

}
