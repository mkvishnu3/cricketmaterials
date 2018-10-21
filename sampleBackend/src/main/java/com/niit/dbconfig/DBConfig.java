
package com.niit.dbconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.model.Category;
import com.niit.model.Product;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	@Bean(name="datasource")
	public DataSource getDataSource()
	{
		System.out.println("Entering datasource bean creation method");
		BasicDataSource datasource=new BasicDataSource();
		System.out.println("hi");
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/project");
		datasource.setUsername("vishnu");
		datasource.setPassword("vishnu");
		System.out.println("DataSource Bean "+ datasource);
		return datasource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory sessionfactory()
	{
		LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		hibernateProperties.setProperty("hibernate.show_sql","true");
		lsf.addProperties(hibernateProperties);
		//Class[] classes=new Class[]{Product.class};
		System.out.println("SessionFactory bean" +lsf);
		return lsf.addAnnotatedClasses(new Class[]{Product.class,Category.class}).buildSessionFactory();
	}
	@Bean(name="productdao")
	public ProductDao getProductDao()
	{
		return new ProductDaoImpl();
	}
	@Bean
	public HibernateTransactionManager hibtransManagement()
	{
		return new HibernateTransactionManager(sessionfactory());
	}
}
