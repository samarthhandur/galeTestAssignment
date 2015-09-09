package galePartnersTestAssignment;

import java.util.concurrent.TimeUnit;

import org.seleniumhq.jetty7.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class unitTestClass 
{
	public WebDriver driver;
	private static String baseUrl;
	readPropertiesClass getVal = new readPropertiesClass();

	/*overriding setup method*/
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() throws Exception
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
	    driver = new FirefoxDriver(profile);	    
	    baseUrl = "https://www.easyfinancial.com";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Log.info("Lets Begin the test!!--------------------------------------------------------------------");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void emailFieldTestForValidInput()
	{
		Log.info("Test for valid email id");
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("emailInputRegistrationForm", "emailValid");
		driver.findElement(By.id("f_name")).click();
		Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void emailFieldTestForInValidInput() throws InterruptedException
	{
		Log.info("Test for invalid email input");
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("emailInputRegistrationForm", "emailInValid");
		driver.findElement(By.id("f_name")).click();
		Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void firstNameFieldTestForValidInput()
	{	
		Log.info("Test for valid first name input");
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("firstNameField", "firstnameValid");
		driver.findElement(By.id("l_name")).click();
		Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void firstNameFieldTestForInValidInput()
	{
		Log.info("Test for invalid first name input");
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("firstNameField", "firstnameWithSpecialChar");
		driver.findElement(By.id("l_name")).click();
		Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void firstNameFieldTestForOutOfBoundInput()
	{
		Log.info("Test for out of bound first name input");
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("firstNameField", "firstnameOutOfBound");
		driver.findElement(By.id("l_name")).click();
		Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void firstNameFieldTestWithSpacesInInput()
	{
		Log.info("Test for first name input with spaces");
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("firstNameField", "firstnameWithSpaces");
		driver.findElement(By.id("l_name")).click();
		Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDisappearanceOfErrorMessageFirstNameInput() throws InterruptedException
	{
		Log.info("Test checking the disappearance of error code on entering correct input");
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.disappearanceOfErrorMessage(By.id(getVal.getProp("firstNameField")), By.id(getVal.getProp("lastNameField")), "90980dwf", "samarth");
		Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
	}
	
@SuppressWarnings("deprecation")
@Test
public void lastNameFieldTestForValidInput()
{
	Log.info("Test for valid last name input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("lastNameField", "lastnameValid");
	driver.findElement(By.id("f_name")).click();
	Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
}

@SuppressWarnings("deprecation")
@Test
public void lastNameFieldTestForInValidInput()
{
	Log.info("Test for invalid last name input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("lastNameField", "lastnameWithSpecialChar");
	driver.findElement(By.id("f_name")).click();
	Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
}

@SuppressWarnings("deprecation")
@Test
public void lastNameFieldTestForOutOfBoundInput()
{
	Log.info("Test for out of bound last name input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("lastNameField", "lastnameOutOfBound");
	driver.findElement(By.id("f_name")).click();
	Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
}

@SuppressWarnings("deprecation")
@Test
public void lastNameFieldTestWithSpacesInInput()
{
	Log.info("Test for last name input with spaces");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("lastNameField", "lastnameWithSpaces");
	driver.findElement(By.id("f_name")).click();
	Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
}

@SuppressWarnings("deprecation")
@Test
public void testDisappearanceOfErrorMessageLastNameInput() throws InterruptedException
{
	Log.info("Test checking the disappearance of error code on entering correct input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.disappearanceOfErrorMessage(By.id(getVal.getProp("lastNameField")), By.id(getVal.getProp("firstNameField")), "90980dwf", "handur");
	Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));

}
	
@SuppressWarnings("deprecation")
@Test
public void testSelectPhoneType()
{
	Log.info("Test for selecting phone type input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.selectPhoneType("MOBILE");
	Assert.assertEquals("MOBILE", driver.findElement(By.name("phoneType")).getAttribute("value"));
    Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
}

@SuppressWarnings("deprecation")
@Test
public void testEnterValidPhoneNumber()
{
	Log.info("Test for valid phone number input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.selectPhoneType("MOBILE");
	obj.enterText(By.id(getVal.getProp("phoneTextField")), getVal.getProp("validPhoneNumber"));
	driver.findElement(By.id("f_name")).click();
    Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
}

@SuppressWarnings({ "deprecation"})
@Test
public void testEnterInValidPhoneNumber()
{
	Log.info("Test for invalid phone number input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.selectPhoneType("MOBILE");
	obj.enterText(By.id(getVal.getProp("phoneTextField")), getVal.getProp("invalidPhoneNumber"));
	driver.findElement(By.id("f_name")).click();
    Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
}

@SuppressWarnings("deprecation")
@Test
public void testEnterInValidPostCode()
{
	Log.info("Test for invalid postcode input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("postalCodeField", "postCodeInvalid");
    driver.findElement(By.id("f_name")).click();
    Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));		
}

@SuppressWarnings("deprecation")
@Test
public void testEnterValidPostCode()
{
	Log.info("Test for valid postcode input");
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("postalCodeField", "postcodeValid");
    driver.findElement(By.id("f_name")).click();
    Assert.assertEquals(false, checkVisibility(By.cssSelector("label.error")));		
}
	
/*Check the availibility of elements*/
	@SuppressWarnings("deprecation")
	public boolean checkVisibility(By by)
    {
    	try
    	{
    		driver.findElement(by);
    		Log.info("ERROR: "+driver.findElement(by).getText());
    		return true;
    	}
    	catch(NoSuchElementException e)
    	{
    		return false;
    	}
    }
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}

