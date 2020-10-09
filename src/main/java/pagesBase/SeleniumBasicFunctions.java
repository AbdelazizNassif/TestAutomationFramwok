package pagesBase;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumWrapper.SelLocators;

public class SeleniumBasicFunctions {
	protected static SelLocators locators;
	protected static Select select;
	protected static JavascriptExecutor js;
	protected static Actions action;
	protected static WebDriverWait wait ;

	/*constructor of the class*/
	public SeleniumBasicFunctions(WebDriver local_driver)
	{
		/*init all webelements od web page with their attributes
		 * using initElements method from PageFactory class */
		PageFactory.initElements(local_driver, this);
		wait = new WebDriverWait(local_driver, 15);
		locators = new SelLocators();
		action = new Actions(local_driver); 
	}
	
	public void waitForElementToBeVisible(WebDriver local_driver, String locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	/*clicking on webelements function(button/link)*/
	public void clickButtonOrLink(WebDriver local_driver, WebElement btn)
	{
		btn.click();
	}
	/*sending text to  webelements */
	public void setTextElementText(WebDriver local_driver, WebElement textElem, String value)
	{
		textElem.clear();
		textElem.sendKeys(value);
	}
	/*selecting on an option from drop deon list by visible text*/
	public static void selectCategory(WebElement catList, String visibleTxt)
	{
		select = new Select(catList);
		select.selectByVisibleText(visibleTxt);
	}
	/*scrolling to certain web element on the DOM*/
	public static void scrollToElement(WebDriver local_driver, WebElement webElm)
	{
		/*Casting WebDriver to JavascriptExecutor to execute javaScript code*/
		js = (JavascriptExecutor) local_driver;
		/*getting the location of the web element to scroll to it*/
		Point loc = webElm.getLocation();
		int x;
		int y;
		/*generating the x and y of the location*/
		x = loc.getX();
		y = loc.getY();
		/*scroll to the element*/
		js.executeScript("window.scrollBy(" + x + "," + y + ")" );
	}

}
