import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollPage
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		WebElement ele=driver.findElement(By.xpath("//p[contains(text(),'Copyright Â© 2023 - www.irctc.co.in. All Rights')]"));
		String scrol="arguments[0].scrollIntoView()";
		jse.executeScript(scrol,ele);
		
		Thread.sleep(1000);
		String scroll= "document.evaluate(\"//label[text()=' BOOK TICKET ']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.scrollIntoView();";
		jse.executeScript(scroll);
		
	}
}
