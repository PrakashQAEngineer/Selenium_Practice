package GreenKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitGreenKart 
{
	static int count = 0;
	public static void main(String args[])
	{
		
		
		String[] veg = {"Water Melon", "Mushroom", "Brocolli"};
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		selectVege(driver, veg);
		selectCart(driver);
		orderPlacing(driver);
	}
	
	public static void selectVege(WebDriver driver, String[] veg)
	{
		List al = Arrays.asList(veg);
	   	List <WebElement> wb1 = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
	   	for(int i=0; i<wb1.size();i++)
	   	{
	   		String veg_get = wb1.get(i).getText().split("-")[0].trim();
	   		System.out.println(veg_get);
	   		
	   		if(al.contains(veg_get))
	   		{
	   			count++;
	   			driver.findElements(By.xpath("//div[@class = 'product-action']")).get(i).click();
	   			
	   		 if(count==al.size())
	   			 break;
	   					   			    
	   				
	   		}
	   		
	   	}
	}
	
	public static void selectCart(WebDriver driver)
	{
		driver.findElement(By.xpath("//img[@alt = 'Cart']")).click();
		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'Place Order']")));
		
	}
	  public static void orderPlacing(WebDriver driver)
	  {
		  driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
		  driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
	  }

}
