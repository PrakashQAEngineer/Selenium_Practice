import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class green_kart 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] veg_sel = {"Cauliflower", "Potato", "Musk Melon"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List <WebElement> wb1 = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		
		//System.out.println(wb1.size());
		for(int i=0;i<wb1.size();i++)
		{
			String veg = wb1.get(i).getText();
			System.out.println(veg);
			
			String new_veg = veg.split("-")[0].trim();
			System.out.println(new_veg);
			
			// converting arry into array list
			
			{
				driver.findElements(By.xpath("//button[text() = 'ADD TO CART']")).get(i).click();
			}
		}
	}

}
