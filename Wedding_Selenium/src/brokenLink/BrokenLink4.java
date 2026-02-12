package brokenLink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrokenLink4 
{
	@Test
	 public void brokenLinkkk()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		brokenlink4(driver);
	}
	
	public static void brokenlink4(WebDriver driver)
	{
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	   List	<WebElement> links = driver.findElements(By.tagName("a"));
	   
	   System.out.println("the no of links are: "+links.size());
	   SoftAssert as = new SoftAssert();
	   
	   for(WebElement link: links)
	   {
		   String url = link.getAttribute("href");
		   System.out.println(url);
		   
		   if(url==null || url.isEmpty())
			   System.out.println("PLease provide the URL....");
		   
		   try
		   {
			   URL uri = new URL(url);
			   HttpURLConnection con = (HttpURLConnection) uri.openConnection();
			   con.connect();
			   
			   int code = con.getResponseCode();
			   as.assertTrue(code<400, "the code that is broken is: "+code+" "+url);
			   
			   
		   }
		   
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }
		   
		   
	   }
	   
	   as.assertAll();
	}

}
