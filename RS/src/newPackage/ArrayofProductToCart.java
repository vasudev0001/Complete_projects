package newPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArrayofProductToCart {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		String addProduct[] = {"Capsicum", "Potato", "Carrot", "Tomato", "Beans", "Capsicum"};

		List<WebElement> prouctlist = driver
				.findElements(By.xpath("//div[@class='product']/h4[@class='product-name']"));
		System.out.println(prouctlist.size());

		String[] formatProductName = null;
		for (int j = 0; j < addProduct.length; j++) {
			
			for (int i = 0; i < prouctlist.size(); i++) {
				formatProductName = prouctlist.get(i).getText().split("-");
				String s = formatProductName[0].trim();
				if (addProduct[j].equalsIgnoreCase(s)) {
					System.out.println(s);
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//	driver.findElement(By.xpath("//h4[contains(text(),'" + s + "')]/..//button")).click();
					i=0;
					break;
				}
			}
			
		}

	}
}
