package login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import utilities.BrowserUtilities;
import utilities.TestBase;

public class poLogin extends TestBase{
	
	WebDriver driver;

	@FindBy(id="username")
	WebElement uName;
	@FindBy(id="password")
	WebElement uPassword;
	@FindBy(id="Login")
	WebElement uLogin;
	@FindBy(id="error")
	WebElement loginError;
	@FindBy(id="rememberUn")
	WebElement rememberMe;
	
	public poLogin(WebDriver driver) throws IOException {
		super();
		this.driver=BrowserUtilities.driver;
		PageFactory.initElements(driver, this);
	}
	
	//Set Username
	public void setUsername(String strUserName) {
		senText(uName,strUserName ,"UserName");
	}
	
	//set Password
	public void setPassword(String strPassword) {
		senText(uPassword,strPassword ,"Password");
	}
	
	//ClickLogin
	public void clickLogin() {
		clickButton(uLogin, "Login");
}
	
	//GetErrorMessage
	public String getErrorMessage() {
		return getTextValue(loginError);
	}
	
	//click RememberMe
	
	public void clickRememberMe() {
		clickButton(rememberMe,"Remember Me Button");
	
	}
	
	
}