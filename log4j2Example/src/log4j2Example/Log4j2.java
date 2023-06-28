package log4j2Example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2 {
	
	private static Logger log = LogManager.getLogger(Log4j2.class);
	public static void main(String []arg) {
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
	}
}
