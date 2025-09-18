package Framework.SeleniumFramework1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiplProduct1 
{
	public static void main(String args[])
	{
		
		String email = "prakash@moresandtechnologies.com";
		String pwd = "@QWertyuiop12";
		
		//converting arraylist to List String
	    List <String> realProducts = Arrays.asList("iphone 13 pro", "ZARA COAT 3");
	    
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    
		    driver.get("https://rahulshettyacademy.com/client");
		    //login to the application
		    driver.findElement(By.xpath("//input[@id = 'userEmail']")).sendKeys(email);
		    driver.findElement(By.xpath("//input[@id = 'userPassword']")).sendKeys(pwd);
		    driver.findElement(By.xpath("//input[@id = 'login']")).click();
		    
		    WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));
		    wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'toast-container']")));
		    
		 		    
		    List<WebElement> prod =  driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		   // System.out.println("test2");
		    for(String product: realProducts)
		    {
		    	//System.out.println("test3");
		    	 Optional <WebElement> finalpr = prod.stream()
		    	 .filter(pro->pro.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(product)).findFirst();
		    	
		    	 if(finalpr.isPresent())
		    	 {
		    		 System.out.println("test55");
		    		 WebElement wb = finalpr.get();

		    		 
		    		 wb.findElement(By.xpath(".//div[@class = 'card-body'] //button[text() = ' Add To Cart']") ).click();
		    		 WebDriverWait wt1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		    		 wt1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'toast-container']")));
		    	 }
		    	 
		    	 else
		    	 {
		    		 System.out.println("The is no value");
		    	 }
		    }
		    
		    
		    
	}

}
