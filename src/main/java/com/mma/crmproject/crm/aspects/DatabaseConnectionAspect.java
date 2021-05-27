package com.mma.crmproject.crm.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.mma.crmproject.crm.utility.HibernateUtilityClass;
import com.mma.crmproject.crm.utility.HibernateUtilityInterface;

@Aspect
@Component
public class DatabaseConnectionAspect {
	
	private static final Logger logger = Logger.getLogger(DatabaseConnectionAspect.class.getName());
	private final HibernateUtilityInterface utilityClass = new HibernateUtilityClass();
	
	@Before("execution(* com.mma.crmproject.crm.service.*.*(..)")
	public void testConnection() {
		logger.info("====> DatabaseConnectionAspect. CHECKING CONNECTION LINK. ");
		utilityClass.testConnection();
	}
}
