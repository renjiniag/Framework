package listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ExtentReport {

	public ExtentReports reports;	
	

	public ExtentReport() {
		String date=new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		String sPath=System.getProperty("user.dir")+"//ExtentReport//Sample_"+date+".html";
		reports=new ExtentReports(sPath);
	}
}