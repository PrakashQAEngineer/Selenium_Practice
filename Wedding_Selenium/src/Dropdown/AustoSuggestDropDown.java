package Dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AustoSuggestDropDown 
{
   public static void main(String args[])
   {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   
	   driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	   
	   autoSuggest(driver);
   }
   
   public static void autoSuggest(WebDriver driver)
   {
	   driver.findElement(By.xpath("//input[@id = 'autosuggest']")).sendKeys("Ind");
	   List<WebElement> li = driver.findElements(By.xpath("//li[@class = 'ui-menu-item'] //a"));
	   
	   for(WebElement option : li)
	   {
		   String country = option.getText();
		   System.out.println("The countries listed are: "+country);
		   if(country.equalsIgnoreCase("India"))
		   {
			   option.click();
			   break;
		   }
	   }
	   
   }
}
