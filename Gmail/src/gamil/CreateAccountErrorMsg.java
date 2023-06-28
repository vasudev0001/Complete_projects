package gamil;

import static org.testng.Assert.assertEquals;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CreateAccountErrorMsg {
	static int p=0;
	WebDriver driver;
	@Test(dataProvider = "testdata",dataProviderClass = Datasupplier.class)
	public void nextbutton(String fn, String ln, String email, String pw) {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://accounts.google.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// explicit wait
		//span[@class='VfPpkd-vQzf8d' and text()='Create account']
		wait.until((wd) -> wd.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d' and text()='Create account']")).isEnabled());
		// finding create account link element
		WebElement b = driver.findElement(By.xpath("//span[text()='Create account']"));
		// check element is displayed
		boolean bb = b.isDisplayed();

		Reporter.log("Link status: " + bb, true);
		// click on create account webElement
		driver.findElement(By.xpath("//span[text()='Create account']")).click();
		// explicit wait
		wait.until((d) -> d.findElement(By.xpath("//span[text()='For my personal use']")).isEnabled()); 
		// click on my self option
		driver.findElement(By.xpath("//span[text()='For my personal use']")).click();   //span[text()='For myself']
		driver.findElement(By.id("firstName")).sendKeys(fn); 
		driver.findElement(By.id("lastName")).sendKeys(ln);
		driver.findElement(By.id("username")).sendKeys(email);
		p++;
		System.out.println(p);
		for(int i=1;i<3;i++)
		{
			driver.findElement(By.xpath("(//input[@type='password'])[" + i + "]")).sendKeys(pw);
			if(p==4)
			{
				break;
			}
				
		} 
		
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();

		String[] data = errmsg();

		List<WebElement> list = driver.findElements(By.xpath("//div[@jsname='B34EJ']"));
		for (int a = 0; a < list.size(); a++) {
			String errText = list.get(a).getText();
			
			//  This for loop is used to iterate array having list of error messages. 
			for (int j = 0; j < data.length; j++)
			{
				String errt = data[j];
				// It compares the Text-box error messages and it allows only to validate error message that are matched.
				if (errt.equalsIgnoreCase(errText))
				{
					//Reporter.log("error message: " + errText, true);
					assertEquals(errText, errt,errText+" is not matched with "+errt); 
				}
			}
			if((!errText.isEmpty())) 
			{
				Reporter.log("error message: " + errText, true);
				Reporter.log("It display correct error message", true);
				}
		     }
	      }

	private String[] errmsg() {
		String[] data = { "Enter first name and surname", "Choose a Gmail address", "Enter a password",
				"Use 8 characters or more for your password", "Enter last name", "Enter first name","Confirm your password" };
		
		return data;
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
