package Frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id = 'droppable']"));
		
		act.dragAndDrop(source, target).build().perform();
	
	}

}
