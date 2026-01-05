package Dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropDown1 
{
	public static void main(String args[]) throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String curr = getCurrency(driver);
		 String pax = getPassanger(driver);
		 
		System.out.println("The selected currecny is: "+curr);
		System.out.println("The no os pax are: "+pax);
		
		Assert.assertEquals(pax, "4 Adult, 1 Child, 1 Infant");
	}
	
	public static String getCurrency(WebDriver driver)
	{
		WebElement curr = driver.findElement(By.xpath("//select[contains(@id,'ListCurrency')]"));
		Select sc = new Select(curr);
		sc.selectByIndex(3);
		String sel_curr = sc.getFirstSelectedOption().getText();
		
		return sel_curr;
	}
	
	public static String getPassanger(WebDriver driver) throws InterruptedException
	{
	    driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
	     //selecting multiple pax adt
	    
	    for(int i=0;i<3;i++)
	      	driver.findElement(By.xpath("//span[@id = 'hrefIncAdt']")).click();
	    
	    driver.findElement(By.xpath("//span[@id = 'hrefIncChd']")).click();
	    driver.findElement(By.xpath("//span[@id = 'hrefIncInf']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//input[@id = 'btnclosepaxoption']")).click();
	    
	    //assertinons for the adult for 3 user
	    
	    String getPax = driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).getText();
	    return getPax;
	    
	    
	}

}
