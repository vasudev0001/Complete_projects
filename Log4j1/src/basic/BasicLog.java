package basic;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BasicLog {

	private static Logger log = LogManager.getLogger(BasicLog.class.getName());
	public static void main(String[] args)
	{	
		log.info("Browser launcched");
		log.info("url Entered");
		log.info("user name entered");
		log.info("password entered");
		log.info("click on submit button");
		log.info("home page is displayed"); 	
	}
}
