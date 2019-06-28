package bac_pack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CustomersPage;
import pageObjects.HomePage;
import resources.Base;

public class Common_Functionalities extends Base {
	
	 public static Logger log = LogManager.getLogger(Common_Functionalities.class.getName());
	 public Login_Functionality lr=new Login_Functionality();
	 Login_Functionality lf=new Login_Functionality();
	 	SoftAssert as=new SoftAssert();		
	 @Test
	 public void search() throws IOException, InterruptedException
	 {
		 driver=lf.Login_SuperAdminvalidation();
		 HomePage hp=new HomePage(driver);
		 CustomersPage cp=new CustomersPage(driver);
	
		 int count=hp.Tabs().size();
		for(int i=1;i<count-1;i++)
		{
			if (i==3)continue;
			clickAllPagesTitle(i);
				 
			cp.search().sendKeys("122222222222",Keys.ENTER);	
			
			//cp.search().sendKeys(cp.Searchedword().getText(),Keys.ENTER);	
			//Assert.assertEquals(cp.Searchedword().getText() ,cp.search().getAttribute("value"));
			System.out.println(cp.Searchedword().getText());
			as.assertEquals(cp.Searchedword().getText() ,cp.search().getAttribute("value"));
			log.info(hp.Tabs().get(i).getText()+" "+"Module  validated Search functionality");
			as.assertAll();
					
		}
		}
	
	 public void clickAllPagesTitle(int i)
	 {
	//title verify		
		 HomePage hp=new HomePage(driver);
		 hp.Tabs().get(i).click();
		 Assert.assertEquals(hp.Tabs().get(i).getText(),data[i]);
		 //System.out.println("title verified"+hp.Tabs().get(i).getText());
	 } 
		
		
		/* search seperate method
	 tabclick=>title verify separate method
			 testng soft assert
			 assertion=>after checking how to print the no data available msg through assertion
			 1215-uma
			 150-leela
			 200-150=50-chandra
			 70-water
*/
		

}
