package Framework.SeleniumFramework1;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class standAloneTest 
{
	public static void main(String args[])
	{
		
		String prod = "ADIDAS ORIGINAL";
		String newProd = "iphone 13 pro";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("prakash@moresandtechnologies.com");
		driver.findElement(By.xpath("//input[@id = 'userPassword']")).sendKeys("@QWertyuiop12");
		driver.findElement(By.xpath("//input[@id = 'login']")).click();
		
		WebDriverWait wai = new WebDriverWait(driver,Duration.ofSeconds(5));
		wai.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'toast-container']")));
		
		// get the list of all the products in the listing page
		List<WebElement> prodd = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
			
		WebElement adidasProduct = prodd.stream().filter(pr->pr.findElement(By.tagName("b")).getText().equals(prod))
				.findFirst().orElseThrow(()-> new RuntimeException("Prodct not found: "+prod));
		
		
		
		adidasProduct.findElement(By.xpath(".//button[text()=' Add To Cart']")).click();
		
		//We need to ad the Explicit wait for clicking on the cart
		
		WebDriverWait wt  = new WebDriverWait(driver,Duration.ofSeconds(5));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toast-container']")));
		
		//clicking on the Cart button
		
		driver.findElement(By.xpath("//button[@routerlink = '/dashboard/cart']")).click();
		
		//click on the home page
		
		driver.findElement(By.xpath("//button[@routerlink = '/dashboard/']")).click();
		
		
	}

}
