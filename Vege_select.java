import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vege_select 
{
	public static void main(String args[])
	{
		String[] vege = {"Cucumber", "Brinjal", "Walnuts"};
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> li = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		
		for(int i=0; i<li.size();i++)
		{
			String veg_list = li.get(i).getText().split("-")[0].trim();
			//System.out.println(veg_list);
			
			// we need to convert arry to arry list because it supports a method call contains
			
			List<String> ar = Arrays.asList(vege);
			int j=0;
			if(ar.contains(veg_list))
			{
				j++;
				driver.findElements(By.xpath("//div[@class = 'product-action']")).get(i).click();
				if(j>2)
					break;
			}
		}
		
	}

}
