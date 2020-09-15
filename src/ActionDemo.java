import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.seleniumhq.jetty9.server.HttpChannelState.Action;


public class ActionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\\\WebDrivers\\\\chromedriver85.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']//span[@class='nav-icon nav-arrow']"))).build().perform();

	}

}
