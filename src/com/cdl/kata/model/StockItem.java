package com.cdl.kata.model;

public class StockItem {

	private ProductItem productItem;
	private int inStockNumber;
	
	public StockItem(ProductItem productItem, int inStockNumber) {
		this.productItem = productItem;
		this.inStockNumber = inStockNumber;
	}
	public ProductItem getProductItem() {
		return productItem;
	}
	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}
	public int getInStockNumber() {
		return inStockNumber;
	}
	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}
	
	
}
