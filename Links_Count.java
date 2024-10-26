import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links_Count 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.flipkart.com/");
          List<WebElement> wb1 = driver.findElements(By.tagName("a"));
          System.out.println(wb1.size());
		
          // links count on flipkart for the footer section
          
          WebElement foot = driver.findElement(By.xpath("//div[@class = '_1ZMrY_']"));
          List <WebElement> foota = foot.findElements(By.tagName("a"));
          System.out.println(foota.size());
          for(int i=0; i<foota.size();i++)
          {
        	  String te = foota.get(i).getText();
        	  System.out.println(te);
          }
          
         WebElement fooot = driver.findElement(By.xpath("//div[@class = '_1ZMrY_']/div"));
         List<WebElement> ww= fooot.findElements(By.tagName("a"));
         for(int i=0;i<ww.size();i++)
         {
        	 String tex = ww.get(i).getText();
        	 System.out.println(tex);
        	 
        	 String clktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
        	 ww.get(i).sendKeys(clktab);
         }
         
        Set<String> win = driver.getWindowHandles();
           java.util.Iterator<String> it = win.iterator();  
             while(it.hasNext())
             {
            	 driver.switchTo().window(it.next());
            	 System.out.println(driver.getTitle());
            	 System.out.println("****************************************");
            	
             }
	}
	
	

}
