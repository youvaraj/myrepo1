package package_utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	private static WebDriver driver;
	
	private WebDriverManager(){
		
	}
	

	//get instance accordingly
	public static WebDriver initDriver(String browser){
	
		if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		return driver;
		
	}
	
    
    public synchronized static WebDriver getDriver() {
        return driver;
    }

}
