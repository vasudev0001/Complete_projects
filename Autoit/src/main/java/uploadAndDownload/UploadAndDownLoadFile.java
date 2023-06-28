package uploadAndDownload;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadAndDownLoadFile {
	WebDriver driver;

	@Test
	public void file() {
		WebDriverManager.chromedriver().setup();
		String path=System.getProperty("user.dir");
		HashMap<String,Object> chromePrefs= new HashMap<String,Object>();
		chromePrefs.put("profile.default_content_settings.poups",0);
		chromePrefs.put("download.default_directory",path);
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.findElement(By.cssSelector("a[id='pickfiles']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// C:\\Users\\91766\\eclipse-workspace\\Autoit\\src\\main\\resources\\upload.exe
		try {
			String []ary={"C:\\Users\\91766\\eclipse-workspace\\Autoit\\src\\main\\resources\\new.exe"};
			Runtime.getRuntime().exec(ary);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(6),Duration.ofMillis(250));
		wait.until(d->d.findElement(By.cssSelector("button[id='processTask']")).isDisplayed());
		driver.findElement(By.cssSelector("button[id='processTask']")).click();
		wait.until(d->d.findElement(By.cssSelector("a[id='pickfiles']")).isDisplayed());
		driver.findElement(By.cssSelector("a[id='pickfiles']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		File f= new File("C:\\Users\\91766\\eclipse-workspace\\Autoit\\execute maven test from cmd.pdf");
		if(f.exists()) {
			System.out.println("file downloaded");
		}
	}
}
