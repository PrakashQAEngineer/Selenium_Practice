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

public class MultiProduct2 
{
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String args[]) throws InterruptedException
	{
		String email = "prakash@moresandtechnologies.com";
		String pwd = "@QWertyuiop12";
		
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<String> realProduct = Arrays.asList("ADIDAS ORIGINAL", "ZARA COAT 3");
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.xpath("//input[@id = 'userEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id = 'userPassword']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id = 'login']")).click();
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));
		wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'toast-container']")));
		
		
		List <WebElement> listProd = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		
		for(String prod: realProduct)
		{
			Optional<WebElement> finalPro = listProd.stream().filter(pr->pr.findElement(By.cssSelector("b")).getText().equals(prod)).findFirst();
			if(finalPro.isPresent())
			{
				//System.out.println("test");
				WebElement wb = finalPro.get();
				wb.findElement(By.xpath(".//div[@class = 'card-body'] //button[text() = ' Add To Cart']")).click();
				
			//	driver.navigate().refresh();
				//WebDriverWait wt1 = new WebDriverWait(driver,Duration.ofSeconds(6));
			    //wt1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'toast-container']")));
				Thread.sleep(5000);
			}
		}
		
		//clicking on the Cart icon
		 driver.findElement(By.xpath("//button[@routerlink = '/dashboard/cart']")).click();
		 
		 //verifying the product that we have passed on the array list as the product
		 	
		 List <WebElement> cartprod = driver.findElements(By.xpath("//ul[contains(@class,'cartWrap')]"));
		 for(String prod:  realProduct)
		 {
			Optional <WebElement> ctProduct =  cartprod.stream().filter(ctpr->ctpr.findElement(By.tagName("h3")).getText().equals(prod)).findFirst();
			if(ctProduct.isPresent())
			{
				WebElement wb2 = ctProduct.get();
				String finalProd = wb2.findElement(By.tagName("h3")).getText();
				//System.out.println(finalProd);
				 
				if(finalProd.equals(prod))
				{
					
				         System.out.println("Yes we Got the product as "+prod);
				}
			}
		 }
		
	}

			
}
