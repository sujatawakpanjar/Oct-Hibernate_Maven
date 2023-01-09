package com.jbk.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private int ProductId;
	
	@Column(unique= true, nullable = false)
	private String ProductName;
	
	
	@Column( nullable = false)
	private double productPrice;
	
	
	private String productMfg;
	
	@Column( nullable = false)
	private String productCatagory;
	
	
	public Product() {
 
	}


	public Product(int productId, String productName, double productPrice, String productMfg, String productCatagory) {
		super();
		ProductId = productId;
		ProductName = productName;
		this.productPrice = productPrice;
		this.productMfg = productMfg;
		this.productCatagory = productCatagory;
	}


	public int getProductId() {
		return ProductId;
	}


	public void setProductId(int productId) {
		ProductId = productId;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductMfg() {
		return productMfg;
	}


	public void setProductMfg(String productMfg) {
		this.productMfg = productMfg;
	}


	public String getProductCatagory() {
		return productCatagory;
	}


	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}


	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", productPrice=" + productPrice
				+ ", productMfg=" + productMfg + ", productCatagory=" + productCatagory + "]";
	}
		
	
	
	
}
