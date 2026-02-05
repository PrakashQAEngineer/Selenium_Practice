package Links;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCounts 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		completePageLink(driver);
		footerSecLink(driver);
		
		//LinkCounts lc = new LinkCounts();
		//lc.completePageLink(driver);
	}
	
	public static void completePageLink(WebDriver driver)
	{
		int count = driver.findElements(By.tagName("a")).size();
		System.out.println("Count of the links for all pages are: "+count);
	}
	
	public static void footerSecLink(WebDriver driver)
	{
		WebElement ft = driver.findElement(By.id("gf-BIG"));
		int ft_int  = ft.findElements(By.tagName("a")).size();
		System.out.println("the no of links in footer are "+ft_int);
	}
	
	

}
