package bac_pack;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.Base;

public class Customer_Module extends Base  {

	Common_Functionalities cf=new Common_Functionalities();
	Login_Functionality lf=new Login_Functionality();
	

	public void testSearchfunctionality() throws IOException, InterruptedException
	{
		 driver=lf.Login_SuperAdminvalidation();
		cf.search();

	}
}
