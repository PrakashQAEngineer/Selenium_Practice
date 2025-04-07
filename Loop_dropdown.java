import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loop_dropdown 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		 driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
		 
		 //for 4 Adult
		 for(int i=1;i<4; i++)
		 {
			 driver.findElement(By.xpath("//span[@id = 'hrefIncAdt']")).click();
		 }
		 
		 //for 2 Child and Infant
		 for(int i=1;i<=2;i++)
		 {
			 driver.findElement(By.xpath("//span[@id = 'hrefIncChd']")).click();
			 driver.findElement(By.xpath("//span[@id = 'hrefIncInf']")).click();
		 }
		 
		 //click on done
		 
		 driver.findElement(By.xpath("//input[@value = 'Done']")).click();
		 

	}

}
