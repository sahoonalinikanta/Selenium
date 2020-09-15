import java.util.Arrays;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\\\WebDrivers\\\\chromedriver85.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		//Thread.sleep(3000);

		addItems(driver, itemsNeeded);

	}

	public static  void addItems(WebDriver driver,String[] itemsNeeded) throws InterruptedException{
	
		int j=0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++){
			
			//Brocolli - 1 Kg
			
			//Brocolli,    1 kg
			
			String[] name=products.get(i).getText().split("-");
			
			String formattedName=name[0].trim();
			
			//format it to get actual vegetable name
			
			//convert array into array list for easy search
			
			//  check whether name you extracted is present in arrayList or not-
			
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName)){
				
				j++;
				
				//click on Add to cart
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeeded.length){
				
					break;
				
				}
			
			}
			
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']//button[text()='PROCEED TO CHECKOUT']")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/div/input]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		WebDriverWait wdw= new WebDriverWait(driver,5);
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
	//	Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	//	Thread.sleep(2000);
		WebElement we =driver.findElement(By.xpath("//div[@style='width: 360px; margin: 10px auto;']//select[@style='width: 200px;']"));
		Select sel= new Select(we);
		sel.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		
	}
}