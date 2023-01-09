package com.jbk.product.Dao;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.internal.build.AllowPrintStacktrace;
 

import com.jbk.product.config.HibernateUtility;
import com.jbk.product.entity.Product;
import com.jbk.product.exception.ProductAireadyExistException;
import com.jbk.product.utility.ProductUtility;

public class ProductDao {
	
	private SessionFactory sessionFactory;
	
	public ProductDao() {

		sessionFactory = HibernateUtility.getSessionFactory();
	}
	 
	
	public String saveProduct(Product product) {
		Session session = null;
		boolean isAdded = false;
		try {
		 session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();	
		Product dbproduct=session.get(Product.class, product.getProductId());
		
		if(dbproduct==null) {
		 session.save(product);
		 transaction.commit();
		 isAdded= true;
		}
		}
		 
		catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		if (isAdded) {
			return "saved!!";
		}
		else {
			 return "not saved";
		}
		 
		
	}
	
	public Product getproductById(int productId) {
		Session session= null;
		Product product=null;
		
		try {
			session=sessionFactory.openSession();
			product=session.get(Product.class, productId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return product;
	}

	public String deleteproductById(int productId) {
		Session session= null;
		String msg=null;
		try {
			session=sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();	
			Product product=session.get(Product.class, productId);
			if(product!=null) {
				session.delete(product);
				transaction.commit();
				msg="Deleted";
			}else {
				msg="product not Exist with Id ="+productId;
			}
			 
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		
		return msg;
		
	}
	public java.util.List<Product> getAllProducts(){
	Session session = null;
	List<Product> list=null;
	try {
		session=sessionFactory.openSession();
		
		Criteria criteria= session.createCriteria(Product.class);

		//criteria.addOrder(Order.desc("productPrice"));	
		
		criteria.setFirstResult(0);
		criteria.setMaxResults(3);
		
		list = criteria.list();
		 
	}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null){
				session.close();
			}
		}
			return list;
		
	 
		
	}


	public List<Product> restrictionEx() {
 
		Session session = null;
		List<Product> list=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria= session.createCriteria(Product.class);
			
			//SimpleExpression se = Restrictions.eq("ProductName","pen");
			
			//Map<String,Object> map = new HashMap<String, Object>();
			//map.put("ProductName", "pen");
			//map.put("productPrice", 10d);
			//Criterion crt =  Restrictions.allEq(map);
			
			
			//Criterion name = Restrictions.eq("ProductName", "pen");
			//Criterion price = Restrictions.eq("productPrice", 10d);
			//criteria.add(Restrictions.and(name,price));
			
			//criteria.add(Restrictions.between("productPrice", 1d, 4000d));
			
			//criteria.add(Restrictions.in("productPrice", 10d,3000d,100d));
			
			criteria.add(Restrictions.like("ProductName","p%"));
			list = criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null){
				session.close();
			}
		}
		
		return list;
	}


	public int sumOfproductPrice() {
		Session session = null;
		int sum=0;
		try {
			session=sessionFactory.openSession();
			Criteria criteria =session.createCriteria(Product.class);
			criteria.setProjection(Projections.sum("productPrice"));
			List<Integer> list = criteria.list();
			sum = list.get(0);
			
		
		}catch(Exception e) {
			e.printStackTrace();
	
		}finally {
			if(session!=null){
				session.close();
			}
		}
 		return sum;
	}
		 
}
