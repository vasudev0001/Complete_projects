package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomepageSearch;

public class GoogleHomepageTest1 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		HomepageSearch obj = new HomepageSearch(driver);
		obj.searchField("selenium");
		obj.searchButton();
	}
}
