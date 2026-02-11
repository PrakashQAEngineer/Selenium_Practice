package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLInk3 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		BrokenLink3(driver);
		driver.quit();
		
	}
	
	public static void BrokenLink3(WebDriver driver)
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement>  links = driver.findElements(By.tagName("a"));
		
		System.out.println("The no of links are: "+links.size());
		
		String baseUrl = driver.getCurrentUrl();
		
		for(WebElement link: links)
		{
			String str = link.getAttribute("href");
			System.out.println("links are: "+str);
			
			if(str == null || str.isEmpty())
			{
				System.out.println("URL is blank");
				continue;
			}
				
			
			else
			{
				/*if(!str.startsWith("http://") || (!str.startsWith("https://")))
				{
					str = baseUrl + str;
				}*/
				
				try
				{
					URL bro = new URL(str);
					HttpURLConnection con = (HttpURLConnection) bro.openConnection();
					con.connect();
					int code = con.getResponseCode();
					
					if(code>400)
					{
						System.out.println("*********We have got the broken link:  "+str);
					}
					
					else
						System.out.println("This is not the broken link:    "+str);
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				} 
				
				
			}
		}
		
		System.out.println("DOne all");
		//driver.close();
	}
	
	

}
