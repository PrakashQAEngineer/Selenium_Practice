package Actions_Frames;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class actionDemo2 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		childWindow(driver);
	}
	
	 public static void childWindow(WebDriver driver)
	 {
		 driver.findElement(By.cssSelector(".blinkingText")).click();
		 Set <String> win = driver.getWindowHandles();
		    Iterator<String> it = win.iterator();
		   String  parentId = it.next();
		   String childId = it.next();
		   
		   driver.switchTo().window(childId);
		   String pwd = driver.findElement(By.xpath("//p[@class = 'im-para red']")).getText().split("with")[0].split("at")[1].trim();
		   System.out.println(pwd);
		   driver.switchTo().window(parentId);
		   driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(pwd);
		 
	 }

}
