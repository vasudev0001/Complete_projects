package assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// find checkbox WebElement
		WebElement checkbox = driver.findElement(By.xpath("//label[@for='bmw']/input"));
		checkbox.click();
		// get selected checkbox label text.
		String selectedCheckbox = driver.findElement(By.xpath("//label[@for='bmw']")).getText().trim();
		// find the dropdown webElement
		WebElement dropdownWebElement = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(dropdownWebElement);
		// select option in dropdown
		dropdown.selectByVisibleText(selectedCheckbox);
		// send selected checkbox option to editbox
		driver.findElement(By.id("name")).sendKeys(selectedCheckbox);
		// click on alert button
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		alert.accept();
		String trimMsg = alertMsg.split(",")[0];
		String selectedOption = trimMsg.split(" ")[1];
		if (selectedOption.equals(selectedCheckbox))
			System.out.println("Alert displayed selected opton: "+selectedOption);
		else
			System.out.println("Alert does not display selected option");

	}

}
