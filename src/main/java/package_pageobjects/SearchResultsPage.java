package package_pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultsPage extends BasePage{
	
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	/*******************************************************
	 * Search Results page
	 * This method verify at least 1 items returns as search results 
	 * This method check for text using regular expression 
	 * check more than 1 listings at results page
	 *  eg. 2,345,000 listings
	 *  
	 ***********************************************************/
	public void verifyResultsReturn(){
		String current_text="";
		
		try {
			//get current text from search results page
			current_text=driver.findElement(By.cssSelector(".listingscnt")).getText();
			Assert.assertTrue(current_text.matches("[1-9]+([,][0-9]+)*\\s*listings\\z"));
				log.info("Returned Results match");
		    } catch (AssertionError e) {
		    	log.error("Expected : Count > 0 , Actual " + current_text);
		    	Assert.fail(e.getLocalizedMessage());
		      }
	}

}
