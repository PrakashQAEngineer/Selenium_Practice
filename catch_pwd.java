import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class catch_pwd 
{
	public static void main(String args[]) throws InterruptedException
	{
		String userName = "Prakash Singh";
		String pwd = "phorfic";
		String email = "im7prakash@gmail.com";
		String phn = "7978670045";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.xpath("//input[@id = 'inputUsername']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name = 'inputPassword']")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//input[@id = 'chkboxOne']")).click();
		driver.findElement(By.xpath("//input[@id = 'chkboxTwo']")).click();
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();
		
		String error = driver.findElement(By.cssSelector("p[class = 'error']")).getText();
		String act_error = "* Incorrect username or password";
		Assert.assertEquals(error, act_error);
		
		//click on the Forgot password
		
		driver.findElement(By.xpath("//a[text() = 'Forgot your password?']")).click();
		
		Thread.sleep(5000);
		// enter name email and phone number
		
		driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder = 'Phone Number']")).sendKeys(phn);
		
		String str_pwd = getpwd(driver);
		driver.findElement(By.xpath("//button[text() = 'Go to Login']")).click();
		
		driver.findElement(By.xpath("//input[@id = 'inputUsername']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name = 'inputPassword']")).sendKeys(str_pwd);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();
		
		//validating the user is loggedin or not
		Thread.sleep(3000);
		String get_act_user = driver.findElement(By.tagName("h2")).getText();
		//System.out.println(get_act_user);
		Assert.assertEquals(get_act_user, "Hello "+userName+",");
		
		//Logout
		driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
		Thread.sleep(3000);
		String logout = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(logout, "Sign in");
		
		
	}
	
	public static String getpwd(WebDriver driver)
	{
		//click on the reset login button
		
		driver.findElement(By.xpath("//button[text() = 'Reset Login']")).click();
		String pwd = driver.findElement(By.className("infoMsg")).getText();
		System.out.println(pwd);
		
		String ge_pwdpwd = pwd.split("'")[1].split("'")[0].trim();
		return ge_pwdpwd;
		
	}

}
