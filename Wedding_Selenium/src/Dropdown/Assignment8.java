package Dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 
{
	//this is the auto suggestive dropdown example
	
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		autoSuggestive(driver);
	}
	
	public static void autoSuggestive(WebDriver driver)
	{
		
		driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys("Ind");
		List<WebElement> li = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']"));
		
		for(int i=0;i<li.size();i++)
		{
			String country = li.get(i).getText();
			//System.out.println(li.size());
			System.out.println(country);
			if(country.equalsIgnoreCase("India"))
			{
				driver.findElements(By.xpath("//div[@class = 'ui-menu-item-wrapper']")).get(i).click();
				break;
			}
			
				
		}
		
		//IMP: if the vlue is dynamicall for the textbox and if we want to print the gettext of the value we need to use this
		String cou = driver.findElement(By.xpath("//input[@id = 'autocomplete']")).getAttribute("value");
		System.out.println(cou);
	}
	

}
