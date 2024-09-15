import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Veg_Mul_Method 
{
	public static void main(String args[]) throws InterruptedException
	{
		String[] veg = {"Brinjal", "Mushroom", "Raspberry"};
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		additems(driver, veg);
	}
	
	public static void additems(WebDriver driver, String[] veg) throws InterruptedException
	{
		List <WebElement> wb1 = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		
		int j=0;
		for(int i=0; i<wb1.size();i++)
			
			
		{
			String get_veg = wb1.get(i).getText().split("-")[0].trim();
			
			List<String> al = Arrays.asList(veg);
			if(al.contains(get_veg))
			{
				driver.findElements(By.xpath("//div[@class = 'product-action']")).get(i).click();
				j++;
				
				if(j>get_veg.length())
				{
					break;
				}
			}
			
		}
		driver.findElement(By.xpath("//img[@alt = 'Cart']")).click();
		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
		String code = driver.findElement(By.xpath("//span[@class = 'promoInfo']")).getText();
		Assert.assertEquals(code, "Code applied ..!");
		
		driver.findElement(By.xpath("//button[text() = 'Place Order']")).click();
		WebElement se = driver.findElement(By.tagName("select"));
		se.click();
		Select sl = new Select(se);
		sl.selectByValue("Belarus");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text() = 'Proceed']")).click();

	}
}
