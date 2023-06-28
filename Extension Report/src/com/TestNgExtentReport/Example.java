package com.TestNgExtentReport;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;

//import com.TestNgExtentReport.DataSupplier1;

public class Example extends BaseClass {
	
	@Test(dataProvider = "dp1", dataProviderClass=DataSupplier1.class, testName = "test1")
	public void orangeHRMLogin(String key,String un,String pw) throws Exception 
	{	
		driver.findElement(By.name("txtUserName")).sendKeys(un);
		extentTest.info("user name:"+un);
		driver.findElement(By.name("txtPassword")).sendKeys(pw);
		extentTest.info("password:"+pw);
		driver.findElement(By.name("Submit")).click();
		extentTest.info("Test Data: "+key);
		extentTest.info("Click on submit button");
	   
		/*
	     *                                            Negative Login Testing.
	     * user-name and password is not equal to valid credentials then only enter into if block.
	     * if invalid login credentials are provided then it display error message.
	     * Whenever an error message is displayed, make sure that the login failed with the invalid login credentials.
	     * 
	     */
		
		 if(un.equals("") || pw.equals(""))
			{
				Alert a = driver.switchTo().alert();
				String alert_text =a.getText();
				System.out.println("alert: "+alert_text);
				a.accept();
				lnMsg("negative",un,pw);
				System.out.println("Alert message: "+alert_text);
				if(un.equals(""))
				{
					assertEquals(alert_text,"User Name not given!");
					extentTest.pass("Test status: pass");
					Reporter.log("It display correct is error message");
				}
				else if(pw.equals(""))
				{
					assertEquals(alert_text,"Password not given!");
					extentTest.pass("Test status: pass");
					Reporter.log("It display correct Alert message");
				}	 
			}
		else if(!(un.equals("Hello") && pw.equals("Dreams")))
		{
			// invalid login error message 
			WebElement lnerr= driver.findElement(By.xpath("//table/tbody//strong/font[text()='Invalid Login']"));
			// check here message is displayed
			boolean errmesd=lnerr.isDisplayed();
			// validate assertion based on boolean(boolean is from isDisplayed method) 
			assertEquals(errmesd, true);
			// here call lnmsg(display login credentials)
			lnMsg("negative",un,pw);
			// here displayed error message is true or false.
			Reporter.log("Error message is displayed: "+errmesd);
			//get text from the webElement
			String errmes = lnerr.getText();
			// display error message
			Reporter.log("Error message is displayed as: "+errmes);
			//validate the displayed error message is correct or not
			assertEquals(errmes, "Invalid Login");
			extentTest.pass("Test status: pass");
			Reporter.log("It displayed correct message: True");
		}
		else  // positive testing
		{
			 // find welcome text message 
			 String display = driver.findElement(By.xpath("//ul[@id='option-menu']/li[text()='Welcome Hello']")).getText();
			 System.out.println(display); 
			 // validate error message 
			 Assert.assertEquals(display, "Welcome Hello");
			 extentTest.pass("Test status: pass");
			 // here call lnmsg(display login credentials)
			 lnMsg("positive",un,pw);
			 Reporter.log("Login is successful");
		}			
	}
	
	// This method print login credentials along with what kind of testing (positive/negative)
	private void lnMsg(String testing_type,String un,String pw)
	{
	    if(testing_type.equalsIgnoreCase("positive"))
	    {
	    	Reporter.log("***positive testing***");
	    }
	    else if(testing_type.equalsIgnoreCase("negative"))
	    {
	    	Reporter.log("***Neagtive testing***");
	    }
		Reporter.log("Entered username: "+un);
		Reporter.log("Entered password: "+pw);
	}
	
	
    //                                  ***** Login page links ******
	@Test
	public void loginPageLink()
	{
		WebElement link = driver.findElement(By.linkText("OrangeHRM"));
		String b= link.getText();
		extentTest.info("getting link name from application:"+" "+b);
		Reporter.log("Link Name: "+b,true);
		String expectedTitle = "OrangeHRM1";
		extentTest.info("Actual link name:"+expectedTitle);
		if(!(b.equals(expectedTitle)))
		{
			Reporter.log("wrong Link name is displayed:"+" "+b,true);
			extentTest.info("wrong Link name is displayed:"+" "+b);
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
			 jse.executeScript("arguments[0].style.background='Red';",link);	 
		}
		assertEquals(b,expectedTitle,"Title missmatched");
		Reporter.log("correct Link name is displayed: "+b,true);
		extentTest.info("correct Link name is displayed: "+" "+b);
	}
}
