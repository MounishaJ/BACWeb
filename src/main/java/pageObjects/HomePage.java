package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class HomePage extends Base
{
	
	@FindBy(xpath="//span[@class='plan_name']")
	WebElement role;
	
	@FindBy(xpath="//span[contains(text(),'Customers')]")
	WebElement customerstab;
	
	@FindBy(xpath="//ul[@class='links']/li")  //list of webelements
	List<WebElement> alltabs;
	
	public WebElement validateRole()
	{
		return role;
	}
	public WebElement customertab()
	{
		return customerstab;
	}
	
	public List<WebElement> Tabs() //pass list of webelmenehts
	{
		return alltabs;
	}
	
	
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
