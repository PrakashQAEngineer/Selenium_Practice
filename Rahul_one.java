package pac2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Rahul_one 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		String name = "Prakash Singh rajput";
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys("Prakash");
		//driver.findElement(By.cssSelector(".signInBtn")).click();
		driver.findElement(By.cssSelector("button[class = 'submit signInBtn']")).click();
		Thread.sleep(2000);
		//getting the text with css selector
	    System.out.println(driver.findElement(By.cssSelector(".error")).getText());
	    
	    // checking the checkbox with the css selector
	    driver.findElement(By.cssSelector("input#chkboxOne")).click();
	    driver.findElement(By.cssSelector("input[value = 'agreeTerms']")).click();
	    
	    //clicking on the link with the linktext
	    //driver.findElement(By.xpath("//a[text() = 'Forgot your password?']")).click();	    
	    driver.findElement(By.linkText("Forgot your password?")).click();
	    
	    Thread.sleep(2000);
	    
	    //filling user details with css selectors
	    driver.findElement(By.cssSelector("input[type = 'text'][placeholder='Name']")).sendKeys("Prakash");
	    driver.findElement(By.cssSelector("input[type = 'text'][placeholder = 'Email']")).sendKeys("Prakash@moresandtechnologies.com");
	    driver.findElement(By.cssSelector("input[type = 'text'][placeholder =  'Phone Number']")).sendKeys("7978670045");
	    driver.findElement(By.cssSelector("input[type = 'text']:nth-child(2)")).clear();  //index in css selector
	    driver.findElement(By.cssSelector("input[type = 'text'][placeholder =  'Phone Number']")).clear();
	    driver.findElement(By.cssSelector("input[type = 'text'][placeholder = 'Email']")).clear();
	    
	    //filling user details with xpath
	    
	    driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys(name);
	    driver.findElement(By.xpath("//input[@type = 'text'][@placeholder = 'Email']")).sendKeys("im7prakash@gmsil.com");
	    driver.findElement(By.xpath("//input[@type = 'text'][3]")).sendKeys("7978670045");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[text() = 'Reset Login']")).click();
	    Thread.sleep(2000);
	    String gettex = driver.findElement(By.xpath("//p[@class = 'infoMsg']")).getText();
	   // String finalte[] = gettex.split("'", 1);
	    System.out.println(gettex);
	    
	    String tex = gettex.split("'")[1];
	    System.out.println(tex);
	    
	    //Parent child traversing using xpath
	    driver.findElement(By.xpath("//form[@action = '#']/input[1]")).clear();
	    driver.findElement(By.xpath("//form[@action = '#'] //input[@placeholder = 'Email']")).clear();
	    
	    //parent childtraversing using Css selector
	    driver.findElement(By.cssSelector("form input:nth-child(5)")).clear();
	    
	    //Generating regular expression in xpath
	    driver.findElement(By.xpath("//button[contains(@class,'go')]")).click();
	    
	    Thread.sleep(2000);
	  //Generating regular expression in css selector NOTE: Make sjure to not give any space for the regularexpression
		   driver.findElement(By.cssSelector("input[id*='User']")).sendKeys(name);
		   driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(tex);
		   driver.findElement(By.xpath("//button[@type = 'submit']")).click();  
		   
		   Thread.sleep(2000);
		   String user = driver.findElement(By.tagName("h2")).getText();
		   Assert.assertEquals("Hello "+name+",", user);
		   System.out.println(user);
		   System.out.println(name);
		   String log = driver.findElement(By.cssSelector("div[class = 'login-container'] p")).getText();
		   
		   System.out.println(log);
		   //logout
		   driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
}

}
