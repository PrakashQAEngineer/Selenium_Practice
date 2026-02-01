package Actions_Frames;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parent_Child 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		windowHandle(driver);
	}
	
	public static void windowHandle(WebDriver driver)
	{
		driver.findElement(By.xpath("//button[@id = 'visitUsTwo']")).click();
		Set <String> win = driver.getWindowHandles();
          Iterator<String> it = win.iterator();
          String parentId  = it.next();
           String childId = it.next();
           
           driver.switchTo().window(childId);
           String chdTitle = driver.getTitle();
           System.out.println(chdTitle);
          driver.switchTo().window(parentId);
          String parentTitle = driver.getTitle();
          System.out.println(parentTitle);
	}

}
