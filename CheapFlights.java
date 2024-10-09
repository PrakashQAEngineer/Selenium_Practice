import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheapFlights 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get("https://www.cheapflightsfares.com/baggage-fees");
		link(driver);
		
	}
	
	public static void link(WebDriver driver)
	{
		List <WebElement> links = driver.findElements(By.tagName("a"));
		
		for (WebElement link : links)
		{
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
		
	}
}
