import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orange_HRM 
{
  public static void main(String args[]) throws InterruptedException
  {
	  String del_user = "Maci.Conn";
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type = 'submit']")).click();
	  
	  driver.findElement(By.xpath("//span[text() = 'Admin']")).click();
	  
	  Thread.sleep(3000);
	  //picking all the user names of the User in the admin section
	  List<WebElement> wb1 = driver.findElements(By.xpath("//div[@class = 'oxd-table-card']"));
	  
	  //Loop to get that particular user with the use of indexing
	  for(int i=0; i<wb1.size();i++)
	  {
		 // String str = driver.findElements(By.xpath("//div[@class = 'oxd-table-cell oxd-padding-cell']")).get(i).getText();
		  String str = wb1.get(i).getText();
		  System.out.println(str);
		  // if my indexing matches that user then am going to delete that user
		  if(str.contains(del_user))
		  {
			  driver.findElements(By.xpath("//i[@class = 'oxd-icon bi-trash']")).get(i).click();
			  Thread.sleep(4000);
			  driver.findElement(By.xpath("//button[contains(@class,'label-danger')]")).click();
			  driver.navigate().refresh();
			  break; 
		  }
	  }
	  
	  
	  
  }
}
