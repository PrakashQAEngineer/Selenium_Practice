package brokenLink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink2 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		brokenLink(driver);
		
			 
		
	}
	
	public static void brokenLink(WebDriver driver)
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List <WebElement> href = driver.findElements(By.tagName("a"));
		System.out.println(href.size());
		
		String link="";
		for(int i=0; i<href.size();i++)
		{
			 link = href.get(i).getAttribute("href");
			System.out.println(link);
		
		
		try
		{
			URL broli = new URL(link);
			HttpURLConnection con = (HttpURLConnection) broli.openConnection();
			con.connect();
			
			int code = con.getResponseCode();
			
			if(code>400)
				System.out.println("Broken code are: "+link);
			
			else
				System.out.println("there are no broken code: "+link);
		}
		 
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		System.out.println("All links checked");
	}
	
	
}
