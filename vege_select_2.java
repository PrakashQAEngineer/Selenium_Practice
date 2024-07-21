package pac2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class vege_select_2 {

	public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("Ca");
			Thread.sleep(4000);
			List<WebElement> wb1  = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
			
			for(int i=0; i<wb1.size(); i++)
			{
				String prod = wb1.get(i).getText();
				if(prod.contains("Capsicum"))
				{
					driver.findElements(By.xpath("//button[text() = 'ADD TO CART']")).get(i).click();
					//button[text() = 'Log Out
				}
			}
				
				
				
				
				
				
				
				
			
			
	}

}
