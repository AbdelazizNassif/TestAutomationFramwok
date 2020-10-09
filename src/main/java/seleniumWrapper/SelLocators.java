package seleniumWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelLocators {
	public WebDriverWait wait ;

	
	public WebElement locateElement(WebDriver local_driver, String methodOfLocating, String locator)
	{
		wait = new WebDriverWait(local_driver, 25);
		
		if(methodOfLocating == "xpath") 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			return local_driver.findElement(By.xpath(locator));
		}
		else if(methodOfLocating == "name")
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
			return local_driver.findElement(By.name(locator));
		}
		else if(methodOfLocating == "class")
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			return local_driver.findElement(By.className(locator));
		}
		else if(methodOfLocating == "css")
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			return local_driver.findElement(By.cssSelector(locator));
		}
		else if(methodOfLocating == "id")
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			return local_driver.findElement(By.id(locator));
		}
		else if(methodOfLocating == "linkTxt")
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
			return local_driver.findElement(By.linkText(locator));
		}
		else {
			System.out.println("Stop Operation --> Not Valid selenium Locator");
			return null;
		}

	}


}
