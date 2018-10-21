
package com.niit.dao;

import com.niit.model.Product;

public interface ProductDao {
	Product saveProduct(Product product);
	Product getProduct(int id);
	void updateProduct(Product product);
	Product deleteProduct(int id);

}
