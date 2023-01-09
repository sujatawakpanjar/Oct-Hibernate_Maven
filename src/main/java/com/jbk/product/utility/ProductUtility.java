package com.jbk.product.utility;

import java.util.Scanner;

import com.jbk.product.entity.Product;

public class ProductUtility {
	public  static Product prepareproductData(Scanner scanner) {
		
		 
		System.out.println("Enter product Id");
		int productId =scanner.nextInt();
		
		System.out.println("Enter product Name");
		String productName =scanner.next();
		
		System.out.println("Enter product Price");
		double productPrice =scanner.nextDouble();
		
		System.out.println("Enter product mfg");
		String productMfg =scanner.next();
		
		System.out.println("Enter product Catagory");
		String productCatagory=scanner.next();
		
		
		Product product =new Product(productId, productName, productPrice, productMfg, productCatagory);
		 
		return product;
		
	}

}
