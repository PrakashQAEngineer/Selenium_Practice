package pac1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators_1 
{
	public static void main(String args[]) throws InterruptedException
	{
		String name = "Prakash";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		 driver.findElement(By.id("inputUsername")).sendKeys(name);
		
		//use of multiple atribute in xpath
		driver.findElement(By.xpath("//input[@type = 'password'][@name = 'inputPassword']")).sendKeys("Phorfic");
		//if we use the class locator then we can take only one class but if we use the xpth and that class have multiple class name then we need to take the name of both of that class just like below
		//driver.findElement(By.xpath("//button[@class = 'submit signInBtn']")).click();
		driver.findElement(By.cssSelector("input[id = 'chkboxOne']")).click();
		driver.findElement(By.xpath("//button[@classs = 'submit signInBtn' or @type = 'submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p[class = 'error']")).getText());
		
		//driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//a[text() = 'Forgot your password?']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Prakash Singh");
		driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("Im7prakash@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder = 'Phone Number']")).sendKeys("7978670045");
		
		driver.findElement(By.xpath("//input[@type = 'text'][2]")).clear();// indexing with the use of xpath
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type = 'text']:nth-child(2)")).clear();// indexing with the use of css selector
		
		Thread.sleep(3000);
		//div[@class = 'form-container sign-up-container'] //input[@placeholder = 'Email']
		
     	driver.findElement(By.xpath("//div[@class = 'form-container sign-up-container'] //input[@placeholder = 'Email']")).sendKeys("im7prakash@gmail.com");// this is here we are using the parent and child xpath
	
     	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
     	
     	String str = driver.findElement(By.xpath("//p[@class = 'infoMsg']")).getText();
     	System.out.println(str);
     	
        String st = str.split("'")[1];
        System.out.println(st);
        
        Thread.sleep(2000);
        
        //driver.findElement(By.xpath("//button[@class = 'go-to-login-btn']")).click();
        driver.findElement(By.xpath("//button[text() = 'Go to Login']")).click(); 
        
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[id*='inpu']")).sendKeys("Prakash"); //regular expression in css selector
        driver.findElement(By.xpath("//input[@name = 'inputPassword']")).sendKeys(st);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //regular expression in xpath
        Thread.sleep(5000);
        String stri = driver.findElement(By.tagName("h2")).getText();
        System.out.println(stri);
		
     // Assert.assertEquals(stri, "Hello"+name+",");
        Assert.assertEquals("Hello "+ name+",", stri);
		
        driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
		
	}

}
