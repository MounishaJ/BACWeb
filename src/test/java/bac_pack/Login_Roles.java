package bac_pack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.Home;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class Login_Roles extends Base {

	//LoginPage lp=new LoginPage(driver);
	
	 public static Logger log = LogManager.getLogger(Login_Roles.class.getName());
	
	@Test(priority = 1, dataProvider = "getData1")
	public void loginvalidation(String Username,String Password,String text) throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("Url"));
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		lp.EmailId().sendKeys(Username);
		System.out.println(Username);
		
		
		lp.Password().sendKeys(Password);
		System.out.println(Password);
		
	
		lp.btnSubmit().click();
		//Thread.sleep(3000);
		//System.out.println(hp.validateRole().getText());
		Assert.assertEquals(hp.validateRole().getText(), text);
		System.out.println(hp.validateRole().getText());
	}
	
	@Test(priority = 2)
	public void Login_Tagwritervalidation() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("Url"));
		LoginPage lp=new LoginPage(driver);
		lp.EmailId().sendKeys(prop.getProperty("Tag_Email"));
		
		lp.Password().sendKeys(prop.getProperty("Password"));
		lp.btnSubmit().click();
		Assert.assertEquals(lp.Errorvali().getText(), "You are not authorized to access this web page. Contact administrator.");
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}



@DataProvider
public Object[][] getData1()
{
	
	Object[][] data=new Object[2][3];
	
	data[0][0]="mjeela+3@compindia.com";
	data[0][1]="test123@";
	data[0][2]="Admin";
	
	data[1][0]="mjeela@compindia.com";
	data[1][1]="test123@";
	data[1][2]="Super Admin";
	
	return data;
	
}

}
//Super Admin