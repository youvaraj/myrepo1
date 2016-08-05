package package_tests;

/**
 * Test case to search for products from eBay home page
 * Search for positive results ( items found )
 * Search for negative results ( items expected but not found ) 
  * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import package_utils.CommonSetup;
import package_utils.Configuration;

import package_pageobjects.*;


public class SearchForProductsTest {
	
	public WebDriver driver;
	public HomePage homePage;
	public SearchResultsPage searchResultsPage;
	public static String baseURL="";
	CommonSetup common_setup;
	
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser){
		
		common_setup=new CommonSetup();
		common_setup.setup(browser);
		driver=common_setup.driver;
		driver.manage().window().maximize();
	
		
		//driver=CommonSetup.driver;
		driver.get(Configuration.getPropVal("url"));

		
		//create objects of all required pages
	    homePage=new HomePage(driver);
		searchResultsPage=new SearchResultsPage(driver);
		//login_page=new LoginPage(driver);
		//inbox_page=new InboxPage(driver);
		
		//Configuration.loadConfig();
		String url=Configuration.getPropVal("url");
		System.out.println("Url is : " + url);
		
	}
	
	
	
//	
//	@BeforeClass(alwaysRun=true)
//	public void setup(){
//		
//		driver=new FirefoxDriver();
//		baseURL = "http://www.ebay.com/";
//	    driver.get(baseURL);
//	    homePage=new HomePage(driver);
//		searchResultsPage=new SearchResultsPage(driver);
//	    
//	}
	
	@Test(dataProvider="testdata")
	public void searchForProduct(String item) throws InterruptedException{
		//At Home page > search product 
		homePage.searchProduct(item);
		//At Search Results page > verify return results more than zero 
		searchResultsPage.verifyResultsReturn();
		//At Search Results page > navigate back to home page
		searchResultsPage.toHome();
	}
	
	/**
	 * provide data for search products test case 
	 * first item - positive result test data
	 * second item - negative result test data
	 * 
	 * @return 2-dim array 
	 */
	@DataProvider(name="testdata")
	public Object[][] getData(){
		return new Object[][]{
		{"shoes"},{"colouredturtlepaintings"}};
	}
	
	
	@AfterClass(alwaysRun = true)
	  public void tearDown(){
		driver.quit();
	    
	  }
	
	
}
