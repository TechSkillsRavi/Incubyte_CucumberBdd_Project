package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sign_inPage {

	WebDriver ldriver;

	public  Sign_inPage(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(linkText="Sign In")
	WebElement Sign_in;
	
	public void Sign_in()
	{
		Sign_in.click();
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Email_Sign;
	
	public void Email_Sign(String email_sign)
	{
		Email_Sign.click();
		Email_Sign.sendKeys(email_sign);
	}
	
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Password_Sign;
	
	public void Password_Sign(String pass_sign)
	{
		Password_Sign.click();
		Password_Sign.sendKeys(pass_sign);
	}
	
	
	
	@FindBy(xpath="//button//span[contains(text(),'Sign In')]")
	WebElement SignButton;
	
	public void SignButton()
	{
		SignButton.click();
		
	}
	
	
	
	
	
	
	
	
	
}
