package testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pom.Login_Page;
import utiles.Read_loginXL_Data;

public class Login_with_Xl_Data_002 extends BaseClass {

	@Test(dataProviderClass=Read_loginXL_Data.class, dataProvider="dynamic")
	public void using_dynamic_data(String username, String password) {

		Login_Page Lp = new Login_Page(d);
		Lp.enter_username(username);
		Lp.enter_userpass(password);
		Lp.click_Login_Buttton();

		if(alert()==true) {
			d.switchTo().alert().accept();
			Assert.assertTrue(false);
			d.switchTo().defaultContent();
			
			
		}else {
			Lp.log_out();
			d.switchTo().alert().accept();
			d.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
	}

	public boolean alert() {
		try {
			d.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
