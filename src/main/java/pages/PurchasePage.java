package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagesBase.SeleniumBasicFunctions;
import seleniumWrapper.SelLocators;

public class PurchasePage extends SeleniumBasicFunctions{

	public PurchasePage(WebDriver local_driver) {
		super(local_driver);
		// TODO Auto-generated constructor stub
		
	}

	private static String quantityBoxLocator = "//input[@id='product_enteredQuantity_4']";
	private static WebElement quantityBoxElement;
	private static String addToCartBtnLocator = "//input[@id='add-to-cart-button-4']";
	private static WebElement addToCartBtnElement;

	
	public void determineQuantity(WebDriver local_driver, String  quantity) 
	{
		quantityBoxElement = locators.locateElement(local_driver, "xpath", quantityBoxLocator);
		setTextElementText(local_driver, quantityBoxElement, quantity);
	}
	
	public void clickAddToCart(WebDriver local_driver) 
	{
		addToCartBtnElement = locators.locateElement(local_driver, "xpath", addToCartBtnLocator);
		clickButtonOrLink(local_driver, addToCartBtnElement);
	}
	
	
		
}
