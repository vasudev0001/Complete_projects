package links;
import java.awt.AWTException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyLinks {
	
	static WebDriver driver;
	public static void main(String[] args) throws AWTException, InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");  //  https://file-examples.com/  https://www.hyrtutorials.com/
	//	System.out.println(driver.getTitle());
	//	Thread.sleep(4000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.titleContains("H Y R Tutorials - H Y R Tutorials"));
		List<WebElement> a =driver.findElements(By.tagName("a"));
		int elementsize = a.size();
		System.out.println("Total number of links:"+elementsize);
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for(int i=0;i<elementsize;i++)
		{
			try {
			String link1 = a.get(i).getAttribute("href");
			if(link1!=null)
			{
				activelinks.add(a.get(i));
			}
			}catch (Exception e) {
				e.getStackTrace();
				System.out.println("Exception link->active link");
			}
		}
		System.out.println("Active links: "+activelinks.size());
		
		int j=0;
		for(;j<activelinks.size();j++)
		{
			
			try {
				HttpURLConnection connection =(HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
				connection.setConnectTimeout(5000); 
				connection.connect();
				String response = connection.getResponseMessage();
				int code =connection.getResponseCode();
				String link =activelinks.get(j).getAttribute("href");
				 if(code==200)
				 {
					 System.out.println(link+": "+response); // activelinks.get(j).getAttribute("href")+": "+
				 }
				 else {
					 System.err.println(link+": "+code);
				 }
				connection.disconnect();
			}catch(Exception e)
			{
				e.getStackTrace();
				System.out.println("Exception raised");
				System.out.println("No of links: "+j);
			}	
     	}
		if(activelinks.size()==j)
		{
			System.out.println(j);
		}
		driver.quit();
	}
}
