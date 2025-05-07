package Frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Practice_frame 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/");
		WebDriverWait wt  = new WebDriverWait(driver, Duration.ofSeconds(3));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Frames']")));
		
		driver.findElement(By.xpath("//a[text()= 'Frames']")).click();
		
		WebDriverWait wt1 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wt1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Nested Frames']")));
		
		driver.findElement(By.xpath("//a[text() = 'Nested Frames']")).click();
		WebElement fr1 = driver.findElement(By.xpath("//frame[@name = 'frame-top']"));
		
		//Thread.sleep(3000);
		driver.switchTo().frame(fr1);
		WebElement ch1 = driver.findElement(By.xpath("//frame[@name = 'frame-middle']"));
		driver.switchTo().frame(ch1);
		String fra =driver.findElement(By.xpath("//div[@id = 'content']")).getText();
		 System.out.println(fra);
		 
		 
		 driver.switchTo().defaultContent(); //move back to the default parent frame
		 driver.switchTo().parentFrame();
		 
	}

}
