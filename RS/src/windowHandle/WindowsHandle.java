package windowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		driver.findElement(By.xpath("//div[@class='example']/a[text()='Click Here']")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String>it =windows.iterator();
		String parentwindow=it.next();
		String childWindow= it.next();
		driver.switchTo().window(childWindow);
	String childText=	driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
	System.out.println("child Window: "+childText);
	driver.switchTo().window(parentwindow);
	String parentWindowText=	driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
	System.out.println(parentWindowText);
		
	}

}
