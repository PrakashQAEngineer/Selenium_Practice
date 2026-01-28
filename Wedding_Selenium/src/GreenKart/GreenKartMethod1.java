package GreenKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartMethod1 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String[] vege = {"Tomato", "Onion", "Nuts Mixture"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		addCart(driver , vege);
	}
	
	public static void addCart(WebDriver driver , String[] vege)
	{
		int count=0;
	  	List<String> al = Arrays.asList(vege);
	  	System.out.println(al);
	  	
	  	List <WebElement> wb1 = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
	    for(int i=0; i<wb1.size();i++)
	    {
	    	//System.out.println(wb1.get(i).getText());
	       String veg = wb1.get(i).getText();
	       String vegg = veg.split("-")[0].trim();
	       
	       	
	       if(al.contains(vegg))
	       {
	    	   count++;
	    	   List <WebElement> wb2 = driver.findElements(By.xpath("//div[@class = 'product-action'] //button"));
	    	   wb2.get(i).click();
	    	   
	    	   System.out.println(count);
	    	   if(count==al.size())
	    		   break;
	       }

	    }
	}

}
