package Framework.SeleniumFramework1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stream1 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String email = "prakash@moresandtechnologies.com";
		String pwd = "@QWertyuiop12";
		String realProduct = "ADIDAS ORIGINAL";
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.xpath("//input[@id = 'userEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id = 'userPassword']")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		List <WebElement> pro = driver.findElements(By.cssSelector(".mb-3"));

		
       WebElement wb =   pro.stream()
         .filter(prod->prod.findElement(By.tagName("b"))
         .getText().equals(realProduct))
         .findFirst().orElseThrow(null);
       
       wb.findElement(By.xpath(".//div[@class = 'card-body'] //button[text() = ' Add To Cart']")).click();
	}

}
