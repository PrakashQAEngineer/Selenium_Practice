import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkbox_size 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
    //driver.findElement(By.cssSelector("input[id* = 'friendsandfamily']")).isSelected();
		int siz = driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).size();
		Assert.assertEquals(siz, 6);
		System.out.println("The number of checkboxes are: "+siz);
		
		boolean te = driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected();
		System.out.println(te);
		Assert.assertEquals(te, false);
    driver.findElement(By.cssSelector("input[id*='IndArm']")).click();	
    boolean tee = driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected();
	System.out.println(tee);
	Assert.assertEquals(tee, true);

		
	}

}
