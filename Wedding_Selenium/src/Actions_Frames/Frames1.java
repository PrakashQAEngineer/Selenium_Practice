package Actions_Frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames1 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/");
		
		frameSelection(driver);
	}
	
    public static void frameSelection(WebDriver driver)
    {
    	driver.findElement(By.xpath("//a[text() = 'Frames']")).click(); //clicking on frame
    	driver.findElement(By.xpath("//a[text() = 'Nested Frames']")).click();  //nested frame
    	
    	WebElement wb1 = driver.findElement(By.xpath("//frame[@name = 'frame-top']"));
    	driver.switchTo().frame(wb1);
    	
    	WebElement wb2 = driver.findElement(By.xpath("//frame[@name = 'frame-middle']"));
    	driver.switchTo().frame(wb2);
    	
    	String str = driver.findElement(By.xpath("//div[@id = 'content']")).getText();
    	System.out.println(str);
    	
    	
    }
	
}
