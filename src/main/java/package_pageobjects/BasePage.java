package package_pageobjects;

/**********************************
 * This is an abstract base page class 
 * all the others page can extend to use the common functions
 * such as click element, type in text box or verify text on screen
 * 
 */


import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import package_utils.Logg;



public abstract class BasePage {
	private int TIMEOUT=4;
	protected WebDriver driver;
	public static Logger log=Logg.createLogger(); //create singleton log file for logging

	//logo at home page to navigate to itself
	@FindBy(how=How.ID,using="gh-logo")
	public WebElement logoHome;
	
	
	public BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*******************************************************
	 * This methods is used to type text at text box
	 * It clears the specified text box
	 * It type the specified text at this text box
	 * @param txtbox - instance of WebElement for text box
	 * @param typeThis - text that to be typed
	 * @throws StateElementReferenceException 
	 **********************************************************/
	public void enterText(WebElement txtbox,String typeThis){
	try{
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(txtbox));
			txtbox.clear();
			txtbox.sendKeys(typeThis);
	    		}catch(StaleElementReferenceException sere){
	    			System.out.println("Not found");
	    		}
		}
	 
	
	/*******************************************************
	 * This methods is used to click any element at current page
	 * It waits until element displayed or timed out at specified timeout
	 * it clicks the element  if found
	 * @throws StateElementReferenceException 
	 **********************************************************/
	public void clickThis(WebElement element){
	try{
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
			element.click();
				}catch(StaleElementReferenceException sere){
	    			System.out.println("Not found");
	    		}
			}
	
	/**
	 * This method is used to navigate to home page
	 * It clicks at ebay logo at home page 
	 */
	public void toHome(){
		clickThis(logoHome);
	}
	
}	
