import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CrystalTravelBookingFlow 
{
   public static void main(String args[]) throws InterruptedException
   {
	   WebDriver driver  = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   
	   //opening the Home page of CrystalTravel
	   driver.get("https://www.crystaltravel.co.uk/");
	   
	   homePage(driver);
	   
   }
   
   public static void homePage(WebDriver driver) throws InterruptedException
   {
	   
	   String origin = "LHR";
	   String dest = "DEL";
	   
	   //verify if on the HOme Page
	   String getTitle = driver.getTitle();
	   Assert.assertEquals(getTitle, "Book Flight Tickets | Cheap Airline Tickets - Crystal Travel");
	 //accepting the cookie
	   driver.findElement(By.xpath("//button[text() = 'Allow all']")).click();
	   
	   //origin
	   WebElement ori = driver.findElement(By.xpath("//input[@id = 'txtOrigin']"));
	   ori.sendKeys(origin);
	  
	   
	   //explicit wait
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	   wait.until(d -> {
	       WebElement el = driver.findElement(By.id("ui-id-1"));
	       return el.getCssValue("display").equals("block");
	   });
	   ori.sendKeys(Keys.DOWN);
	   	
	   //destination
	   WebElement des = driver.findElement(By.xpath("//input[@id = 'txtDestination']"));
	   des.sendKeys(dest);
	   
	    wait.until(de -> {
	       WebElement el = driver.findElement(By.id("ui-id-2"));
	       return el.getCssValue("display").equals("block");
	   });
	   
	   des.sendKeys(Keys.DOWN);
	   
	   //Depart Date and Arrival date
	   driver.findElement(By.xpath("//input[@id = 'hdnDepartDate']")).click();
	   
	   for(int i=0;i<5;i++)
	   driver.findElement(By.xpath("//a[@title = 'Next']")).click();
	   
	   driver.findElement(By.xpath("//div[contains(@class,'datepicker-group-last')] //a[text() = '7']")).click();
	   driver.findElement(By.xpath("//div[contains(@class,'datepicker-group-first')] //a[text() = '30']")).click();
	   
	   //Submiting the Search Request
	   driver.findElement(By.xpath("//input[@value = 'Search']")).click();
   }
}
