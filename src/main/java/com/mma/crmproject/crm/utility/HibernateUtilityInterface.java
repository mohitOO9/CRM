package com.mma.crmproject.crm.utility;

import org.hibernate.Session;

public interface HibernateUtilityInterface {
	
	public Session getConnectionUsingJavaCode(); 
	
	public void testConnection();

}
