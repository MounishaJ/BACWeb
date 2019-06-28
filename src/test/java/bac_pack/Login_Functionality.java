package bac_pack;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class Login_Functionality extends Base {

	//LoginPage lp=new LoginPage(driver);
	
	
	 public static Logger log = LogManager.getLogger(Login_Functionality.class.getName());
	 
		 	
		//@Test(priority = 1, dataProvider = "getData1")
	public void loginvalidation(String Username,String pwd,String text) throws IOException
	{
		driver= initializeDriver();
		log.info("Driver initialized successfully");	
		//System.out.println(Username+""+pwd+""+text);
		driver.get(prop.getProperty("Url"));
		log.info("successfully launched URL");	
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		lp.EmailId().sendKeys(Username);
		log.info("Entered email address");			
		
		lp.Password().sendKeys(pwd);
		log.info("Entered password");	
		
	
		lp.btnSubmit().click();
		log.info("Hit the login button");	
		
		Assert.assertEquals(hp.validateRole().getText(), text);
		log.info("Successfully validate the Role");	
	}
	
	//@Test(priority = 2)
	public void Login_Tagwritervalidation() throws IOException
	{
		driver=initializeDriver();
		System.out.println("second test url");
		log.info("Successfully launche the url");			
		
		driver.get(prop.getProperty("Url"));
		LoginPage lp=new LoginPage(driver);
		lp.EmailId().sendKeys(prop.getProperty("Tag_Email"));
		System.out.println("second Entered Tag Writer email address ");
		log.info("Entered Tag Writer email address");			
		
		lp.Password().sendKeys(prop.getProperty("Password"));
		log.info("Entered Tag writer Password");			
		
		lp.btnSubmit().click();
		Assert.assertEquals(lp.Errorvali().getText(), "You are not authorized to access this web page. Contact administrator.");
		log.info("Verified error message");			
		
	}
	
	public WebDriver Login_SuperAdminvalidation() throws IOException
	{
		driver= initializeDriver();
		log.info("Driver initialized successfully");	
		driver.get(prop.getProperty("Url"));
		log.info("successfully launched URL");	
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		lp.EmailId().sendKeys(prop.getProperty("SupAdmin_Email"));
		log.info("Entered email address");			
		
		lp.Password().sendKeys(prop.getProperty("Password"));
		log.info("Entered password");	
		
	
		lp.btnSubmit().click();
		log.info("Hit the login button");	
		
		Assert.assertEquals(hp.validateRole().getText(), "Super Admin");
		log.info("Successfully validate the Role");
		return driver;	
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