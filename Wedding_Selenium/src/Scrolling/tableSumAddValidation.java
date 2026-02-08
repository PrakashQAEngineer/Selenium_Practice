package Scrolling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tableSumAddValidation 
{
	public static void main(String args[])
	{
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		windowScrolling(driver);
		countAmount(driver);
	}
	
	public static void windowScrolling(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public static void countAmount(WebDriver driver)
	{  
		int sum=0;
		
		List <WebElement> wb1 = driver.findElements(By.xpath("//table[@id = 'product']/tbody/tr/td[4]"));
		for(int i=0;i<wb1.size();i++)
		{
			sum = sum + Integer.parseInt(wb1.get(i).getText());
			
		}
		System.out.println("The sum of all is: "+sum);
		
		String exp = driver.findElement(By.xpath("//div[@class = 'totalAmount']")).getText();
		int expval = Integer.parseInt(exp.split(":")[1].trim());
		
		System.out.println(expval);
		Assert.assertEquals(sum,expval);
	}

	

}
