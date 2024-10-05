import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame_1 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		frame(driver);
	}
	
	public static void frame(WebDriver driver)
	{
		driver.get("https://jqueryui.com/droppable/");
		WebElement fram = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
		// for switching our selenium to frames.
		driver.switchTo().frame(fram);
		WebElement drag = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id = 'droppable']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, target).build().perform();
		
		//after performing actions on the iframes now if we want to move back to the main content or window
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text() = 'Accept']")).click();
				
	}
	
	

}
