import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mmt1 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class = 'commonModal__close']")).click();
		
		driver.findElement(By.xpath("//input[@id = 'fromCity']")).click();
		
		List <WebElement> wb1 = driver.findElements(By.xpath("//li[contains(@id,'react-autowhatever-1-section-0')]"));
		  for(int i=0;i<wb1.size();i++)
		  {
			  String air = wb1.get(i).getText();
			  System.out.println(air);
			  
			 		 
		  }
		  for(int j=0;j<wb1.size();j++)
		  {
			  String air = wb1.get(j).getText();
			  if(air.contains("HYD"))
			  {
				  wb1.get(j).click();
				  break;
			  }
				 
		  }

	}

}
