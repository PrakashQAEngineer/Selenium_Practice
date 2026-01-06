package Dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		originAirport(driver);
		Thread.sleep(3000);
		departAirport(driver);
	}
	
	   public static void originAirport(WebDriver driver)
	   {
		   driver.findElement(By.xpath("//input[contains(@id,'originStation1')]")).click();
			driver.findElement(By.xpath("//a[text() = ' Delhi (DEL)']")).click();
	   }
	   
	   public static void departAirport(WebDriver driver)
	   {
		   driver.findElement(By.xpath("//div[contains(@id,'destinationStation1')] //a[text() = ' Port Blair (IXZ)']")).click();
	   }

}
