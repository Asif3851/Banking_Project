package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pom.AddnewCustomer_Page;
import pom.Login_Page;

public class Add_new_Customer_003 extends BaseClass {

	@Test
	public void addnewCustomer() throws InterruptedException {
		Login_Page lp = new Login_Page(d);
		lp.enter_username(username);
		lp.enter_userpass(userpass);
		lp.click_Login_Buttton();
		AddnewCustomer_Page customer = new AddnewCustomer_Page(d);
		customer.click_on_newcustomer_link();
		Thread.sleep(2000);
		customer.enter_name("Anna");
		customer.dob("30", "4", "2000");
		customer.adress("Noida Sec-62");
		customer.city("Noida");
		customer.state("UP");
		customer.pin("2003001");
		customer.mob("6852453257");
		customer.email("anna@gmail.com");
		customer.submit_button();
		
	}
}
