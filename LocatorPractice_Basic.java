package LocatorPractice_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice_Basic {
	public static void main(String args[]) throws InterruptedException {
		
		String userName = "Prakash Singh Rajput";
		String pwd = "@QWertyuiop16";
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

		// username
		driver.findElement(By.id("inputUsername")).sendKeys(userName);

		// password
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);

		// chkbox
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.cssSelector("#chkboxTwo")).click();

	
		// SignInbutton

//driver.findElement(By.cssSelector("button[type = 'submit']"));
		driver.findElement(By.cssSelector("button[class = 'submit signInBtn']")).click();

		// catching error
		String errorGet = driver.findElement(By.className("error")).getText();
		System.out.println(errorGet);
		
		// forgot your pwd
		 driver.findElement(By.xpath("//a[text() = 'Forgot your password?']")).click();
		 
		 
		 //Forgot PWD name
		 driver.findElement(By.xpath("//input[@type = 'text'][1]")).sendKeys(userName);
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector("input[type = 'text']:nth-child(2)")).clear();
		 
		 
         
	}

}
