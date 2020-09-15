/**
 * 
 */
package com.sel.firefox;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;  

/**
 * @author sahoo
 *
 */
public class FirefoxDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		 // System Property for Gecko Driver   
	   // System.setProperty("webdriver.gecko.driver","D:\\WebDrivers\\geckodriver.exe" );  
	    System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver85.exe");
	          
	         // Initialize Gecko Driver using Desired Capabilities Class  
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
	     //   DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
	       // capabilities.setCapability("marionette",true);  
	       // WebDriver driver= new FirefoxDriver(capabilities);  
	        WebDriver driver=new ChromeDriver();
	          
	        // Launch Website  
	     driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");  
	      
	        // Fetch the text "This is sample text." and print it on console  
	        // Use the class name of the div to locate it and then fetch text using getText() method  
	     String sampleText = driver.findElement(By.className("col-md-12")).getText();  
	     System.out.println(sampleText);  
	          
	          // Use the linkText locator method to find the link and perform click using click() method  
	     driver.findElement(By.linkText("This is a link")).click();  
	     
	     driver.navigate().back();
	       
	          // Click on the textbox and send value  
	     driver.findElement(By.name("firstName")).sendKeys("JavaTpoint");  
	       
	        // Clear the text written in the textbox  
	     driver.findElement(By.name("firstName")).clear();  
	          
	        // Click on the Submit button using click() command  
	     driver.findElement(By.id("idOfButton")).click();  
	   
	        // Locate the radio button by id and check it using click() function  
	     driver.findElement(By.id("female")).click();  
	          
	        // Locate the checkbox by cssSelector and check it using click() function  
	     driver.findElement(By.cssSelector("input.Automation")).click();  
	              
	        // Use Select class for selecting value from dropdown  
	    Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));  
	    dropdown.selectByVisibleText("Performance Testing");  
	    
	    Actions actions = new Actions(driver);
	    WebElement elementLocator = driver.findElement(By.id("dblClkBtn"));
	    actions.doubleClick(elementLocator).perform();
	    //actions.contextClick(elementLocator).perform(); //Right Click
	    driver.switchTo().alert().accept();
	   // driver.switchTo().alert().dismiss();
	   // driver.switchTo().alert().getText();
	   // driver.switchTo().alert().sendKeys("Text");
	    driver.findElement(By.xpath("//button[contains(.,'Generate Alert Box')]")).click();
	    driver.switchTo().alert().dismiss();
	    driver.findElement(By.xpath("//button[contains(.,'Generate Confirm Box')]")).click();
	    driver.switchTo().alert().dismiss();
	  //Element which needs to drag.    		
    	WebElement From=driver.findElement(By.id("sourceImage"));	
     
	     //Element on which need to drop.		
	     WebElement To=driver.findElement(By.id("targetDiv"));					
	     		
	     //Using Action class for drag and drop.		
	 //    Actions act=new Actions(driver);					
	
	     //Dragged and dropped.		
	     actions.dragAndDropBy(From, 135,40).perform();		
	  //   actions.moveToElement(From, (elementWidth / 2), elementHeight / 2).clickAndHold().build().perform();
	  //   actions.moveToElement(To, (destWidth / 2) , (destHeight / 2)).release().build().perform();
	     driver.findElement(By.xpath("//button[contains(.,'Generate Alert Box')]")).click();
	        // Close the Browser  
	     //        driver.close();  
	     
	     mailTest();

	}
	 @Test
     public static void mailTest() throws MalformedURLException, InterruptedException{
		 WebDriver driver;
		 String URL = "https://www.DemoQA.com";
		 String Node = "http://192.168.43.13:4444/wd/hub";
		 DesiredCapabilities cap = DesiredCapabilities.firefox();
		 
		 driver = new RemoteWebDriver(new URL(Node), cap);
		 
		 driver.navigate().to(URL);
		 Thread.sleep(5000);
		 driver.quit();

}

}
