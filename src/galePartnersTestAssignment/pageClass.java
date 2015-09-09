package galePartnersTestAssignment;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty7.util.log.Log;

public class pageClass extends unitTestClass
{

public WebDriver driver;
	/*Page elements*/
	private By applyNowBttn = By.xpath("(//a[contains(text(),'Apply NOW!')])[2]");
	private By welcomeText = By.className("title_black");
	private By continueBttn = By.id("checkit");
	private By phoneType = By.name("phoneType");
	readPropertiesClass getVal = new readPropertiesClass();
	
	/*Constructor*/
	public pageClass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/*Gets the title of the page*/
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
    /*Browse till registration form*/
    @SuppressWarnings("deprecation")
	public void goToRegistrationForm()
    {
    WebDriverWait wait = new WebDriverWait(driver, 60);
	driver.findElement(applyNowBttn).click();
	Log.info(driver.findElement(welcomeText).getText());
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueBttn)));
	Log.info("Entering valid email address");
	driver.findElement(By.id(getVal.getProp("emailInputLoginPage"))).clear();
	driver.findElement(By.id(getVal.getProp("emailInputLoginPage"))).sendKeys(getVal.getProp("emailValid"));
	driver.findElement(continueBttn).click();
	Log.info("waiting till registration page appears..");
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(getVal.getProp("firstNameField")))));
    }
    
    
    @SuppressWarnings("deprecation")
	public void textOperations(String element, String key)
    {
    	Log.info("Size of text entered is: "+getVal.getProp(key).length());
    	switch(element)
    	{
    	case "firstNameField":
    		 enterText(By.id(getVal.getProp("firstNameField")), getVal.getProp(key));
    		 break;
    	case "lastNameField":
   		     enterText(By.id(getVal.getProp("lastNameField")), getVal.getProp(key));
   		     break;
    	case "phoneTextField":
  		     enterText(By.id(getVal.getProp("phoneTextField")), getVal.getProp(key));
  		     break;
    	case "postalCodeField":
 		     enterText(By.id(getVal.getProp("postalCodeField")), getVal.getProp(key));
 		     break;
    	case "emailInputRegistrationForm":
		     enterText(By.id(getVal.getProp("emailInputRegistrationForm")), getVal.getProp(key));
		     break;
    	}	
    }
    
    @SuppressWarnings("deprecation")
	public void selectPhoneType(String type)
    {
    	Select fromDropdown = new Select(driver.findElement(phoneType));
    	
    	try
    	{
    		fromDropdown.selectByValue(type);	
    	}
    	catch(NoSuchElementException e)
    	{
    		Log.info("INVALID INPUT..");
    	}
    }
    
    /*Method to test disappearance of error code on adding correct input*/
    public void disappearanceOfErrorMessage(By by, By by2, String wrongText, String correctText) throws InterruptedException
    {
    	/*ENTERING WRONG INPUT*/
    	enterText(by, wrongText);
    	driver.findElement(by2).click();
		/*ENTERING CORRECT VALUE*/
		enterText(by, correctText);
    	driver.findElement(by2).click();
    	Thread.sleep(10000);
    }
    
    @SuppressWarnings("deprecation")
	public void enterText(By by, String text)
    {
    	driver.findElement(by).clear();
    	driver.findElement(by).sendKeys(text);
    	Log.info("ENTERED text is: "+driver.findElement(by).getAttribute("value"));
    }
	}
      

