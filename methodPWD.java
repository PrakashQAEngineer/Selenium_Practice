package Method_pwd_Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class methodPWD 
{
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String userName = "Prakash Singh Rajput";
		methodPWD m1 = new methodPWD();
		//m1.getPwd(driver);
		//String finalPwd = getPwd(driver);
		String finalPwd = m1.getPwd(driver);
		System.out.println(finalPwd);
		
		driver.findElement(By.xpath("//button[text() = 'Go to Login']")).click();
		
		//username
		driver.findElement(By.xpath("//input[@id = 'inputUsername']")).sendKeys(userName);
		//pwd
		driver.findElement(By.cssSelector("input[name = 'inputPassword']")).sendKeys(finalPwd);
		
		//SignIn Button
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();
		
		
		
	}

	public  String getPwd(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//a[text() = 'Forgot your password?']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text() = 'Reset Login']")).click();
		
		//catch the dynamic pwd
		
		String str = driver.findElement(By.xpath("//p[@class = 'infoMsg']")).getText();
		System.out.println(str);
		
		String pwdd[] = str.split("'");
		String fpwd = pwdd[1].split("'")[0].trim();
		System.out.println(fpwd);
		
		return fpwd;
		
	}
}
