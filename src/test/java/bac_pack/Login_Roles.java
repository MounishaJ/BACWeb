package bac_pack;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class Login_Roles extends Base {

	//LoginPage lp=new LoginPage(driver);
	
	@BeforeClass
	public void launchDriver() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	
	@Test(dataProvider = "getData")
	public void loginvalidation(String Username,String Password,String text) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("Url"));
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		lp.EmailId().sendKeys(Username);
		System.out.println(Username);
		
		
		lp.Password().sendKeys(Password);
		System.out.println(Password);
		
	
		lp.btnSubmit().click();
		//Thread.sleep(3000);
		System.out.println(hp.validateRole().getText());
		Assert.assertEquals(hp.validateRole().getText(), text);
		//System.out.println(text);
	}
	
	@AfterClass
	public void closeDriver()
	{
		driver.close();
		driver=null;
	}


@DataProvider
public Object[][] getData()
{
	
	Object[][] data=new Object[2][3];
	
	/*data[0][0]="mjeela+11@compindia.com";
	data[0][1]="test123@";
	data[0][2]="TagWriter Role";
	*/
	data[0][0]="mjeela+3@compindia.com";
	data[0][1]="test123@";
	data[0][2]="Admin";
	
	data[1][0]="mjeela@compindia.com";
	data[1][1]="test123@";
	data[1][2]="SuperAdmin";

	return data;
}


}
//Super Admin