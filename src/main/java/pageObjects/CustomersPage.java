package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
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

	
	@FindBy(xpath="//span[contains(text(),'Customers')]")
	WebElement customertab;
	public WebElement customer_Tab()
	{
		
		return customertab;
	}

	@FindBy(css = "span[class^='paginate_button next icon-right-arrow x_small']")
	WebElement arrow;
	public WebElement Arrow()
	{
		return arrow;
	}
	public static void scrolldown()
	{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,350)", "");

	}
	
	public static void scrollup()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView(true);",element);
		
		jse.executeScript("window.scrollBy(0,-300)", "");
	}

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
