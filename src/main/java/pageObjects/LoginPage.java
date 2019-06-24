package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LoginPage extends Base {
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pass;
	
	@FindBy(id="login_submit")
	WebElement submitbtn;
	
	
	public WebElement EmailId()
	{
		return email;
	}
	
	public WebElement Password()
	{
		return pass;
	}
	
	public WebElement btnSubmit()
	{
		return submitbtn;
	}

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
