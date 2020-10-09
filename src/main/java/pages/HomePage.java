package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagesBase.SeleniumBasicFunctions;
import seleniumWrapper.SelLocators;

public class HomePage extends SeleniumBasicFunctions{

	public HomePage(WebDriver local_driver) {
		super(local_driver);
		// TODO Auto-generated constructor stub
		
	}

	private static String registerLocator = "Register";
	private static WebElement registerLink;
	private static String signUpFlagLocator = "//h1[contains(text(),'Register')]";
	private static String logoutLocator = "//a[contains(text(), 'Log out')]";
	private static WebElement logoutBtnElement;
	private static String loginLocator = "//a[contains(text(), 'Log in')]";
	private static WebElement loginBtnElement;
	private static String searchBoxLocator = "//input[@id='small-searchterms']";
	private static WebElement searchBoxElement;
	private static String resultsLocator = "//ul[@id='ui-id-1']";
	private static WebElement resultsElement;
	private static String shoppingCartLocator = "//span[@class='cart-label' and contains(text(), 'Shopping cart')]";
	private static WebElement shoppingCartElement;
	
	
	
	public void clickRegistrationLink(WebDriver local_driver) 
	{
		registerLink = locators.locateElement(local_driver, "linkTxt", registerLocator);
		clickButtonOrLink(local_driver, registerLink);
		waitForElementToBeVisible(local_driver, signUpFlagLocator);
	}
	
	public void clickLogoutButton(WebDriver local_driver) 
	{
		//waitForElementToBeVisible(local_driver, logoutLocator);
		logoutBtnElement = locators.locateElement(local_driver, "xpath", logoutLocator);
		clickButtonOrLink(local_driver, logoutBtnElement);
	}
	
	public void clickLoginButton(WebDriver local_driver) 
	{
		//waitForElementToBeVisible(local_driver, loginLocator);
		loginBtnElement = locators.locateElement(local_driver, "xpath", loginLocator);
		clickButtonOrLink(local_driver, loginBtnElement);
	}
	
	public void searchForProduct(WebDriver local_driver, String partOfProductName) 
	{
		searchBoxElement = locators.locateElement(local_driver, "xpath", searchBoxLocator);
		setTextElementText(local_driver, searchBoxElement, partOfProductName);
	}
	public void selectFirstProductAutoComplete(WebDriver local_driver) 
	{
		resultsElement = locators.locateElement(local_driver, "xpath", resultsLocator);
		clickButtonOrLink(local_driver, resultsElement);
	}
	public void clickShoppingCart(WebDriver local_driver) 
	{
		shoppingCartElement = locators.locateElement(local_driver, "xpath", shoppingCartLocator);
		clickButtonOrLink(local_driver, shoppingCartElement);
	}
	
		
}
