package package_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logg {

	// Class Instance Variables
	private static Logger _logger;
	private static String fileName = "testlog";

	static {
		/**
		 * This is the static block which appends the log file name with the
		 * timestamp to make it unique
		 */
		try {
			String datetimeString = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss")
					.format(new Date());
			String FileName = (fileName + "-" + datetimeString + ".log");
			File file = new File("logs/" + FileName);

			if (file.createNewFile()) {
				Properties props = new Properties();
				props.load(new FileInputStream(".\\logs\\log4j.properties"));
						
							
				props.setProperty("log4j.appender.File.File", "logs/"+ FileName);
				LogManager.resetConfiguration();
				PropertyConfigurator.configure(props);
				System.out.println("Property log4j.appender.File.File = logs/"+ FileName);
			}
		} catch (IOException ex) {
			System.out.print("IO Exception in static method of Logger Class. "
					+ ex.getMessage());
		
		}

	}

	/**
	 * 
	 * singleton class
	 * @return - new instance no instance exist 
	 * else return previously created 
	 * 
	 * */
	public static Logger createLogger() {
		if (_logger == null) {
			_logger = Logger.getLogger(Logg.class);
			return _logger;
		} else
			return _logger;
	}
}