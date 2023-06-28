package popups;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class POP_ups {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		HashMap<String, Integer> contentSetting = new HashMap<String, Integer>();
		HashMap<String,Object> profile = new HashMap<String,Object>();
		HashMap<String,Object> pref = new HashMap<String,Object>();
		
		contentSetting.put("media_stream", 1);
		profile.put("managed_default_content_settings",contentSetting);
		pref.put("profile", profile);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", pref);
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get(" https://mictests.com/"); //https://www.cleartrip.com/  https://mictests.com/
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
	}
}
