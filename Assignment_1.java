import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_1 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		misce(driver);
	}
	
	public static void misce(WebDriver driver)
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement chk = driver.findElement(By.xpath("//input[@id = 'checkBoxOption2']"));
	    //WebElement chk = driver.findElement(By.xpath("//label[@for = 'benz']"));
		 chk.click();
		 String val = chk.getAttribute("value");
	     System.out.println(val);
	     
	     //dropdown selection
	     
	     WebElement dp = driver.findElement(By.xpath("//select[@id = 'dropdown-class-example']"));
	     Select sc = new Select(dp);
	       sc.selectByValue(val);
	       
	       //alertbox
	       
	       WebElement al = driver.findElement(By.xpath("//input[@id = 'name']"));
	       al.sendKeys(val);
	       
	       WebElement alt = driver.findElement(By.xpath("//input[@id = 'alertbtn']"));
	       alt.click();
	       
	      String alttextt = driver.switchTo().alert().getText();
	      System.out.println(alttextt);
	      
	      if(alttextt.contains(val))
	        System.out.println("Yes its same");
	      
	      else
	    	  System.out.println("No we are not same bro");
	}

}
