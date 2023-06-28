package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageNation {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// table WebElement
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered']"));
		// get header Index
		int headerIndex = getHeaderIndex(table, "Veg/fruit name");
		// button WebElement
		WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));
		// if item is not vailable in page then check in next page.
		pageNation(table, nextButton, headerIndex,"Guava");
	}

	// get header index by using header name
	private static int getHeaderIndex(WebElement table, String headerName) {

		// capture table headers
		List<WebElement> tableHeaders = table.findElements(By.xpath(".//th"));
		// header index
		int headerIndex = 1;
		// Iterate table headers
		for (WebElement header : tableHeaders) {
			// fetch text from webElement and compare text with required text
			// if it match break the loop
			boolean b = header.getText().contains(headerName);
			// if element is found then contain method return true.
			if (b == true)
				break;
			// In each iteration increment index.
			headerIndex++;
		}
		// if header index is greater than header size then confirm that required header is not found.
		if (headerIndex > tableHeaders.size())
			System.out.println("Search index not found: " + headerName);
	// return header index
		return headerIndex;
	}

	private static void pageNation(WebElement table, WebElement button, int headerIndex,String item ) throws InterruptedException {
		boolean flag = false;
		List<String> filterItem;
		do {
			List<WebElement> rows = table.findElements(By.xpath(".//tbody//tr/td[" + headerIndex + "]"));
			rows.forEach(s->System.out.println(s.getText()));
			System.out.println(rows.size());
			Thread.sleep(1000);
			filterItem = rows.stream().filter(s -> s.getText().contains("+item+")).map(r->r.getText()).collect(Collectors.toList());
			System.out.println(filterItem.size());
			    String buttonStatus=  button.getAttribute("aria-disabled");
			    if(buttonStatus.equals("false")) {
			    	System.out.println("if block");
			    	flag=false;
			    }else
			    	flag=true;
			    boolean flag1=false;
			    System.out.println(buttonStatus);
			if ((filterItem.size() < 1) && (flag==flag1)){
				button.click();
			}
		} while (filterItem.size() < 1 && (flag==false));
		filterItem.forEach(s->System.out.println("-->"+s));
	}
}
