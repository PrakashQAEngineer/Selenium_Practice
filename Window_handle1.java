package Window_Handle;

import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Window_handle1 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(4));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'blinkingText']")));
		
		driver.findElement(By.xpath("//a[@class = 'blinkingText']")).click();
		Set <String> win = driver.getWindowHandles();  //we are getting here parent and child window;
		java.util.Iterator<String> it =  win.iterator();
		String parent = it.next(); // getting the Parnet window id from variable
		String child  = it.next(); // getting the childid window from variable
		
		driver.switchTo().window(child);
		String getst= driver.findElement(By.xpath("//p[@class = 'im-para red']")).getText();
		Assert.assertEquals(getst, "Please email us at mentor@rahulshettyacademy.com with below template to receive response"); // checking if we are on the child page or not
		
		String newtex = getst.split("with")[0].split("at")[1].trim();
		//System.out.println(newtex);
		
		driver.switchTo().window(parent); // switching back the focus to the parent window
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(newtex);
	}

}
