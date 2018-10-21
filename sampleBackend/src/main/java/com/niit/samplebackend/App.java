package com.niit.samplebackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.dbconfig.DBConfig;
import com.niit.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,ProductDaoImpl.class);
        //context.scan("com.niit");
        //context.refresh();
        ProductDao productDao=(ProductDao) context.getBean("productdao");
        Product product=new Product();
        product.setProductName("Keeping glouse");
        product.setProductDesc("Rebok");
        product.setQuantity(100);
        product.setPrice(500);
        productDao.saveProduct(product);
        
        /*ProductDao productDao=(ProductDao)context.getBean("productdao");
        //Product product=new Product();
        Product p=productDao.getProduct(2);
        //System.out.println(p);
        //p.setPrice(5000);
        p.setQuantity(10);
        productDao.updateProduct(p);*/
        
        /*ProductDao productDao=(ProductDao)context.getBean("productdao");
        productDao.deleteProduct(4);*/
        
        
    }
}
