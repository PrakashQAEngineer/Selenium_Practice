import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Implicit_Green_Kart 
{
 public static void main(String args[])
 {
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
	 String promoo = "rahulshettyacademy";
	 String[] veg_name = {"Onion", "Musk Melon", "Water Melon", "Cashews" };
	 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	 
	 //selectVeg(driver,veg_name);
	 Implicit_Green_Kart vg1 = new Implicit_Green_Kart();
	 vg1.selectVeg(driver, veg_name);
	 vg1.cart(driver);
	 vg1.promo(driver, promoo);
	 vg1.address(driver);
	 
 }
 
    public void selectVeg(WebDriver driver, String[] veg_name)
    {
    	
    	List <WebElement> wb1 = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
    	  
    	for(int i=0;i<wb1.size();i++)
    	{
    		String veg_sel = wb1.get(i).getText();
    		//System.out.println(veg_sel);
    		String update_veg_name = veg_sel.split("-")[0].trim();
    		System.out.println(update_veg_name);
    		
    		List<String> al = Arrays.asList(veg_name);
    		if(al.contains(update_veg_name))
    		{
    			driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
    		}
    	}
    }
    
    public void cart(WebDriver driver)
    {
    	WebElement wd1 = driver.findElement(By.xpath("//img[@alt = 'Cart']"));
    	//String str = wd1.getDomAttribute("src");
        //System.out.println(str);
    	wd1.click();
    	driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
    	
    }
    
    public void promo(WebDriver driver,  String promoo)
    {
    	driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys(promoo);
    	driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
    	driver.findElement(By.xpath("//button[text() = 'Place Order']")).click();
    }
    
    public void address(WebDriver driver)
    {
    	WebElement wb12 = driver.findElement(By.xpath("//select[@style = 'width: 200px;']"));
    	Select sc = new Select(wb12);
    	sc.selectByValue("India");
    	
    	driver.findElement(By.cssSelector(".chkAgree")).click();
    	driver.findElement(By.xpath("//button[text() = 'Proceed']")).click();
    	
    			
    }

}
