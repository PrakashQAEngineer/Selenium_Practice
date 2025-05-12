import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open_Links_New_Tab 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement wb1 = driver.findElement(By.xpath("//div[@id = 'gf-BIG']/table/tbody/tr/td/ul"));
		List<WebElement> link = wb1.findElements(By.tagName("a"));
		System.out.println(link.size());
		
		for(int i=1;i<link.size();i++)
		{
			String key = Keys.chord(Keys.CONTROL,Keys.ENTER);
			link.get(i).sendKeys(key);
		}
		
		Set<String> win = driver.getWindowHandles();
		java.util.Iterator<String> it = win.iterator();
		
		while(it.hasNext())
		{
			//Thread.sleep(3000);
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
