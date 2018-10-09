
package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product saveProduct(Product product) {
		System.out.println("Id of Product before Persisting:" + product.getId());
		Session session=sessionFactory.getCurrentSession();
		session.persist(product);
		System.out.println("Id of Product after Persisting:" + product.getId());
		return product;
	}
	
	
}
