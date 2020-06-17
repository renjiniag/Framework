package login;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import home.poHome;
import junit.framework.Assert;
import utilities.TestBase;

public class Testcase_login extends TestBase{

	poLogin loginPage;
	poHome homePage;
	poLogout logoutPage;

	@BeforeMethod
	public void startTest() throws IOException {
	
		driver.get(comUtil.getPropertyValue("url"));
		loginPage=new poLogin(driver);
		
		
	}
	
	@AfterMethod
	public void endTest() {
		driver.get(comUtil.getPropertyValue("url"));
	}

	/*
	 * Salesforce application page is displayed 
	 * User Name is displayed in User name
	 * field Password field should be empty
	 *  "error message 'Please enter your * password.' should be displayed"
	 */
	@Test
	public void Testcase1() {
		loginPage.setUsername(comUtil.getPropertyValue("username"));
		loginPage.setPassword("");
		loginPage.clickLogin();
		Assert.assertTrue(loginPage.getErrorMessage().trim() +"Displayed",
				loginPage.getErrorMessage().trim().contains(comUtil.getPropertyValue("loginError")) );
	}
	
	/*
	 * SFDC login page is opened
	 *  Home page should be displayed
	 */

	@Test
	public void Testcase2() throws IOException {	
		
		loginPage.setUsername(comUtil.getPropertyValue("username"));
		loginPage.setPassword(comUtil.getPropertyValue("password"));
		loginPage.clickLogin();
		Assert.assertTrue(driver.getTitle().trim() +" Displayed", driver.getTitle().trim().contains("Home Page"));
	}
	/*
	 *   * Open <https://www.Login.salesforce.com> page in browser
	 * Provide valid <username> in username text field and valid <password> in
	 * password text field and selet the remember user name check box and click on
	 * Login to Slaesforce button Click on user menu drop down and select log out
	 * link UserName <userName> should be displayed
	 */
	@Test
	public void Testcase3() throws IOException {
		loginPage.setUsername(comUtil.getPropertyValue("username"));
		loginPage.setPassword(comUtil.getPropertyValue("password"));
		loginPage.clickRememberMe();
		loginPage.clickLogin();
		Assert.assertTrue(driver.getTitle().trim() +" Displayed", driver.getTitle().trim().contains("Home Page"));
		homePage=new poHome(driver);
		homePage.clickUserNav();
		homePage.clickLogout();
		logoutPage=new poLogout(driver);
		Assert.assertTrue(logoutPage.getUsername()+ " Displayed",logoutPage.getUsername().trim().
				equalsIgnoreCase(comUtil.getPropertyValue("username")));
		
	}


}
