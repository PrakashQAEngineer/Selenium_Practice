package pac2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Method_Vege_multi_Selection 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String[] items = {"Tomato", "Onion", "Nuts Mixture", "Walnuts"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		addprod(driver, items);
		clickcart(driver);
		placeorder(driver);
		selectcountry(driver);
		
		
		
		
		
	}
     public static void selectcountry(WebDriver driver) 
     {
	    //driver.findElement(By.xpath(""))
    	 WebElement sel = driver.findElement(By.xpath("//select[@style = 'width: 200px;']"));
	    Select sc = new Select(sel);
	    sc.selectByValue("India");
	    driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
	    driver.findElement(By.xpath("//button[text() = 'Proceed']")).click();
		
	}
	public static void placeorder(WebDriver driver) 
     {
    	 driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
    	 driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
    	 driver.findElement(By.xpath("//button[text() = 'Place Order']")).click();
	 }
	public static void clickcart(WebDriver driver) 
     {
    	 driver.findElement(By.xpath("//a[@class = 'cart-icon']")).click();
    	 driver.findElement(By.xpath("//div[@class = 'action-block'] //button[@type = 'button']")).click();
	}
     
	public static void addprod(WebDriver driver, String[] items)
     {
    	 int j=0;
    	 List<WebElement> prod = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
    	 for(int i=0; i<prod.size();i++)
    	 {
    		 String prod_desc = prod.get(i).getText();
    		  String final_prod = prod_desc.split("-")[0].trim();
    		  //System.out.println(items);
    		  
    		  List pro = Arrays.asList(items);
    		  
    		  if(pro.contains(final_prod))
    		  {
    			  driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
    			  j++;
    			  
    			  // Used the J variable to get out of the loop if all the items has been selected that are defined in the array
    			  if(j>=pro.size())
    			  {
    				  break;
    			  }
    		  }
    	 }
     }
     
   

}
