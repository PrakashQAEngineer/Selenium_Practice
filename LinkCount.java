import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCount 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//count links on the entire page
		int str = driver.findElements(By.tagName("a")).size();
		
		System.out.println(str);
		
		//count no of lins in the footer section only
		WebElement wb1 = driver.findElement(By.xpath("//div[@id = 'gf-BIG']"));
		// minimizing the scope of search on footer only
		int foot= wb1.findElements(By.tagName("a")).size();
		System.out.println(foot);
		
		//get the links count of only first column
         WebElement col1 = wb1.findElement(By.xpath("//table[@class = 'gf-t']/tbody/tr[1]/td[1]"));
         int cool = col1.findElements(By.tagName("a")).size();
         System.out.println(cool);
         
         //click on each link and check the site is working or not
	}

}
