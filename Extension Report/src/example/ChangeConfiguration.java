package example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
//import com.aventstack.extentreports.reporter.configuration.Theme;

public class ChangeConfiguration 
{
	public static void main(String[] args) throws IOException
	{
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter sr = new ExtentSparkReporter("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\reporters.html");
		sr.loadJSONConfig(new File("./Extent-reporter-config.json"));
		// C:\\Users\\91766\\eclipse-workspace\\Extension Report\\Extent-reporter-config.json
		er.attachReporter(sr);
		
//		sr.config().setTheme(Theme.DARK);
//		sr.config().setReportName("Reporter: vasudev");
//		sr.config().setDocumentTitle("OrangeHRM verify menu");
//		sr.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
//		sr.config().setCss(".badge-primary {background-color:#020afc;}");
//		sr.config().setCss(".pass-bg, .avatar.pass {background-color:#2b31d0;}");
//		sr.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
//		ExtentSparkReporterConfig config = sr.config();
//		config.setTheme(Theme.DARK);
//		config.setReportName("Reporter: vasudev");
//		config.setDocumentTitle("OrangeHRM verify menu");
//		config.setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
//		config.setCss(".badge-primary {background-color:#020afc;}");
//		config.setCss(".pass-bg, .avatar.pass {background-color:#2b31d0;}");
//		config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
		er.createTest("OrangeHRM verify menu 1")
		  .assignAuthor("vasudev")
		  .assignCategory("smoke","sanity","regression")
		  .assignDevice("chrome","firefox","edge")
		  .log(Status.PASS,"This is pass");
		
		er.createTest("OrangeHRM verify menu 2")
		  .assignAuthor("vasudev","yadagiri")
		  .assignCategory("smoke","sanity","regression")
		  .assignDevice("chrome","firefox","edge")
		  .log(Status.PASS,"This is pass");
		
		er.createTest("OrangeHRM verify menu 3")
		  .assignAuthor(new String[]{"vasudev","yadagiri","Testing babai"})
		  .assignCategory(new String[]{"smoke","sanity","regression"})
		  .assignDevice(new String[]{"chrome","firefox","edge","smoke fox"})
		  .log(Status.PASS,"This is pass");
		
		er.flush();
		Desktop.getDesktop().browse(new File("reporters.html").toURI());
	}

}
