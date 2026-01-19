package GreenKart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart 
{
	public static void main(String args[])
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String[] veg = {"Cucumber", "Mushroom", "Pears"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
     List <WebElement> prod =  driver.findElements(By.xpath("//h4[@class = 'product-name']"));
     
     for(int i=0; i<prod.size();i++)
     {
    	 String strPrd = prod.get(i).getText();
    	 System.out.println(strPrd);
     }
	}

}
