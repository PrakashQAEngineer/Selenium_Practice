package Wedding_Selenium_Framework_2.FrameworkSelenium2;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReuseableComponents.reuseableClass;

public class LandingPage  extends reuseableClass
{
	WebDriver driver;
	
	
	
	public LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement email = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement userMail;
	
	@FindBy(id = "userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	 
	public void getSite() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Wedding_Selenium_Framework_2\\FrameworkSelenium2\\Resources\\GlobalData.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		driver.get(url);
	}
	public ProductSelection loginApplication() throws IOException
	{ 
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Wedding_Selenium_Framework_2\\FrameworkSelenium2\\Resources\\GlobalData.properties");
		prop.load(fis);
		String userName = prop.getProperty("username");
		String userPwd = prop.getProperty("userpwd");
		
		userMail.sendKeys(userName);
		password.sendKeys(userPwd);
		
		login.click();
		
		ProductSelection pc = new ProductSelection(driver);
		return pc;
	}

}
