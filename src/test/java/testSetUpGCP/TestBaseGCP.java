package testSetUpGCP;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import tests.EndToEnd_RegLogSrchPurchConfrm;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBaseGCP {

	/*This driver will send commands to the browser for the automation purposes*/
	public static WebDriver driver ; 
	public static String aut_url = "https://demo.nopcommerce.com/"; 
	public static Logger log;


	@BeforeTest
	@Parameters({"browser"})
	public void startDriver(@Optional("null") String browserName) throws MalformedURLException {

		log = Logger.getLogger(TestBaseGCP.class.getName());

		String remoteUrl = "http://" + "naveenautomation" + ":Zalenium2020@" + "35.226.55.48/wd/hub";
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);

		caps.setCapability("build", 1.1);
		caps.setCapability("idleTimeout", 180);
		caps.setCapability("recordVideo", true);
		caps.setCapability("tz", "Asia/Kolkata");

		if (browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			//driver = new ChromeDriver(chromeOption());
			//setup the chromedriver using WebDriverManager

			WebDriverManager.chromedriver().setup();
			caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			//Create driver object for Chrome


		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			//driver = new FirefoxDriver(firefoxOption());
			WebDriverManager.firefoxdriver().setup();
			caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);

		}

		try {
			driver = new RemoteWebDriver(new URL(remoteUrl), caps);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		}
		catch(MalformedURLException e)
		{
			System.out.println("Failed to connect to remote driver");
			e.printStackTrace();
		}

	} 

	/*Method will run one time after the suite to quit all the browsers' windows*/

	@AfterTest
	public void stopDriver() 
	{
		driver.quit();
	}

	/* method will run once after every annotated testng method and
	 *  take screenshot the method fails and add it in the Screenshot folder */
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
