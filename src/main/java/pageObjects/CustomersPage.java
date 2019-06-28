package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class CustomersPage extends Base
{
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchfield;
	
	
	
	@FindBy(xpath="//tr[@class='odd']//td[2]")
	WebElement searchword;

	
      

   

	public WebElement search()
	{
		
		return searchfield;
	}
	//public WebElement Searchedlist()
	//{
	//	return searchedrow;
	//}
	public WebElement Searchedword()
	{
		return searchword;
	}
	
	
	
	
	
	
	public CustomersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
