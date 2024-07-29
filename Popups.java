package pac2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popups 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Prakash");
		driver.findElement(By.xpath("//input[@id = 'alertbtn']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Prakash");
		driver.findElement(By.xpath("//input[@id = 'confirmbtn']")).click();
		Thread.sleep(4000);
		
		driver.switchTo().alert().dismiss();
		
	}

}
