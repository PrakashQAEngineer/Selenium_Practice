package JavaEndtoEnd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RahulShettyEnd2End 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		deptDest(driver);
		calander(driver);
		passangers(driver);
		currency(driver);
	}
	
	
	public static void deptDest(WebDriver driver)
	{
	  //depart
		driver.findElement(By.xpath("//input[contains(@id,'originStation1')]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'originStation1')] //a[text() = ' Port Blair (IXZ)']")).click();
		
		//return
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1')] //a[text() = ' Hyderabad (HYD)']")).click();
	}

	public static void calander(WebDriver driver)
	{
		//depart date calander
		driver.findElement(By.className("ui-state-active")).click();
		
		//return date check
		String str = driver.findElement(By.xpath("//div[@id = 'Div1']")).getDomAttribute("style");
		System.out.println("Printing the DOM Attribute: "+str);
		
		if(str.contains("opacity: 0.5"))
		{
			System.out.println("Depart date is not selected");
		}
		
		else
		{
			System.out.println("Depart date is selected");
		}
	}
	
	public static void passangers(WebDriver driver)
	{
		WebElement wb1 = driver.findElement(By.xpath("//div[@id = 'divpaxinfo']"));
		wb1.click();
		
		//selecting multiple pax for adult
		for(int i=0;i<3;i++)
		{
			driver.findElement(By.xpath("//span[@id = 'hrefIncAdt']")).click();	
			driver.findElement(By.xpath("//span[@id = 'hrefIncChd']")).click();
			driver.findElement(By.xpath("//span[@id = 'hrefIncInf']")).click();			
		}
		
		driver.findElement(By.xpath("//input[@id = 'btnclosepaxoption']")).click();
		
		
	}
	  public static void currency(WebDriver driver)
	  {
		  WebElement wb2 = driver.findElement(By.xpath("//select[@id = 'ctl00_mainContent_DropDownListCurrency']"));
		  wb2.click();
		  
		  Select sc = new Select(wb2);
		  sc.selectByValue("AED");
		  
		  //chkbox
		  driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		  
		  driver.findElement(By.xpath("//input[@type = 'submit']")).click();
	  }
}
