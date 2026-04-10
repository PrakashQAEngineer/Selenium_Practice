package Wedding_Selenium_Framework_2.FrameworkSelenium2.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Wedding_Selenium_Framework_2.FrameworkSelenium2.LandingPage;

public class BaseTest 
{
	public WebDriver driver;
	@BeforeSuite
	public void initializeDriver() throws IOException
	{
		Properties prop = new Properties();
	    FileInputStream fl = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Wedding_Selenium_Framework_2\\FrameworkSelenium2\\Resources\\GlobalData.properties");
	    prop.load(fl);
	    
	    String getBrowser = prop.getProperty("browser");
	    
	    if(getBrowser.equalsIgnoreCase("chrome"))
	    {
	    	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }
	    
	    else if(getBrowser.equalsIgnoreCase("firefox"))
	    {
	    	driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }
	    
	    else if(getBrowser.equalsIgnoreCase("edge"))
	    {
	    	driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }
		
		
	}
	
	public LandingPage goTo() throws IOException
	{
		LandingPage lp = new LandingPage(driver);
		lp.getSite();
		
		return lp;
	}

}
