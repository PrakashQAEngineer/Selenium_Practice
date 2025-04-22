import static org.testng.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class enabled_disabled 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		boolean b1 = driver.findElement(By.xpath("//input[contains(@id,'StudentDiscount')]")).isEnabled();
		System.out.println(b1);
		
		String str = driver.findElement(By.xpath("//div[@class = 'picker-second']")).getDomAttribute("style");
		System.out.println(str);
		
		
		if(str.contains("1"))
		{
			System.out.println("It is enabled");
			Assert.assertTrue(true);
		}
		
		else
			System.out.println("it is disabled");
		Assert.assertFalse(false);
		
		driver.findElement(By.xpath("//input[contains(@name,'date2')]")).click();
		//Thread.sleep(3000);
		String str1 = driver.findElement(By.xpath("//div[@class = 'picker-second']")).getDomAttribute("style");
		System.out.println(str1);
		
		
		if(str1.contains("1"))
		{
			System.out.println("It is enabled");
			Assert.assertTrue(true);
		}
		
		else
			System.out.println("it is disabled");
		Assert.assertFalse(false);
		
	}

}
