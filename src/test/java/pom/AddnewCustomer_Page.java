package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddnewCustomer_Page {
	WebDriver d;

	public AddnewCustomer_Page(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement newcustomer_link;

	@FindBy(name = "name")
	WebElement username;
	
	@FindBy(id = "dob")
	WebElement dob;	
	
	@FindBy(name = "addr")
	WebElement address;
	
	@FindBy(name = "city")
	WebElement city;
	
	@FindBy(name = "state")
	WebElement state;
	
	@FindBy(name = "pinno")
	WebElement pin;
	
	@FindBy(name = "telephoneno")
	WebElement mob;
	
	@FindBy(name = "emailid")
	WebElement email;
	
	@FindBy(name = "sub")
	WebElement sub_button;

	public void click_on_newcustomer_link() {
		newcustomer_link.click();
	}
	public void enter_name(String uname) {
		username.sendKeys(uname);
	}	
	public void dob(String dd, String mm, String yyyy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}	
	public void adress(String adr) {
		address.sendKeys(adr);
	}
	public void city(String c) {
		city.sendKeys(c);
	}
	public void state(String s) {
		state.sendKeys(s);
	}	
	public void pin(String p) {
		pin.sendKeys(p);
	}	
	public void mob(String m) {
		mob.sendKeys(m);
	}	
	public void email(String e) {
		email.sendKeys(e);
	}
	public void submit_button() {
		sub_button.click();
	}
}
