package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncubyteAccountPage {

	WebDriver ldriver;

	public  IncubyteAccountPage(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(linkText="Create an Account")
	WebElement CreateAccount;
	
	public void CreateAccount()
	{
		CreateAccount.click();
	}
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement FirstName;
	
	public void FirstName(String firstN)
	{
		FirstName.click();
		FirstName.sendKeys(firstN);
	}
	
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement LastName;
	
	public void LastName(String lastN)
	{
		LastName.sendKeys(lastN);
	}
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement Email;
	
	public void Email(String emailA)
	{
		Email.sendKeys(emailA);
	}
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	public void Password(String passD)
	{
		Password.sendKeys(passD);
	}
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement Confirmation;
	
	public void Confirmation(String confirmPD)
	{
		Confirmation.sendKeys(confirmPD);
	}
	
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement CreateAccount_btn;
	
	public void CreateAccount_btn()
	{
		CreateAccount_btn.click();
	}
	
	
	
	
}
