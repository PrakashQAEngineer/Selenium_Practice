package LocatorPractice_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorPractice_Basic {
	public static void main(String args[]) throws InterruptedException {
		
		String userName = "Jyoti Singh";
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
		 
		 //entering the name
		 driver.findElement(By.xpath("//form/input[1]")).sendKeys(userName); //parent child in xapth
		 //entering the email
		 driver.findElement(By.cssSelector("form input:nth-child(3)")).sendKeys("test");  ///parent child in css selector
         
		 //click on the reset button
		 driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		 
		 String getmssg = driver.findElement(By.tagName("p")).getText();
		 System.out.println(getmssg);
		 
		 String finalPwd = getmssg.split("'")[1].split("'")[0].trim();
		 System.out.println(finalPwd);
		 
		 driver.findElement(By.xpath("//button[text() = 'Go to Login']")).click();
		 //Now Final Login
		 
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector("input[id = 'inputUsername']")).sendKeys(userName);
		 driver.findElement(By.cssSelector("input[name = 'inputPassword']")).sendKeys(finalPwd);
		 
		 //chkbox
		 driver.findElement(By.xpath("//input[@id = 'chkboxOne']")).click();
		 driver.findElement(By.xpath("//input[@id = 'chkboxTwo']")).click();
		 
		 driver.findElement(By.className("submit")).click();
		 
		 //after Login
		 Thread.sleep(2000);
		 		 
		 String str = driver.findElement(By.xpath("//div[@class = 'login-container'] //h2")).getText();
		 System.out.println(str);
		 
		 Assert.assertEquals(str, "Hello "+userName+",");
		 String str2 = driver.findElement(By.xpath("//div[@class = 'login-container'] //h1")).getText();
		 System.out.println(str2);
		 
		 String asst = driver.findElement(By.tagName("p")).getText();
		 System.out.println(asst);
		 
		 Assert.assertEquals(asst, "You are successfully logged in.");
		 
		 //Logout Button
		 driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
	}

}
