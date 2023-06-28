package genericMethods;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuControl {
	static By menuList = By.xpath("//div[@id='top-menu']/ul/li"); // main menu.
	static By menuOptionList = By.xpath("./ul/li/a/span"); // menu option list.
	static By dropMenu = By.xpath("./a/following-sibling::ul"); // Identify the drop menu.
	static By SubMenuOptionList = By.xpath("./../../ul/li/a/span"); // sub menu options.
	static By menuOptionContainsSubmenu = By.xpath("./../following-sibling::ul");

	By adminMenu = By.id("admin");

	public static Actions actions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	// mouse hover on main menu.
	public static WebElement mouseHoverOnMenu(WebDriver driver, String menuOption) {
		Actions act = actions(driver);
		List<WebElement> menuListopt = driver.findElements(menuList);
		WebElement menu = null;
		for (WebElement opt : menuListopt) {
			boolean status = opt.getText().equalsIgnoreCase(menuOption);
			if (status == true) {
				try {
					menu = opt;
					boolean b = opt.findElement(dropMenu).getTagName().contains("ul");
					System.out.println("It is drop menu: " + b);
					act.moveToElement(opt).perform();
					break;
				} catch (Exception e) {
					try {
						opt.click();
						break;
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		}
		return menu;
	}

	// Get menu option list.
	public static List<WebElement> getOptionsList(WebDriver driver, WebElement MenuElement) {
		return MenuElement.findElements(menuOptionList);
	}

	// mouse hover on menu option
	public static WebElement mouseHoverOnMenuOption(WebDriver driver, List<WebElement> subMenu, String menuOption) {
		List<WebElement> list = subMenu;
		WebElement menuOpt = null;
		for (WebElement ele : list) {
			boolean status = ele.getText().equalsIgnoreCase(menuOption);

			if (status == true) {
				menuOpt = ele;
				String elementText = ele.getText();
				try {
					ele.findElement(menuOptionContainsSubmenu).getTagName().contains("ul");
					actions(driver).moveToElement(ele).perform();
					System.out.println("mouse hover on :" + elementText);
					break;
				} catch (Exception e) {
					ele.click();
					System.out.println("clicked on option:" + elementText);
					break;
				}
			}
		}
		return menuOpt;
	}

	// click on sub menu option.
	public static void clickOnSubMenu(WebElement menuOpt, By subMenuLocator, String submenuOpt) {
		List<WebElement> subMenuList = menuOpt.findElements(subMenuLocator);
		for (WebElement subMenuOpt : subMenuList) {
			boolean status = subMenuOpt.getText().equalsIgnoreCase(submenuOpt);
			if (status == true) {
				String subMenuName = subMenuOpt.getText();
				subMenuOpt.click();
				System.out.println("Clicked on submenu option: " + subMenuName);
				break;
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys("Hello");
		driver.findElement(By.name("txtPassword")).sendKeys("Dreams");
		driver.findElement(By.name("Submit")).click();

		String menu = "Leave";
		String menuOption = "Define days off";
		String subMenuOpt = "specific holidays";
		WebElement menuElement = mouseHoverOnMenu(driver, menu);
		System.out.println("Mouse hover on menu: " + menu);
		List<WebElement> list = getOptionsList(driver, menuElement);
		WebElement menuOpt = mouseHoverOnMenuOption(driver, list, menuOption);
		clickOnSubMenu(menuOpt, SubMenuOptionList, subMenuOpt);
	}
}
