package genericMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {


	// drop-down selection
	public static Select dropdown(WebDriver driver, By locator) {
		WebElement ele = driver.findElement(locator);
		Select select = new Select(ele);
		return select;
	}

	public void doSelectByVisibleText(WebDriver driver, By locator1, String text) {
		dropdown(driver, locator1).selectByVisibleText(text);
	}

	public void doSelectByValue(WebDriver driver, By locator1, String value) {
		dropdown(driver, locator1).selectByValue(value);
	}

	public void doSelectByIndex(WebDriver driver, By locator1, int index) {
		dropdown(driver, locator1).selectByIndex(index);
	}

	// -----------------------------------------
	// Dropdrown selection
	public void dropdownSelection(WebDriver driver, By locator, String selection_type, String select_option) {
		Select act = new Select(driver.findElement(locator));
		switch (selection_type) {
		case "index":
			act.selectByIndex(Integer.parseInt(select_option));
			break;
		case "visible_text":
			act.selectByVisibleText(select_option);
			break;
		case "value":
			act.selectByValue(select_option); 
			break;
		default:
			System.out.println("Invalid selection. Select any one from: index,visible_text,value");
			break;
		}
	}

//------------------------------------------------
	// verify dropdown options are sorted
	public String[][] dropdownSort(WebDriver driver, By locator, String exclude) {
		Select act = new Select(driver.findElement(locator));
		List<WebElement> options = act.getOptions();
		ArrayList<String> origionallist = new ArrayList<>();
		ArrayList<String> templist = new ArrayList<>();

		for (int i = 0; i < options.size(); i++) {
			String a = options.get(i).getAttribute("value");
			if (!a.equals(exclude)) {
				String opt = options.get(i).getText();
				origionallist.add(opt);
				templist.add(opt);
			}
		}
		String[][] dropddownlist = new String[3][origionallist.size()];
		for (int i = 0; i < origionallist.size(); i++) {
			dropddownlist[0][i] = origionallist.get(i); // store list of dropown options.
		}
		Collections.sort(templist);
		for (int i = 0; i < origionallist.size(); i++) {
			String unsorted = origionallist.get(i);
			String sorted = templist.get(i);
			dropddownlist[1][i] = sorted;

			if (unsorted.equals(sorted)) {
				String a = "sorted: " + unsorted;
				dropddownlist[2][i] = a;
			} else {
				String b = "unsorted: " + unsorted;
				dropddownlist[2][i] = b;
			}
		}
		return dropddownlist;
	}
}