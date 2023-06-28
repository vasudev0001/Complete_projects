package newPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FillForm {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// enter name
		driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input")).sendKeys("vasudev");
		// get text using jse
		System.out.println(js.executeScript("return document.getElementsByName('name')[0].value"));
		// get entered text
		System.out.println(
				driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input")).getAttribute("value"));
		// get entered text
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vasudev@13");

		// edit box internal text
		System.out.println(js
				.executeScript("return document.getElementById('exampleInputPassword1').getAttribute('placeholder')"));
		// enter password
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("vasudev&hfehf");
		// get entered password
		System.out.println(
				"   " + driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).getAttribute("value"));
		// get password internal text
		System.out.println(js
				.executeScript("return document.getElementById('exampleInputPassword1').getAttribute('placeholder')"));
		// System.out.println(js.executeScript("return
		// document.getElementById('exampleInputPassword1').value"));

		driver.findElement(By.id("exampleCheck1")).click();
		WebElement dropelement = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(dropelement);
		dropdown.selectByVisibleText("Male");
		System.out.println(js.executeScript("return document.getElementById(\"exampleFormControlSelect1\").value;"));
		String radiobutton = "inlineRadio1";
		driver.findElement(By.xpath("//input[@id='" + radiobutton + "']/following-sibling::label")).click();
		String s = driver.findElement(By.xpath("//input[@id='" + radiobutton + "']/following-sibling::label"))
				.getText();
		System.out.println(s);
		driver.findElement(By.name("bday")).sendKeys("30/11/2022");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		String a = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();// getAttribute("innerText");
		String aa = a.trim();
		System.out.println(aa);
		String aaa = aa.replaceAll("\\s", " ");
		System.out.println(aaa);
		String a4 = aaa.substring(1);
		System.out.println(a4.trim());
		
// ------------------------------------------
		String s1 = " The Form has been submitted successfully!.";
		int s11 = 0;
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (c == ' ') {
				s11++;
			}
		}
		System.out.println("-->" + s11);
//		String []b=aaa.split(" ");

//		String sv="";
//		String sv1="";
//        for(int i=1;i<b.length;i++) {
//		sv =" "+ b[i];
//		sv1=sv1.concat(sv);
//		System.out.println("-->"+sv1);
//        }
//        System.out.println(sv1);
	}
}
