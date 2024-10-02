import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handle_2 
{
  public static void main(String args[])
  {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	  driver.findElement(By.cssSelector(".blinkingText")).click();
	  
	  //get all the windows opened by automation
	  Set <String> window = driver.getWindowHandles();
	  // iterate all the windows one by one opened by automation
	    java.util.Iterator<String> it = window.iterator();
	    // move to the parent window which is 0th index by using next
	      String parent = it.next();
	      //move to the child winodw 1st index by using next 
	      String child = it.next();
	      
	      //switch to child winodw
	      driver.switchTo().window(child);
	      
	      String text = driver.findElement(By.className("red")).getText();
	      String txt1 = text.split("at")[1];
	      String txt2 = txt1.split("with")[0].trim();
	      System.out.println(txt2);
  }
  
}
