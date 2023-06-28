package com.log4j2xml;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2 
{    
	private static Log4j2 l= new Log4j2();
	public static Log4j2 getLogInstance() {
		return l;
	}
	private static Logger log = LogManager.getLogger();
	public Logger getLog() {
		return log;
	}
	public static void main(String[] args)
	{
		
		Log4j2.getLogInstance().getLog().trace("live");
		Log4j2.getLogInstance().getLog().debug("debug");
		Log4j2.getLogInstance().getLog().info("ok");
		Log4j2.getLogInstance().getLog().warn("warn");
		Log4j2.getLogInstance().getLog().error("invalid");
		Log4j2.getLogInstance().getLog().fatal("blocked");	
	}
}
