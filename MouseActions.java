package Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.in/");
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id = 'nav-link-accountList-nav-line-1']")));
		
		//moving mouse to the Account and List section
		WebElement wb1 = driver.findElement(By.xpath("//span[contains(@id,'nav-link-accountList')]"));
		
		//creating an object for the Action class
		
		Actions act = new Actions(driver);
		act.moveToElement(wb1).build().perform();
	   
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(4));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'twotabsearchtextbox']")));
		
		//move to the textbox and click on it
		WebElement wb2 = driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"));
		act.moveToElement(wb2).click().keyDown(Keys.SHIFT).sendKeys("toys").build().perform();
		//act.moveToElement(wb1).build().perform();
		act.moveToElement(wb2).doubleClick().build().perform();
		act.moveToElement(wb1).contextClick().build().perform();
		
		
		
	}
	

}
