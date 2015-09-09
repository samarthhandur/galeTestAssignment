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
	    Log.info("--------------------------------------------------------------------");
	}
	
	@Test
	public void emailFieldTestForValidInput()
	{
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("emailInputRegistrationForm", "emailValid");
		driver.findElement(By.id("f_name")).click();
		Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
	}
	
	@Test
	public void emailFieldTestForInValidInput() throws InterruptedException
	{
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("emailInputRegistrationForm", "emailInValid");
		driver.findElement(By.id("f_name")).click();
		Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
	}
	
	@Test
	public void firstNameFieldTestForValidInput()
	{
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("firstNameField", "firstnameValid");
		driver.findElement(By.id("l_name")).click();
		Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
	}
	
	@Test
	public void firstNameFieldTestForInValidInput()
	{
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("firstNameField", "firstnameWithSpecialChar");
		driver.findElement(By.id("l_name")).click();
		Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
	}
	
	@Test
	public void firstNameFieldTestForOutOfBoundInput()
	{
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("firstNameField", "firstnameOutOfBound");
		driver.findElement(By.id("l_name")).click();
		Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
	}
	
	@Test
	public void firstNameFieldTestWithSpacesInInput()
	{
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.textOperations("firstNameField", "firstnameWithSpaces");
		driver.findElement(By.id("l_name")).click();
		Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
	}
	
	@Test
	public void testDisappearanceOfErrorMessageFirstNameInput() throws InterruptedException
	{
		driver.get(baseUrl);
		pageClass obj = new pageClass(driver);
		obj.goToRegistrationForm();
		obj.disappearanceOfErrorMessage(By.id(getVal.getProp("firstNameField")), By.id(getVal.getProp("lastNameField")), "90980dwf", "samarth");
		Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
	}
	
@Test
public void lastNameFieldTestForValidInput()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("lastNameField", "lastnameValid");
	driver.findElement(By.id("f_name")).click();
	Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
}

@Test
public void lastNameFieldTestForInValidInput()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("lastNameField", "lastnameWithSpecialChar");
	driver.findElement(By.id("f_name")).click();
	Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
}

@Test
public void lastNameFieldTestForOutOfBoundInput()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("lastNameField", "lastnameOutOfBound");
	driver.findElement(By.id("f_name")).click();
	Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
}

@Test
public void lastNameFieldTestWithSpacesInInput()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("lastNameField", "lastnameWithSpaces");
	driver.findElement(By.id("f_name")).click();
	Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
}

@Test
public void testDisappearanceOfErrorMessageLastNameInput() throws InterruptedException
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.disappearanceOfErrorMessage(By.id(getVal.getProp("lastNameField")), By.id(getVal.getProp("firstNameField")), "90980dwf", "handur");
	Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));

}
	
@Test
public void testSelectPhoneType()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.selectPhoneType("MOBILE");
	Assert.assertEquals("MOBILE", driver.findElement(By.name("phoneType")).getAttribute("value"));
    Assert.assertEquals("true", checkVisibility(By.cssSelector("label.error")));
}

@Test
public void testEnterValidPhoneNumber()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.selectPhoneType("MOBILE");
	obj.enterText(By.id(getVal.getProp("phoneTextField")), getVal.getProp("validPhoneNumber"));
	driver.findElement(By.id("f_name")).click();
    Assert.assertFalse(checkVisibility(By.cssSelector("label.error")));
}

@Test
public void testEnterInValidPhoneNumber()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.selectPhoneType("MOBILE");
	obj.enterText(By.id(getVal.getProp("phoneTextField")), getVal.getProp("invalidPhoneNumber"));
	driver.findElement(By.id("f_name")).click();
    Assert.assertTrue(checkVisibility(By.cssSelector("label.error")));
}

@Test
public void testEnterInValidPostCode()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("postalCodeField", "postCodeInvalid");
    driver.findElement(By.id("f_name")).click();
    Assert.assertEquals(true, checkVisibility(By.cssSelector("label.error")));		
}

@Test
public void testEnterValidPostCode()
{
	driver.get(baseUrl);
	pageClass obj = new pageClass(driver);
	obj.goToRegistrationForm();
	obj.textOperations("postalCodeField", "postcodeValid");
    driver.findElement(By.id("f_name")).click();
    Assert.assertEquals(false, checkVisibility(By.cssSelector("label.error")));		
}
	
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

