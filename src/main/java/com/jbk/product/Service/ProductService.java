package com.jbk.product.Service;

import com.jbk.product.Dao.ProductDao;
import com.jbk.product.entity.Product;

import antlr.collections.List;

public class ProductService {
	private  ProductDao dao =new ProductDao();
	
	public String saveProduct(Product product) {
		
		String msg = dao.saveProduct(product);
		 return msg;

	 	
	} 	
	 
	public Product getproductById(int productId) {
		 
		
		return  dao.getproductById(productId);		
		
	}

	public String deleteproductById(int productId) {
		
		return dao.deleteproductById(productId);
		
	}
	

	public java.util.List<Product> getAllProducts(){
	
		
		return dao.getAllProducts();
		
	}
	public java.util.List<Product> restrictionEx(){
		return dao.restrictionEx();
	}
		 
	
}
