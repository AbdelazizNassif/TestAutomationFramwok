package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagesBase.SeleniumBasicFunctions;
import seleniumWrapper.SelLocators;

public class CheckOutPage extends SeleniumBasicFunctions{

	public CheckOutPage(WebDriver local_driver) {
		super(local_driver);
		// TODO Auto-generated constructor stub
		
	}

	private static String countryListLocator = "BillingNewAddress_CountryId";
	private static WebElement countryListElement;
	private static String cityListLocator = "BillingNewAddress_City";
	private static WebElement cityListElement;
	private static String addressLocator = "BillingNewAddress_Address1";
	private static WebElement addressElement;
	private static String zipLocator = "BillingNewAddress_ZipPostalCode";
	private static WebElement zipElement;
	private static String phoneLocator = "BillingNewAddress_PhoneNumber";
	private static WebElement phoneElement;
	private static String contiuneBtnLocator = "//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']";
	private static WebElement contiuneBtnElement;
	private static String secondContiuneBtnLocator = "//div[@id='shipping-method-buttons-container']//input[@value='Continue']";
	private static WebElement secondContiuneBtnElement;
	private static String thirdContiuneBtnLocator = "//div[@id='payment-method-buttons-container']//input[@value='Continue']";
	private static WebElement thirdContiuneBtnElement;
	private static String fourthContiuneBtnLocator = "//div[@id='payment-info-buttons-container']//input[@value='Continue']";
	private static WebElement fourthContiuneBtnElement;
	private static String confirmBtnLocator = "//input[@value='Confirm']";
	private static WebElement confirmBtnElement;
	private static String successfulOrderFlagLocator = "//strong[contains(text(), 'Your order has been successfully processed!')]";
	private static WebElement successfulOrderFlagElement;
	

	public void chooseCountry(WebDriver local_driver, String countryName) 
	{
		countryListElement = locators.locateElement(local_driver, "id", countryListLocator);
		scrollToElement(local_driver, countryListElement);
		selectCategory(countryListElement, countryName);
	}
	
	public void chooseCity(WebDriver local_driver, String cityName) 
	{
		cityListElement = locators.locateElement(local_driver, "id", cityListLocator);
		scrollToElement(local_driver, cityListElement);
		setTextElementText(local_driver, cityListElement, cityName);
	}
	public void writeAddress(WebDriver local_driver, String address) 
	{
		addressElement = locators.locateElement(local_driver, "id", addressLocator);
		scrollToElement(local_driver, addressElement);
		setTextElementText(local_driver, addressElement, address);
	}
	public void writeZip(WebDriver local_driver, String zip) 
	{
		zipElement = locators.locateElement(local_driver, "id", zipLocator);
		scrollToElement(local_driver, zipElement);
		setTextElementText(local_driver, zipElement, zip);
	}
	public void writePhone(WebDriver local_driver, String phone) 
	{
		phoneElement = locators.locateElement(local_driver, "id", phoneLocator);
		scrollToElement(local_driver, phoneElement);
		setTextElementText(local_driver, phoneElement, phone);
	}
	public void pressContinue(WebDriver local_driver) 
	{
		contiuneBtnElement = locators.locateElement(local_driver, "xpath", contiuneBtnLocator);
		scrollToElement(local_driver, contiuneBtnElement);
		clickButtonOrLink(local_driver, contiuneBtnElement);
	}
	public void pressSecondContinue(WebDriver local_driver) 
	{
		secondContiuneBtnElement = locators.locateElement(local_driver, "xpath", secondContiuneBtnLocator);
		scrollToElement(local_driver, secondContiuneBtnElement);
		clickButtonOrLink(local_driver, secondContiuneBtnElement);
	}
	public void pressThirdContinue(WebDriver local_driver) 
	{
		thirdContiuneBtnElement = locators.locateElement(local_driver, "xpath", thirdContiuneBtnLocator);
		scrollToElement(local_driver, thirdContiuneBtnElement);
		clickButtonOrLink(local_driver, thirdContiuneBtnElement);
	}
	public void pressFourthContinue(WebDriver local_driver) 
	{
		fourthContiuneBtnElement = locators.locateElement(local_driver, "xpath", fourthContiuneBtnLocator);
		scrollToElement(local_driver, fourthContiuneBtnElement);
		clickButtonOrLink(local_driver, fourthContiuneBtnElement);
	}
	public void confirmOrder(WebDriver local_driver) 
	{
		confirmBtnElement = locators.locateElement(local_driver, "xpath", confirmBtnLocator);
		scrollToElement(local_driver, confirmBtnElement);
		clickButtonOrLink(local_driver, confirmBtnElement);
	}
	public boolean checkSuccOrder(WebDriver local_driver) 
	{
		successfulOrderFlagElement = locators.locateElement(local_driver, "xpath", successfulOrderFlagLocator);
		return successfulOrderFlagElement.isDisplayed();
	}
	
	
		
}
