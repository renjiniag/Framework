package home;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtilities;
import utilities.TestBase;

public class poHome extends TestBase{

	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	@FindBy(id="userNavButton")
	WebElement loginName;
	@FindBy(id="idcard-identity")
	WebElement username;
	@FindBy(id="userNavButton")
	WebElement userNavButton;
	
	public poHome(WebDriver driver) throws IOException {
		super();
		this.driver=BrowserUtilities.driver;
		PageFactory.initElements(driver, this);
	}
	public void clickUserNav() {
		clickButton(userNavButton,"UserNavButton");
	}
	
	public void clickLogout() {
		clickButton(logout,"Logout");
	}
}
