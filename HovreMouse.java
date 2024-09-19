import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HovreMouse 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.com/");
		WebElement wb = driver.findElement(By.xpath("//span[@id = 'nav-link-accountList-nav-line-1']"));
		
		Actions ac = new Actions(driver);
		ac.moveToElement(wb).build().perform();
	}

}
