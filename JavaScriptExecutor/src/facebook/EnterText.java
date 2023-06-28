package facebook;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnterText
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
//		String un ="username123";
//		String pw="password321";
		double un = 22.32;
		int pw =5648379;
		
		
		// convert webDriver reference into javascriptExecutor
		JavascriptExecutor jse =(JavascriptExecutor) driver;
	
		/*
		 *   finding element using class name. class ='inputtext _55r1 _6luy'
		 *   document.getElementsByClassName('inputtext _55r1 _6luy');
		 *   above method return two elements. At zero index found user name Text-box. at index one found password text-box.
		 *      
		 * for user name Text-box: jse.executeScript("document.getElementsByClassName('inputtext _55r1 _6luy')[0]"); 
		 *                         Zero index is used to access user name Text-box.
		 * for password Text-box: jse.executeScript("document.getElementsByClassName('inputtext _55r1 _6luy')[1]");
		 * 						   one index is used to access password Text-box.
		 * 
		 */
		
		// finding element and entering Text using javascriptExecutor.
		jse.executeScript("document.getElementsByClassName('inputtext _55r1 _6luy')[0].value='"+un+"';"); // un is string type variable and it can store user name.
		// Getting text from the Text-box.
	    String s =(String)	jse.executeScript("return document.getElementsByClassName('inputtext _55r1 _6luy')[0].value");
	    //printing Text
        System.out.println("Get Text from user name Textbox: "+s);
        
             // finding element and entering Text using javascriptExecutor.
     		jse.executeScript("document.getElementsByClassName('inputtext _55r1 _6luy')[1].value='"+pw+"';"); // pw is string type variable and it can store password.
     		// Getting text from the Text-box.
     	    String s1 =(String)	jse.executeScript("return document.getElementsByClassName('inputtext _55r1 _6luy')[1].value");
     	    //printing Text
             System.out.println("Get Text from password Textbox: "+s1);
        
        
	}

}
