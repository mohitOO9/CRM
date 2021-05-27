package com.mma.crmproject.crm;

import java.util.logging.Logger;

import org.springframework.aop.support.annotation.AnnotationClassFilter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mma.crmproject.crm.config.ProjectGlobalConfiguration;


public class CrmApplication 
{
	private static final Logger logger = Logger.getLogger(CrmApplication.class.getName());
	
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = 
    			new AnnotationConfigApplicationContext(ProjectGlobalConfiguration.class);
    	
    	
    	//context.getBean("",);
    	
    	
        System.out.println( "Hello World!" );
        
    }    
}
