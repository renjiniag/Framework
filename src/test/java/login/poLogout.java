package login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtilities;
import utilities.TestBase;

public class poLogout extends TestBase{
	
	WebDriver driver;
	
	@FindBy(id="idcard-identity")
	WebElement user;
	public poLogout(WebDriver driver) throws IOException {
		super();
		this.driver=BrowserUtilities.driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getUsername() {
		return getTextValue(user);
	}

}
