package com.portfolio.data.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Manager implements ServletContextListener
{
	final Logger logger = LoggerFactory.getLogger(Manager.class);
	
	public void contextInitialized(ServletContextEvent event)
	{
		try
		{
			// Loading configKaruta.properties
			ConfigUtils.loadConfigFile(event.getServletContext());
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent event)
	{
		// Releasing driver
		SqlUtils.close();
	}

}