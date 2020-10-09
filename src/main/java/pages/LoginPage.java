package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagesBase.SeleniumBasicFunctions;
import seleniumWrapper.SelLocators;

public class LoginPage extends SeleniumBasicFunctions{

	public LoginPage(WebDriver local_driver) {
		super(local_driver);
		// TODO Auto-generated constructor stub
		
	}

	
	private static String emailLocator = "Email";
	private static WebElement emailElement;
	private static String passwordLocator = "Password";
	private static WebElement passwordElement;
	
	private static String loginBtnLocator = "//input[@class='button-1 login-button']";
	private static WebElement loginBtnElement;
	
	
	
	
	
	public void fillEmail(WebDriver local_driver, String email) 
	{
		emailElement = locators.locateElement(local_driver, "id", emailLocator);
		setTextElementText(local_driver, emailElement, email);
	}
	
	public void fillPassword(WebDriver local_driver, String password) 
	{
		passwordElement = locators.locateElement(local_driver, "id", passwordLocator);
		//scrollToElement(local_driver, passwordElement);
		setTextElementText(local_driver, passwordElement, password);
	}
	
	public void clickLoginButton(WebDriver local_driver) 
	{
		loginBtnElement = locators.locateElement(local_driver, "xpath", loginBtnLocator);
		//scrollToElement(local_driver, loginBtnElement);
		clickButtonOrLink(local_driver, loginBtnElement);
	}
	
	
	
	
	
		
}
