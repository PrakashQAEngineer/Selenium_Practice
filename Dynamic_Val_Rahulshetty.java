import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dynamic_Val_Rahulshetty 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		dynamicVal(driver);
	}
	
	public static void dynamicVal(WebDriver driver)
	{
		//select any checkbox and get the value
		WebElement wb1 = driver.findElement(By.xpath("//input[@value = 'option2']"));
	    wb1.click();
		String chkbx = wb1.getDomAttribute("value");
		System.out.println("The value of selected checkbox is: "+chkbx);
		
		//select the value from dropdown
		
		  WebElement wb2 = driver.findElement(By.xpath("//select[@id = 'dropdown-class-example']"));
		  Select sc = new Select(wb2);
		  sc.selectByValue(chkbx);
		  
		  //entering value in the textbox of alert
		  driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys(chkbx);
		  driver.findElement(By.id("alertbtn")).click();
		  String getalt = driver.switchTo().alert().getText();
		  System.out.println(getalt);
		     String getnewalt = getalt.split(",")[0].split("Hello")[1].trim();
		     System.out.println(getnewalt);
		     
		     //Verify that selected check box text value is present on alert mssg or not;
		     
		     Assert.assertEquals(chkbx, getnewalt);
		     
		     if(getalt.contains(chkbx))
		    	 System.out.println("Alert box is successfull");
		     
		     else
		    	 System.out.println("Alert box is not successfull");
	}

}
