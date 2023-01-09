package com.jbk.product;

import java.util.List;
import java.util.Scanner;

import com.jbk.product.Service.ProductService;
import com.jbk.product.entity.Product;
import com.jbk.product.exception.ProductAireadyExistException;
import com.jbk.product.utility.ProductUtility;

public class Test {

	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		ProductService service = new ProductService();
		int choice;
		char ch;
		do {
			System.out.println(" ************controller*******************");
			System.out.println("press 1 for save product");
			System.out.println("press 2 for get  product");
			System.out.println("press 3 for delete product");
			System.out.println("press 4 for update product");
			
			System.out.println("press 5 for All data product");
			System.out.println("press 6 for restrictions Ex");
			System.out.println("press 7 for projection");
			choice =scanner.nextInt();
			 
			 switch (choice) {
			 case 1:{
				 Product product = ProductUtility.prepareproductData(scanner);
				 String msg =service.saveProduct(product);
				 System.out.println(msg);
					 
				 break;
			 }
			 
			 case 2:{
				 System.out.println("Enter productId");
				 int productId= scanner.nextInt();
				 Product product = service.getproductById(productId);
				 if(product!=null) {
					 System.out.println(product);
				 }else {
					 System.out.println("product not found");
				 }
				 break;
			 }
			 case 3:{
				 System.out.println("Enter productId");
				  int productId = scanner.nextInt();
				 String msg= service.deleteproductById(productId);
				 System.out.println(msg);
				  break;
			 }
			 case 4:{
				 
				 System.out.println("update");
				 break;
			 }

			 case 5:{
				List<Product> list= service.getAllProducts();
				 
				  if(!list.isEmpty()) {
					  for (Product product : list) {
						  System.out.println(product);
						
	
					  }
				  }
				  else {
					  System.out.println("product not Exist");
				  }
				 break;
			 }
			 case 6:{
				 List<Product> list = service.restrictionEx();
				 
				 if(!list.isEmpty()) {
					  for (Product product : list) {
						  System.out.println(product);
						
	
					  }
				  }
				  else {
					  System.out.println("product not Exist");
				  }
				 
				  
				 break;
			 }

			 case 7:{
				
    				 break;
			 }
			/* case 8:{
				 Double sum = (double) ((ProductService) service).sumOfproductPrice();
				 System.out.println(sum);
					
				 break;
		 }*/

			 
			  default:
				  System.out.println("invalid choice!!");
				 break;
			 
			 }
			  System.out.println("do you want to continue y/n");
			 ch= scanner.next().charAt(0);
			 
		}while( ch=='Y' || ch=='y');
		System.out.println("terminated");
	}
}
