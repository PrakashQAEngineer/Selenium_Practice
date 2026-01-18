package Alert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alert1 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Prakash Singh Rajput");
		driver.findElement(By.xpath("//input[@id = 'alertbtn']")).click();
		String alttxt = driver.switchTo().alert().getText();
		System.out.println(alttxt);
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Prakash Singh Rajput");
		
		driver.findElement(By.xpath("//input[@id = 'confirmbtn']")).click();
		String altxt2 = driver.switchTo().alert().getText();
		System.out.println(altxt2);
		driver.switchTo().alert().dismiss();

		
		
	}

}
