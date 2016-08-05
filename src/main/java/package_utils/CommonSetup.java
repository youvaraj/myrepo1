package package_utils;

import org.openqa.selenium.WebDriver;

public class CommonSetup {
	
	
	
	public static WebDriver driver;
	public static Configuration config;
	
	public void setup(String browser){
		
		//initialize  configuration file
		config=new Configuration();
		config.loadConfig();
		
		//initliaze browser
		driver=WebDriverManager.initDriver(browser);
	}
	
	

	
}
