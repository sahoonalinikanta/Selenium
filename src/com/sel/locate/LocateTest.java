package com.sel.locate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocateTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver85.exe");
		WebDriver driver=new ChromeDriver();
		/*
		 * driver.navigate().to("http://rediff.com");
		 * driver.findElement(By.cssSelector("a[title*='Sign']")).click();
		 * //driver.findElement(By.xpath("//input[contains(@id,'log')]")).sendKeys(
		 * "hiii"); driver.get("http://www.qaclickacademy.com/interview.php");
		 * //driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();
		 * 
		 * //driver.findElement(By.xpath(
		 * "//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click
		 * ();
		 * 
		 * System.out.println(driver.findElement(By.xpath(
		 * ".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
		 * driver.get("http://spicejet.com"); //URL in the browser
		 * 
		 * // //a[@value='MAA'] - Xpath for chennai
		 * 
		 * // //a[@value='BLR']
		 * 
		 * driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(
		 * );
		 * 
		 * driver.findElement(By.xpath("//a[@value='BLR']")).click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		 * 
		 * driver.findElement(By.
		 * xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"
		 * )).click();
		 * 
		 * driver.findElement(By.cssSelector(
		 * ".ui-state-default.ui-state-highlight.ui-state-active")).click();
		 */
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		    driver.findElement(By.id("autosuggest")).sendKeys("ind");

		    Thread.sleep(3000);

		    List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		    for(WebElement option :options)

		    {

		    if(option.getText().equalsIgnoreCase("India"))

		    {

		    option.click();

		    break;

		    }

		    }
		    driver.get("http://spicejet.com"); //URL in the browser
		    Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$chk_SeniorCitizenDiscount']")).isSelected());

		  //Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		  driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$chk_SeniorCitizenDiscount']")).click();

		  System.out.println(driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$chk_SeniorCitizenDiscount']")).isSelected());

		  Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$chk_SeniorCitizenDiscount']")).isSelected());

	}

}
