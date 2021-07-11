package TestingCommon;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RestFWLogger {
	public static Logger log = Logger.getLogger(RestFWLogger.class.getName()); 
	
	public static void initLogger() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public static void startTestCase(String testCaseName) {
		log.info("**************************************************************************");
		log.info("**************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$$$"+    testCaseName        +"$$$$$$$$$$$$$$$$$$$$$$$");
		log.info("**************************************************************************");
		log.info("**************************************************************************");
	}
	public static void startTestCase() {
		log.info("**************************************************************************");
		log.info("**************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$S----T----A----R----T$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info("**************************************************************************");
		log.info("**************************************************************************");
	}
	
	public static void endTestCase() {
		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		log.info("$$$$$$$$$$$$$$$$$$$$$$$"+    "E----N----D"        +"$$$$$$$$$$$$$$$$$$$$$$");
		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public static void info(String message) {
		log.info(message); 
	}
}
