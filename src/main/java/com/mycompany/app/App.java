package com.mycompany.app;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class App {
	public static void captureScreenShot(WebDriver ldriver){
		// Convert web driver object to TakeScreenshot and getScreenshotAs method to create image file           
		 File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
		try
		{
			//copy the screenshot and store in desired location
		FileUtils.copyFile(src, new File("C:\\Users\\Manoj\\Desktop\\Akshata\\Study\\selenium\\Screenshoot\\"
		+System.currentTimeMillis()+".png"));                             
		} catch (IOException e)
		{
			 System.out.println(e.getMessage());
		}
		}	
	
 @Test
	  public void Open_Browser()
	  {
		
		
		//setting property for Chrome browser
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Manoj\\Desktop\\Akshata\\Study\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Open google in Chrome browser
		driver.get("https://www.google.com");
		App.captureScreenShot(driver);
		
		WebElement searchbutton=driver.findElement(By.name("q"));
		//search for "sap fiori trial"
		searchbutton.sendKeys("sap fiori trial");
		App.captureScreenShot(driver);
		
		searchbutton.submit();
		App.captureScreenShot(driver);
		
		//click on First link
		driver.findElement(By.xpath("//*[@id=\'rso\']/div[1]/div/div[1]/div/div/div[1]/a/div/cite")).click();
		App.captureScreenShot(driver);
		
		//click on Demo button
		driver.findElement(By.xpath("//*[@id=\"experience\"]/div[2]/div[3]/div/div[1]/a")).click();
		App.captureScreenShot(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//click on popup
		driver.findElement(By.xpath("//*[@id=\'__button11-content\']")).click();
		  App.captureScreenShot(driver);
		  
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll the page		
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        App.captureScreenShot(driver);
	        
		//Click on the Last Tile(DSO)
		driver.findElement(By.xpath("//*[@data-targeturl='#MySpend-monitor']")).click();
		App.captureScreenShot(driver);

		System.out.println("project executed successfully");
		driver.close();
		
	}

}
