import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Prakash Singh Rajput");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		String ale1 = driver.switchTo().alert().getText();
		System.out.println(ale1);
		driver.switchTo().alert().accept();
		
		//cancel the alert button
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Jyoti Prakash");
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		String stt = driver.switchTo().alert().getText();
		System.out.println(stt);
		driver.switchTo().alert().dismiss();
	}

}
