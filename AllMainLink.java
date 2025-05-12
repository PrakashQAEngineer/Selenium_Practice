import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllMainLink 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		all_link(driver);
		foot_link(driver);
		link_seperate_tabs(driver);
	}
	
	public static void all_link(WebDriver driver)
	{
		int si1 = driver.findElements(By.tagName("a")).size();
		System.out.println("The number of links on the page are: "+si1);
	}
	
	public static void foot_link(WebDriver driver)
	{
		WebElement wb1 = driver.findElement(By.xpath("//div[@id = 'gf-BIG']"));
		int foot_li = wb1.findElements(By.tagName("a")).size();
		System.out.println("The no of footer links are: "+foot_li);
	}
	
	public static void link_seperate_tabs(WebDriver driver)
	{	 
		WebElement wb1 = driver.findElement(By.xpath("//div[@id = 'gf-BIG']/table/tbody/tr/td/ul"));
        List <WebElement> li = wb1.findElements(By.tagName("a"));
                
        for(int i=1;i<li.size();i++)
        {
        	String ke = Keys.chord(Keys.CONTROL,Keys.ENTER);
        	 li.get(i).sendKeys(ke);
        }
        
        Set<String> win = driver.getWindowHandles();
         java.util.Iterator<String> it= win.iterator();
         
         while(it.hasNext())
         {
        	
        	 driver.switchTo().window(it.next());
        	 System.out.println(driver.getTitle());
         }
		
		
	}
	
	

}
