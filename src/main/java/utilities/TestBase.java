package utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import listener.ExtentReport;

@Listeners(listener.TestListener.class)

public class TestBase {
	public static ExtentTest logger;
	public static WebDriver driver=BrowserUtilities.driver;
	public static Logger log4jLogger= Logger.getLogger(TestBase.class);
	public static BrowserUtilities browserUtil=new BrowserUtilities();
	public static CommonUtilities comUtil= new CommonUtilities();
	public static ExtentReport  reportObj;
	public static ExtentTest reportlogger;
	public static ExtentReports reports;
		
	
	@BeforeSuite
	public void start() throws IOException {
		comUtil.setPath();
		browserUtil.launchBroswer("ch");
		driver=browserUtil.driver;
		log4jLogger.debug("Started");
	}
	@AfterSuite
	public void teardown() {	
		browserUtil.quitBrowser();
		log4jLogger.debug("Finished");	
		
	}
	//Getting WebElement Text
		public String getTextValue(WebElement arg0) {
			if(arg0.isDisplayed()==true) {
				logger.log(LogStatus.PASS, arg0.getText()+" Displayed");
				return arg0.getText();
			}
			else {
				logger.log(LogStatus.FAIL, "Not Displayed");
				return null;
			}
		}
		//SendKeys to WebElement
		public void senText(WebElement textBox,String input,String textbox_name) {
			if(textBox.isDisplayed()==true) {
				if(textBox.isEnabled()==true) {
					textBox.clear();
					textBox.sendKeys(input);
					if(textBox.getAttribute("value").equals(input)) {
						logger.log(LogStatus.PASS,input+" "+textbox_name );
					}
					else {
						logger.log(LogStatus.FAIL,input+" "+textbox_name);
					}
				}
				else
					logger.log(LogStatus.FAIL,textbox_name+" not enabled");
			}
			else
				logger.log(LogStatus.FAIL,textbox_name+" not displayed");
		}
		
	//Click WebElement
		public void clickButton(WebElement button,String buttonName) {
			if(button.isDisplayed()==true) {
				if(button.isEnabled()==true) {
					button.click();
					logger.log(LogStatus.PASS, buttonName+" clicked");
				}
				else {
					logger.log(LogStatus.FAIL, buttonName+" not enabled" );
				}
			}
			else {
				logger.log(LogStatus.FAIL, buttonName+" not displayed" );
			}
		}
}
