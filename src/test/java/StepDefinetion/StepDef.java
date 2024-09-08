package StepDefinetion;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObject.IncubyteAccountPage;
import PageObject.Sign_inPage;
import TestRunner.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass{

	/*@Before
	public void setup1()
	{
		readConfig = new ReadConfig();
		
		//initialise logger
		//log = LogManager.getLogger("StepDef");

		System.out.println("Setup-Sanity method executed..");

		String browser = readConfig.getBrowser();
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

	
		log.fatal("Setup1 executed...");


	}
	@Before()
	public void setup2()
	{
	    //Initiaise Logger 
	     
	   // Log =LogManager.getLogger(StepDef);
		System.out.println("Setup2-Regression method executed..");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//log.info("Setup2 executed...");
	}*/
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		Sign   =new Sign_inPage(driver);
		Account=new IncubyteAccountPage(driver);
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		 
		driver.get("url");
		//log.info("url opened");
	}

	@When("Click on Create an Account Link")
	public void click_on_create_an_account_link() {
		Account.CreateAccount();
	}

	@When("User enters FirstName as\"Raj\" and LastName as {string} and Email as {string} and Password as {string} and ConfirmPass as {string}")
	public void user_enters_first_name_as_raj_and_last_name_as_and_email_as_and_password_as_and_confirm_pass_as(String last, String email, String password, String confirmP) {
		Account.FirstName("Raj");
		Account.LastName(last);
		Account.Email(email);
		Account.Password(password);
		Account.Confirmation(confirmP);
	}

@When("Click on Create an Account")
public void click_on_create_an_account() {
	
	Account.CreateAccount_btn();
}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle ) {
		String actualTitle   = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
        String expectedTitle1 ="Thank you for registering with Main Website Store.";
		
		if(actualTitle.equals(expectedTitle1))
		{
			//log.warn("Test passed: Login feature :Page title matched.");

			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
			//log.warn("Test Failed: Login feature- page title not matched.");


		}
	}

	  /////////////////////////---------MissingFirstName----------------//////////////////////////////
	
	@When("User enters  LastName as {string} and Email as {string} and Password as {string} and ConfirmPass as {string}")
	public void user_enters_last_name_as_and_email_as_and_password_as_and_confirm_pass_as(String last, String email, String password, String confirmP) {
		Account.LastName(last);
		Account.Email(email);
		Account.Password(password);
		Account.Confirmation(confirmP);
	}
	@Then("Error Message should be {string}")
	public void error_message_should_be(String expectedTitle) {
		String actualTitle   = driver.findElement(By.xpath("//div[@for='firstname'] [@class='mage-error']")).getText();
        String expectedTitle3 ="This is a required field.";
		
		if(actualTitle.equals(expectedTitle3))
		{
			//log.warn("Test passed: Login feature :Page title matched.");

			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
			//log.warn("Test Failed: Login feature- page title not matched.");


		}
	}

	@When("Click on Sign-In Link")
	public void click_on_sign_in_link() {
		Sign.Sign_in();
	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailSign, String passwordSign) {
		Sign.Email_Sign(emailSign);
		Sign.Password_Sign(passwordSign);
	}
	@When("Click on SignIn button")
	public void click_on_sign_in_button() {
		Sign.SignButton();
	}
	@Then("Page Title should be \"My Account")
	public void page_title_should_be_thank_you_for_registering_with_main_website_store() {
		if(driver.getPageSource().contains("My Account")){
			System.out.println("My Account Screen is present");
			}else{
			System.out.println("My Account Screen  absent");
			}

	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
		//log.info("Browser closed");

		driver.quit();
	}
	
	public void teardown(Scenario sc)
	{
		System.out.println("Tear Down method executed..");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = ".\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
		driver.quit();
	}

}
