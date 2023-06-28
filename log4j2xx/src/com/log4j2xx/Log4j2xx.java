package com.log4j2xx;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2xx {
	
	private static Logger log = LogManager.getLogger(Log4j2xx.class);
	public static void main(String[] args)
	{
		log.info("Browser launched");
		log.info("url Entered");
		log.info("user name entered");
		log.info("password entered");
		log.info("click on submit button");
		log.info("home page is displayed"); 
	}
}
