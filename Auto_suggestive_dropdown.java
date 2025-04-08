import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto_suggestive_dropdown 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id = 'autosuggest']")).sendKeys("IND");
		
		List<WebElement> option = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']/a"));
		
		for(WebElement li: option)
		{
			System.out.println(li.getText());
			
			if(li.getText().equalsIgnoreCase("India"))
			{
				li.click();
				break;
			}
				
			
		}
		
		
	}

}
