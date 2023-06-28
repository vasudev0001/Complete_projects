package baseTestEcommerce;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import JavaWithSelenium.FrameworkDesign.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public  WebDriver driver;
	public LoginPage ln;
	public Properties prop;

	public void initilizeBrowser() throws IOException {
		Properties prop = new Properties();
		String projectPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(projectPath + "\\globalData\\globalData.properties");
		prop.load(fis);
		String browser = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplcation() throws IOException {
		initilizeBrowser();
		driver.manage().window().maximize();
		System.out.println("browser maximized");
		driver.get("https://rahulshettyacademy.com/client");
		ln = new LoginPage(driver);
		return ln;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApplication() {
		driver.quit();
	}
	
	public List<HashMap<String, String>> getJsonData() throws JsonMappingException, JsonProcessingException {
		String path = System.getProperty("user.dir");
		File file = new File(path + "\\src\\test\\java\\dataReadUtility\\data.json");
		String jsonContent=null;
		try {
			jsonContent = FileUtils.readFileToString(file,StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectMapper om= new ObjectMapper();
		List<HashMap<String, String>> map= om.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
		});
		return map;
	}
	
	public String takeScreenShot(String testMethod,WebDriver driver) throws IOException {
		TakesScreenshot ss= (TakesScreenshot)driver;
		File file=ss.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\reports\\"+testMethod+".png";
		File savePath= new File(path);
		FileUtils.copyFile(file,savePath);
		return path;
	}
}
