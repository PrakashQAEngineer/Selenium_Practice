package GreenKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartImplicitWait 
{
	public static void main(String args[])
	{
		String[] vege = {"Mushroom", "Apple", "Mango", "Nuts Mixture"};
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		
		selectVege(driver, vege);
		clkCart(driver);
		couponCode(driver);
    }
	
	public static void selectVege(WebDriver driver, String[] vege)
	{
		int count=0;
		List al = Arrays.asList(vege);
		System.out.println(al);
		
		List <WebElement> wb1 = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		    for(int i=0;i<wb1.size();i++)
		    {
		    	String newVeg = wb1.get(i).getText();
		    	String vegg = newVeg.split("-")[0].trim();
		    	System.out.println(vegg);
		    	
		    	if(al.contains(vegg))
		    	{
		    		count++;
		    		driver.findElements(By.xpath("//div[@class = 'product-action']")).get(i).click();
		    		
		    		if(al.size()==count)
		    			break;
		    	}
		    }
	}
	    public static void clkCart(WebDriver driver)
	    {
	    	driver.findElement(By.xpath("//img[@alt = 'Cart']")).click();
	    	driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
	    }
	    
	    public static void couponCode(WebDriver driver)
	    {
	    	driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
	    	driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
	    }

}
