package autoSuggetion;

import java.time.Duration;
import java.util.List;
//import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart 
{
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
	//	    System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
   //		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String searchData ="Camera in Point and Shoot";	  // 
		String entersearch ="cam";
		
		driver.findElement(By.xpath("//div[@class='_2QfC02']/button")).click();  //click on notification cancel button.
		driver.findElement(By.xpath("//div[@class='_3OO5Xc']/input[@name='q']")).sendKeys(entersearch);
		
       wait.until((driver)->driver.findElement(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']")).isDisplayed()); //Explicit wait
		
//             Function<WebDriver,Boolean> f = new Function<WebDriver,Boolean>()  //Explicit wait
//		     {
//            	 @Override
//	              public Boolean apply(WebDriver webdriver)
//	              {
//	            	  return webdriver.findElement(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']")).isDisplayed();
//	              }
//		    };
//		   
//		   wait.until(f);
		   
		List<WebElement> suggetion=driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']/li//div[@class='lrtEPN _17d0yO']")); //ul[@class='col-12-12 _1MRYA1 _38UFBk']/li//div[@class='lrtEPN _17d0yO']
		
		int size = suggetion.size();
		System.out.println("No of elements: "+size);
		Actions act =new Actions(driver);
		int optionindex =0;
		for(int i=0;i<size;i++)
		{
			WebElement ele = suggetion.get(i);  // ele is Webelement returned from list (List<WebElement> suggetion).
			int a=i+1;
			String optiontxt = ele.getText();
			System.out.println(a+"."+optiontxt);
			
			System.out.println("---------------------------------------------");
		    String opt = optiontxt.replaceAll("\\s"," "); // remove spaces in string
			System.out.println(opt);
			System.out.println("---------------------------------------------");   
			
		/*	if(optiontxt.equalsIgnoreCase(searchData))
			{
				ele.click();
				break;
			} */
			
			if(!opt.equalsIgnoreCase(searchData))
			{
			    act.moveToElement(ele).sendKeys(Keys.ARROW_DOWN).perform();	
			    optionindex++;
			    Thread.sleep(500);
			}
			else
			{
				act.moveToElement(ele).click().perform();
				optionindex++;
				System.out.println(opt+" available at option: "+optionindex);
				break;
			}    
		} 	
	}
}
