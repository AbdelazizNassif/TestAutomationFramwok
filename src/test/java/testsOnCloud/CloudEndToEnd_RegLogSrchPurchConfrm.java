package testsOnCloud;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PurchasePage;
import pages.RegistrationPage;
import pages.ShoppingCartPage;
import testDataGeneratorClass.DataGenerator;
import testSetUp.TestBase;
import testSetUpGCP.TestBaseGCP;


public class CloudEndToEnd_RegLogSrchPurchConfrm extends TestBaseGCP{
	HomePage hpObj;
	RegistrationPage regPageObj;
	LoginPage loginPageObj;
	PurchasePage purchaePageObj;
	ShoppingCartPage shoppingPageObj;
	CheckOutPage chechOutPageObj;
	static Logger log ;

	
	
	/*Test Data*/
	private static String validEmail;
	private static String  ValidPassword;
	
	
	@DataProvider(name = "RegThenLogin")
	public static Object[][] credentials() {
		return new Object[][] 
		{
			{ "user"       ,   ValidPassword }, 
			{ validEmail   ,   ValidPassword }
		};
	}
	@DataProvider(name = "productsName")
	public static Object[][] productsName() {
		return new Object[][] 
		{
			{ "appl"  }  , 
			{ "mac" }
		};
	}

	@BeforeClass
	public void setUpRegistrationTestCases()
	{
		log = Logger.getLogger(CloudEndToEnd_RegLogSrchPurchConfrm.class.getName());
		hpObj = new HomePage(driver);
		regPageObj = new RegistrationPage(driver);
		loginPageObj = new LoginPage(driver);
		purchaePageObj = new PurchasePage(driver);
		shoppingPageObj = new ShoppingCartPage(driver);
		chechOutPageObj = new CheckOutPage(driver);
		DataGenerator dataObj = new DataGenerator();
		validEmail = dataObj.generateRandomEmail(5);
		ValidPassword = dataObj.generateRandomPassword();
		driver.navigate().to(aut_url);
		hpObj.clickRegistrationLink(driver);
	}

	@Test(priority = 1, dataProvider = "RegThenLogin")
	public void RegisterationMultipleTestCase(String email, String passWord)
	{		
		log.info("****************************** highest priority test case  *****************************************");
		regPageObj.fillFirstName(driver, "Ali");
		regPageObj.fillLastName(driver, "Ali");
		regPageObj.fillEmail(driver, email);
		regPageObj.fillPassword(driver, passWord);
		regPageObj.fillConfirmPassword(driver, passWord);
		regPageObj.clickRegisterButton(driver);
	}

	@Test(priority = 2)
	public void userLogOut()
	{		
		log.info("****************************** second priority test case  *****************************************");
		hpObj.clickLogoutButton(driver);
		hpObj.clickLoginButton(driver);
	}

	@Test(priority = 3, dataProvider = "RegThenLogin")
	public void userLogIn(String email, String passWord)
	{		
		log.info("****************************** third priority test case  *****************************************");
		loginPageObj.fillEmail(driver, email);
		loginPageObj.fillPassword(driver, passWord);
		loginPageObj.clickLoginButton(driver);
	}
	
	@Test(priority = 4, dataProvider = "productsName")
	public void searchProduct(String productName)
	{		
		log.info("****************************** fourth priority test case  *****************************************");
		hpObj.searchForProduct(driver, productName);
		hpObj.selectFirstProductAutoComplete(driver);
	}
	
	@Test(priority = 5)
	public void purchaseItem()
	{		
		log.info("****************************** fifth priority test case  *****************************************");
		purchaePageObj.determineQuantity(driver, "2");
		purchaePageObj.clickAddToCart(driver);
		hpObj.clickShoppingCart(driver);
		shoppingPageObj.agreeTermsAndConditions(driver);
		shoppingPageObj.clickCheckout(driver);
		chechOutPageObj.chooseCountry(driver, "Egypt");
		chechOutPageObj.chooseCity(driver, "Cairo");
		chechOutPageObj.writeAddress(driver, "Maadi, Cairo");
		chechOutPageObj.writeZip(driver, "21563");
		chechOutPageObj.writePhone(driver, "21564268759");
		chechOutPageObj.pressContinue(driver);
		chechOutPageObj.pressSecondContinue(driver);
		chechOutPageObj.pressThirdContinue(driver);
		chechOutPageObj.pressFourthContinue(driver);
		chechOutPageObj.confirmOrder(driver);
		Assert.assertTrue(chechOutPageObj.checkSuccOrder(driver));
	}
}
