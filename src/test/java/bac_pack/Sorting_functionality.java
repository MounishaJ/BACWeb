package bac_pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CustomersPage;
import resources.Base;

public class Sorting_functionality extends Base {
	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F://Web Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://projects.appdevelopment.com/bac_qa_43298787/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("mjeela@compindia.com");
		driver.findElement(By.id("password")).sendKeys("test123@");
		driver.findElement(By.id("login_submit")).click();

		Thread.sleep(5000);
		CustomersPage p = new CustomersPage(driver);
		p.customer_Tab().click();

		Assert.assertEquals(p.customer_Tab().getText(), "Customers");
	}
	
	
	@Test
	public void getlist() throws InterruptedException
	{
//created empty lists		
		List<String> originaldesc=new ArrayList<String>();
		List<String> descending=new ArrayList<String>();
//prints columns count		
		int columncount=driver.findElements(By.xpath("//thead/tr/th")).size();
		System.out.println(columncount);   
		for(int i=0;i<columncount;i++)
		{
			
		System.out.println("getattribute"+i+" "+driver.findElements(By.xpath("//thead/tr/th")).get(i).getAttribute("class"));
		String name=driver.findElements(By.xpath("//thead/tr/th")).get(i).getAttribute("class");
//checks sorting option is present or not
		if(name.endsWith("sorting"))
		{
			originaldesc=data(i);
			
			Thread.sleep(2000);
			driver.findElements(By.xpath("//thead/tr/th")).get(i).click();   
			Thread.sleep(2000);
			while (true) {
				CustomersPage p = new CustomersPage(driver);
			String name1 = p.Arrow().getAttribute("class");			
			List<WebElement> Rows = driver.findElements(By.xpath("//tr"));
			int size=Rows.size(); //10
			for (int j=1; j<size; j++) //10
			  { //find the columns in specific row
			List<WebElement> Columns = Rows.get(j).findElements(By.xpath("//tr"+"["+ j+"]"+"//td"));
			descending.add(Columns.get(i).getText()); 
			Iterator it = Columns.iterator(); // name is present
			while (it.hasNext()) // next element is present or not
			it.next();
			}			
			scrolldown();
			Thread.sleep(2000);
			if (!name1.contains("disabled")) {
			p.Arrow().click();
			Thread.sleep(2000);
			scrollup();
			} else if (name1.contains("disabled")) {
			break;
			}
			}
			 System.out.println("original list"+originaldesc); 
			Collections.sort(originaldesc, Collections.reverseOrder());
			System.out.println("List After descending order"+originaldesc);
			System.out.println("after sort button clicking get the descending order"+descending);
			Assert.assertTrue(originaldesc.equals(descending));
			System.out.println("successfully checked descnding order sorting");
						
	}
}
}

		
	
	public List<String> data(int i) throws InterruptedException {
		// TODO Auto-generated method stub
		
		List<String> Actual = new ArrayList<String>();
		while (true) {
			CustomersPage p = new CustomersPage(driver);
			String name1 = p.Arrow().getAttribute("class");			
			List<WebElement> Rows = driver.findElements(By.xpath("//tr"));
			int size=Rows.size(); //10
			for (int j=1; j<size; j++) //10
			  { //find the columns in specific row
			List<WebElement> Columns = Rows.get(j).findElements(By.xpath("//tr"+"["+ j+"]"+"//td"));
			Actual.add(Columns.get(i).getText()); 
			Iterator it = Columns.iterator(); // name is present
			while (it.hasNext()) // next element is present or not
			it.next();
			}			
			scrolldown();
			Thread.sleep(2000);
			if (!name1.contains("disabled")) {
			p.Arrow().click();
			Thread.sleep(2000);
			scrollup();
			} else if (name1.contains("disabled")) {
			break;
			}
		}
	
	return Actual;
	}
	

}

