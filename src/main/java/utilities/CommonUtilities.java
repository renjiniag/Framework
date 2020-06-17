package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.relevantcodes.extentreports.ExtentTest;


public class CommonUtilities {

	public static ExtentTest logger=TestBase.logger;
	public static Properties prop=new Properties();

	public void setPath() throws IOException {
		String sPath=System.getProperty("user.dir")+"\\src\\main\\java\\properties\\config.properties";
		FileReader reader=new FileReader(sPath);
		prop.load(reader);
	}	

	public String getPropertyValue(String arg0) {
		return prop.getProperty(arg0);
	}

	

}
