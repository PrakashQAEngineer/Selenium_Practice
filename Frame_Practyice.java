import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_Practyice 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		frame(driver);
		
	}
	
	public static void frame(WebDriver driver) throws InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text() = 'Frames']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text() = 'Nested Frames']")).click();
		
		WebElement wb1 = driver.findElement(By.xpath("//frame[@name = 'frame-top']"));
		driver.switchTo().frame(wb1);
		
		WebElement wb2 = driver.findElement(By.xpath("//frame[@name = 'frame-middle']"));
		driver.switchTo().frame(wb2);
		String str = driver.findElement(By.xpath("//div[@id = 'content']")).getText();
		System.out.println(str);
	}

}
