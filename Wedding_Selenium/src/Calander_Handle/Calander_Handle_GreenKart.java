package Calander_Handle;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calander_Handle_GreenKart 
{
	
	public static void main(String args[])
	{
		String year = "2015";
		String month = "08";
	    String day = "16"; 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		getCalander(driver, year,month,day);
	}
	
	public static void getCalander(WebDriver driver, String year, String month, String day)
	{
		String spe = "-";
		driver.findElement(By.className("react-date-picker__inputGroup__input")).click();
		
		String res = year + spe + month + spe + day;
		System.out.println(res);
		//for selection of year
		for(int i=0;i<2;i++)
		{
			driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
			driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
		}
		
		//selecting the year 
		driver.findElement(By.xpath("//button[text() = '"+year+"']" )).click();
		//driver.findElement(By.xpath("//button/abbr[text() = '"+month+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__tile")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//button/abbr[text() = '"+day+"']")).click();
		
         String str = driver.findElement(By.xpath("//div[@class = 'react-date-picker__inputGroup'] //input")).getDomAttribute("value");
         System.out.println(str);
         
         Assert.assertEquals(res, str);
         
         
		
	}
	

}
