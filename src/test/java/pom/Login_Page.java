package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	WebDriver d;

	@FindBy(name = "uid")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement userpass;
	
	@FindBy(name = "btnLogin")
	WebElement button;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logout;
	
	public Login_Page(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	public void enter_username(String name) {
		username.sendKeys(name);
	}
	
	public void enter_userpass(String pass) {
		userpass.sendKeys(pass);
	}
	
	public void click_Login_Buttton() {
		button.click();
	}

	public void log_out() {
		logout.click();
	}
}




