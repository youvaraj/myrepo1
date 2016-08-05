package package_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
	
	@FindBy(how=How.ID,using="gh-ac")
	public WebElement txtBoxSearch;
	
	@FindBy(how=How.ID,using="gh-btn")
	public WebElement btnSearch;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	/**
	 * This method search for products at home page
	 * clear the search field at home page
	 * enter the products name at search field
	 * click search button 
	 * @param item
	 */
	public void searchProduct(String item){
		log.info("Home Page > Start Search for item : " + item );
		enterText(txtBoxSearch,item);
		clickThis(btnSearch);
		log.info("Home Page > End Search for item : " + item);
	}

}
