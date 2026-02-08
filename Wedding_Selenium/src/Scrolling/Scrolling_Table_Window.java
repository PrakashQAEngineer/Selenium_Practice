package Scrolling;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling_Table_Window 
{
	public static void main(String ags[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//windowScrolling(driver);//static without creating object
		//tableScrolling(driver); //static without creating object
		Scrolling_Table_Window a1 = new Scrolling_Table_Window();
		a1.windowScrolling(driver);
		a1.tableScrolling(driver);
	}
	
	public  void windowScrolling(WebDriver driver)
	{
		//scrolling in winodow tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	
	
	public  void tableScrolling(WebDriver driver)
	{
		//scrolling the table
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
	}

}
