package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagesBase.SeleniumBasicFunctions;
import seleniumWrapper.SelLocators;

public class ShoppingCartPage extends SeleniumBasicFunctions{

	public ShoppingCartPage(WebDriver local_driver) {
		super(local_driver);
		// TODO Auto-generated constructor stub
		
	}

	private static String checkoutLocator = "//button[@id='checkout']";
	private static WebElement checkoutElement;
	
	private static String agreeTermsLocator = "//input[@id='termsofservice']";
	private static WebElement agreeTermsElement;

	public void agreeTermsAndConditions(WebDriver local_driver) 
	{
		agreeTermsElement = locators.locateElement(local_driver, "xpath", agreeTermsLocator);
		scrollToElement(local_driver, agreeTermsElement);
		clickButtonOrLink(local_driver, agreeTermsElement);
	}
	
	public void clickCheckout(WebDriver local_driver) 
	{
		checkoutElement = locators.locateElement(local_driver, "xpath", checkoutLocator);
		scrollToElement(local_driver, checkoutElement);
		clickButtonOrLink(local_driver, checkoutElement);
	}
	
	
		
}
