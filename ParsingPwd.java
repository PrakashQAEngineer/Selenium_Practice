package pac2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ParsingPwd 
{
	public static void main(String args[]) throws InterruptedException
	{
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String username = "Prakash Singh rajput";
		String pwd1 = "qwertyuiop";
		String email = "im7prakash@gmail.com";
		String phn = "7978670045";
		
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@id = 'inputUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name = 'inputPassword']")).sendKeys(pwd1);
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder = 'Phone Number']")).sendKeys(phn);
		driver.findElement(By.xpath("//button[text() = 'Reset Login']")).click();
		
		String finalpwd = getpassword(driver);
		driver.findElement(By.xpath("//button[text() = 'Go to Login']")).click();
		driver.findElement(By.xpath("//input[@id = 'inputUsername']")).clear();
		driver.findElement(By.xpath("//input[@id = 'inputUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name = 'inputPassword']")).clear();
		driver.findElement(By.xpath("//input[@name = 'inputPassword']")).sendKeys(finalpwd);
		System.out.println(finalpwd);
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();
		
		
		
	}
	
	public static String getpassword(WebDriver driver)
	{
		String getpwd = driver.findElement(By.xpath("//p[@class = 'infoMsg']")).getText();
		String catpwd = getpwd.split("'")[1];
		return catpwd;
	}

}
