package pac2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Dropdown 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[contains(@id,'originStation1')]")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@value = 'JRG']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1')] //a[@value = 'HYD']")).click();
	}

}
