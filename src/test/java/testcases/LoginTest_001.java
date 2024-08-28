package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pom.Login_Page;

public class LoginTest_001 extends BaseClass {

	@Test
	public void using_static_data() {

		Login_Page Lp = new Login_Page(d);
		Lp.enter_username(username);
		Lp.enter_userpass(userpass);
		Lp.click_Login_Buttton();
	}

}
