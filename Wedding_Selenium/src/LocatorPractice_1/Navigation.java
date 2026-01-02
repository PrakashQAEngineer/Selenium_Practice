package LocatorPractice_1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//driver.get("https://sparshyog.com/");
		driver.get("https://www.google.com/");
		driver.navigate().to("https://sparshyog.com/");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().forward();
		for(int i=0;i<10;i++)
		{
			Thread.sleep(3000);
			driver.navigate().refresh();
		}
				
	}

}
