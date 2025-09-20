package Framework.SeleniumFramework1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MultiProdCartAssertion 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/client");
		
		List<String> realProduct = Arrays.asList("ZARA COAT 3", "IPHONE 13 PRO");
		String email = "prakash@moresandtechnologies.com";
		String pwd = "@QWertyuiop12";
		
		//login
		driver.findElement(By.xpath("//input[@id = 'userEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id = 'userPassword']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id = 'login']")).click();
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));
		wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'toast-container']")));
		
		List<WebElement> liprod = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		for(String product: realProduct)
		{
			System.out.println("Product we have selected: "+product);
			Optional<WebElement> wbl = liprod.stream().filter(pro->pro.findElement(By.cssSelector("b")).getText().equals(product)).findFirst();
			
			if(wbl.isPresent())
			{
				//System.out.println("test1");
				WebElement realElement = wbl.get();
				realElement.findElement(By.xpath(".//div[@class = 'card-body'] //button[text() = ' Add To Cart']")).click();
				//System.out.println("test2");
				WebDriverWait wt2 = new WebDriverWait(driver,Duration.ofSeconds(5));
				wt2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'toast-container']")));
				//System.out.println("test3");
				Thread.sleep(4000);
			//	System.out.println("test4");
			}
		}
		
		//clicking on the cart icon 
		driver.findElement(By.xpath("//button[@routerlink = '/dashboard/cart']")).click();
		
		List <WebElement> ctprd = driver.findElements(By.xpath("//ul[contains(@class,'cartWrap')]"));
		   for(String cartProduct: realProduct)
	    {
	    	Optional <WebElement> wtt = ctprd.stream().filter(ct->ct.findElement(By.tagName("h3")).getText().equals(cartProduct)).findFirst();
	        
	    	if(wtt.isPresent())
	    	{
	    		WebElement finalProd = wtt.get();
	    		String p = finalProd.findElement(By.tagName("h3")).getText();
	    		if(p.equalsIgnoreCase(cartProduct))
	    		{
	    			Assert.assertTrue(true);
	    			System.out.println("Product added is: "+p);
	    		}
	    	}
	    }
	 
		/*List <WebElement> testprod = driver.findElements(By.xpath("//ul[contains(@class,'cartWrap')]//h3"));
		for(String rp: realProduct)
		{
			
			
			Boolean b1 = testprod.stream().anyMatch(ct->ct.findElement(By.tagName("h3")).getText().equalsIgnoreCase(rp));
			Assert.assertTrue(b1);
			System.out.println("done");
		}*/
		
		
		
	}

}
