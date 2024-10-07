import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_scope_miscelenious 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		link(driver);
		footerLink(driver);
		footercol(driver);
	}
	
		public static void link(WebDriver driver)
		{
			///to find the links on the whole page
			
			int li = driver.findElements(By.tagName("a")).size();
			
			System.out.println("size of the link: "+li);
		}
		
		public static void footerLink(WebDriver driver)
		{
			//to find the link only on the footer
			WebElement footer = driver.findElement(By.xpath("//div[@id = 'gf-BIG']"));
			//Limiting the scope of driver from globally to the footer section only
			
			int foot_link = footer.findElements(By.tagName("a")).size();
			System.out.println("The links on the footer are: "+foot_link);
		}
		
		public static void footercol(WebDriver driver) throws InterruptedException
		{
			// to find the links for the first column only on the footer
			WebElement footer = driver.findElement(By.xpath("//div[@id = 'gf-BIG']"));
			WebElement foo_col = footer.findElement(By.xpath("//table[@class = 'gf-t'] //td[1]"));
			 int foo_link = foo_col.findElements(By.tagName("a")).size();
			 
			 System.out.println("The links on the footer of first column are: "+foo_link);
			
			 //OPENING EVERY LINKS ON NEW TAB(Chord and sendkeys used for this)
			 
			 for(int i=0;i<foo_link;i++)
			 {
				 // this will open links on every new tab.
				 String newtab = Keys.chord(Keys.CONTROL,Keys.ENTER);
				 foo_col.findElements(By.tagName("a")).get(i).sendKeys(newtab); 
				 
				 Thread.sleep(3000L);
			 }// this loop will open all tab	 
				 Set <String> win = driver.getWindowHandles();
				   java.util.Iterator<String> it = win.iterator();
				   
				  // System.out.print(it);
				   while(it.hasNext()) // this loop will check if we have the window data on next or not
				   {
					   String titl = driver.switchTo().window(it.next()).getTitle();
					   System.out.println(titl);
					   
				   }
				 
			 
		}
		
		
		
		
}
	
	
	


