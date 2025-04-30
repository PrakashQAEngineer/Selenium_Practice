import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicit_Wait_Green_Kart 
{
	public static void main(String args[]) throws InterruptedException
	{
		String[] veg = {"Beans", "Mushroom", "Nuts Mixture"};
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		selectElement(driver,veg);
		selectCart(driver);
	}
	
	public static  void selectElement(WebDriver driver, String[] veg)
	{
	  List <WebElement> wb1 = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
	  for(int i=0;i<wb1.size();i++)
	  {
		  String getVeg = wb1.get(i).getText();
		  //System.out.println(getVeg);
		  
		  String[] val = getVeg.split("-");
		  String newval = val[0];
		  String stveg = newval.trim();
		  System.out.println(stveg);
		  
		  //convert array as ArrayList\
		  List<String> al = Arrays.asList(veg);
		  if(al.contains(stveg))
		  {
			  driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
		  }
		  
	  }
	}
	
	public static void selectCart(WebDriver driver) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//img[@alt = 'Cart']")).click();
		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		//Thread.sleep(3000);
		//USE of Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); ///Explicit wait declaration
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class = 'promoCode']")));
		driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
		
		//Explicit Wait
		WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(5));
		wai.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class = 'promoInfo']")));
		
		String offer = driver.findElement(By.cssSelector("span[class = 'promoInfo']")).getText();
		System.out.println(offer);
	}

}
