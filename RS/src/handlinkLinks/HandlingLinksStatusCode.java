package handlinkLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class HandlingLinksStatusCode {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		SoftAssert assertion = new SoftAssert();
		List<String> linkStatusCode = getLinkStatusCode(driver);
		System.out.println(linkStatusCode.size());
		
		for(String link:linkStatusCode) {
			String[] link1 = link.split(":");
			int code=Integer.parseInt(link1[1].trim());
			System.out.println(link1[0]+link1[1]);
			assertion.assertTrue(code<400, link1[0]+" less than 400");
		}
		assertion.assertAll();
	}

	private static List<String> getLinkStatusCode(WebDriver driver) {
		List<WebElement> footerLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		List<String> linkcode = new ArrayList<>();
		for (WebElement link : footerLinks) {
			try {
				String linkUrl = link.getAttribute("href");
				HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				connection.getRequestMethod();
				int code = connection.getResponseCode();
				String code1= link.getText() + " link response code: "+String.valueOf(code);
				linkcode.add(code1);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return linkcode;
	}
}
