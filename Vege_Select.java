package pac2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vege_Select 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String vege = "Ca";
		driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys(vege);
		Thread.sleep(3500);
		
		List<WebElement> getvege = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		
		for(int i=0; i<getvege.size();i++)
		{
             String product = getvege.get(i).getText();
             
             if(product.contains("Cashews"))
             {
            	 driver.findElements(By.xpath("//button[text() = 'ADD TO CART']")).get(i).click();
             }
		}
	}

}
