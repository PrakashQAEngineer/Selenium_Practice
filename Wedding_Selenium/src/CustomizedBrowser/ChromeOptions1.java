package CustomizedBrowser;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptions1 
{
	public static void main(String args[])
	{
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); //this accepint the certifications of SSL for chrome browser for Websites
		options.addArguments("Incognito"); //opening the incognito
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
	}

}
