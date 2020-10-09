package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagesBase.SeleniumBasicFunctions;
import seleniumWrapper.SelLocators;

public class RegistrationPage extends SeleniumBasicFunctions{

	public RegistrationPage(WebDriver local_driver) {
		super(local_driver);
		// TODO Auto-generated constructor stub
		
	}

	private static String fNameLocator = "FirstName";
	private static WebElement fNameElement;
	private static String lNameLocator = "LastName";
	private static WebElement lNameElement;
	private static String emailLocator = "Email";
	private static WebElement emailElement;
	private static String passwordLocator = "Password";
	private static WebElement passwordElement;
	private static String confirmPasswordLocator = "ConfirmPassword";
	private static WebElement confirmPasswordElement;
	private static String registerBtnLocator = "register-button";
	private static WebElement registerBtnElement;
	
	
	
	public void fillFirstName(WebDriver local_driver, String name) 
	{
		fNameElement = locators.locateElement(local_driver, "id", fNameLocator);
		setTextElementText(local_driver, fNameElement, name);
	}
	
	public void fillLastName(WebDriver local_driver, String name) 
	{
		lNameElement = locators.locateElement(local_driver, "id", lNameLocator);
		setTextElementText(local_driver, lNameElement, name);
	}
	
	public void fillEmail(WebDriver local_driver, String email) 
	{
		emailElement = locators.locateElement(local_driver, "id", emailLocator);
		setTextElementText(local_driver, emailElement, email);
	}
	
	public void fillPassword(WebDriver local_driver, String password) 
	{
		passwordElement = locators.locateElement(local_driver, "id", passwordLocator);
		scrollToElement(local_driver, passwordElement);
		setTextElementText(local_driver, passwordElement, password);
	}
	public void fillConfirmPassword(WebDriver local_driver, String password) 
	{
		confirmPasswordElement = locators.locateElement(local_driver, "id", confirmPasswordLocator);
		scrollToElement(local_driver, confirmPasswordElement);
		setTextElementText(local_driver, confirmPasswordElement, password);
	}
	public void clickRegisterButton(WebDriver local_driver) 
	{
		registerBtnElement = locators.locateElement(local_driver, "id", registerBtnLocator);
		scrollToElement(local_driver, registerBtnElement);
		clickButtonOrLink(local_driver, registerBtnElement);
	}
	
	
	
	
	
		
}
