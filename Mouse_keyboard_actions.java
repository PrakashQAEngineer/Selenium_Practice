import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_keyboard_actions 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.in/");
		WebElement text = driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"));
		Actions act = new Actions(driver);
		//double click
		act.moveToElement(text).click().sendKeys("toy").doubleClick().build().perform();
		
		//right click
		WebElement acc = driver.findElement(By.xpath("//span[contains(@id,'accountList')]"));
		act.moveToElement(acc).contextClick().build().perform();
		
		
	}

}
