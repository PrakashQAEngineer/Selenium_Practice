package Links;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
		linkClick(driver);
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
	
	  public static void linkClick(WebDriver driver)
	  {
		  WebElement ft = driver.findElement(By.id("gf-BIG"));
			WebElement wb1 = ft.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
			int size = wb1.findElements(By.tagName("a")).size();
			System.out.println(size);
			
			
			//Actions act = new Actions(driver);
			
					
			for(int i=0;i<size;i++)
			{
				String clkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);   //using ctrl and clk
				wb1.findElements(By.tagName("a")).get(i).sendKeys(clkTab);
				/*WebElement link = wb1.findElements(By.tagName("a")).get(i);
				act.keyDown(Keys.CONTROL)
			       .click(link)
			       .keyUp(Keys.CONTROL)
			       .perform();*/
			       
			}
			System.out.println("*********************************");
			
			//move to the new tab and capture the title
			Set<String> win = driver.getWindowHandles();
			    Iterator<String> it = win.iterator();
			    while(it.hasNext())
			    {

			       driver.switchTo().window(it.next());
			       System.out.println(driver.getTitle());
			    }
	  }
	

}
