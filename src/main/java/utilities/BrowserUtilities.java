package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities {
	
	public static WebDriver driver=null;
	
	public  void launchBroswer(String browser) {
		if(browser.startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.startsWith("ed")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();			
		}
		else {
			System.out.println("Wrong Browser Selected");
		}
		if(driver!=null) {
			
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
	}
	
	public  void quitBrowser() {
		driver.quit();
	}

}
