package com.mma.crmproject.crm.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mma.crmproject.crm.entity.Customer;
import com.mma.crmproject.crm.entity.User;

public class HibernateUtilityClass implements HibernateUtilityInterface{

	private static Logger logger = Logger.getLogger(HibernateUtilityClass.class.getName());
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/crmproject?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";	
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	
	@Override
	public Session getConnectionUsingJavaCode() {
		Session session = null;
		try {
			Configuration configuration = new Configuration();

			Properties properties = new Properties();
			properties.put("hibernate.connection.username", USERNAME);
			properties.put("hibernate.connection.password", PASSWORD);
			properties.put("hibernate.connection.dirver_class", DRIVER_CLASS_NAME);
			properties.put("hibernate.connection.url", JDBC_URL);
			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.format_sql", "true");
			properties.put("hibernate.use-new-id-generator-mappings", "false");

			configuration.addAnnotatedClass(User.class)
						 .addAnnotatedClass(Customer.class);
			
			
			session = configuration
					.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(properties).build())
					.openSession();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception ************** " + e.getMessage());
		}
		return session;
	}

	@Override
	public void testConnection() {
		String jdbcUrl = JDBC_URL;
		String username = USERNAME;
		String password = PASSWORD;
		Connection connection = null;
		try {
			logger.info("Connecting to the database...." + jdbcUrl);
			connection = DriverManager.getConnection(jdbcUrl, username, password);

			logger.info("Connection successfull...."+connection);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
