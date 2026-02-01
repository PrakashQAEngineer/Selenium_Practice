package Actions_Frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo1 
{
	public static void main(String args[])

	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.flipkart.com/");
		
		moveToElement(driver);
	}
	
	public static void moveToElement(WebDriver driver)
	{
		WebElement wb1 = driver.findElement(By.cssSelector("a[title='Login']"));
	    Actions act = new Actions(driver);
	    act.moveToElement(wb1).build().perform();
	    
	    WebElement wb2 = driver.findElement(By.xpath("//input[contains(@placeholder,'Search for Products')]"));
        act.moveToElement(wb2).click().keyDown(Keys.SHIFT).sendKeys("iphone").doubleClick().contextClick().build().perform();
	}
}
