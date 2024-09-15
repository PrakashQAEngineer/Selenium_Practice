import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Explicit_Login 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Login(driver);
		
		
	}
	
	public static void Login(WebDriver driver) throws InterruptedException
	{
		String Countryy = "India";
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String str = driver.findElement(By.xpath("//p[@class = 'text-center text-white']")).getText();
		//picking username
		String Use = str.split("and")[0].trim();
		String username = Use.split("is")[1].trim();
		//System.out.println(username);
		
		//picking password
		String pw = str.split("and")[1].trim();
		String pwd = pw.split("is")[1].trim();
		String password = pwd.substring(0, pwd.length()-1);
		//System.out.println(password);
		
		//passing the username
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys(username);
		
		//passing the passowrd
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value = 'user']")).click();
		//Thread.sleep(10000);
		
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(7));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement wb1 = driver.findElement(By.xpath("//select[@class = 'form-control']"));
		Select sc = new Select(wb1);
		sc.selectByVisibleText("Consultant");
		
		//checking the checkbox
		
		driver.findElement(By.xpath("//input[@id = 'terms']")).click();
		
		//Signing button
		driver.findElement(By.xpath("//input[@id = 'signInBtn']")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class = 'my-4']")));
		
		String home_verify  = driver.findElement(By.xpath("//h1[@class = 'my-4']")).getText();
		Assert.assertEquals(home_verify, "Shop Name");
		
		//selecting all the mobile phones to the cart
		
		List <WebElement> prod = driver.findElements(By.xpath("//div[@class = 'card-footer'] //button[@class = 'btn btn-info']"));
		
		for(int i=0; i<prod.size(); i++)
		{
			prod.get(i).click();
		}
		
		//checking out
		driver.findElement(By.xpath("//a[@class = 'nav-link btn btn-primary']")).click();
		
		String price = driver.findElement(By.xpath("//strong[text() = '₹. 300000']")).getText();
		Assert.assertEquals(price, "₹. 300000");
		
		//checkout button
		driver.findElement(By.xpath("//button[@class = 'btn btn-success']")).click();
		
		//delivery country
		driver.findElement(By.xpath("//input[@id = 'country']")).sendKeys("In");
		
		WebDriverWait cou = new WebDriverWait(driver, Duration.ofSeconds(10));
		cou.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'suggestions']")));
		//Thread.sleep(5000);
		List <WebElement> country = driver.findElements(By.xpath("//div[@class = 'suggestions']"));
		
		for(int i=0;i<country.size();i++)
		{
			String co = country.get(i).getText();
			//System.out.println(co);
			if(co.contains(Countryy))
			{
				driver.findElement(By.xpath("//a[text() = 'India']")).click();
			}
		}
		
		driver.findElement(By.xpath("//label[@for = 'checkbox2']")).click();
		
		//purchase button
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		
		//validation with assertion if the purchase is confirmed or not
		//String succ = driver.findElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).getText();
		// to remove the *
		//String Mssg = (String) succ.substring(1);
		//Assert.assertEquals(succ, "×\r\n"
			//	+ "Success! Thank you! Your order will be delivered in next few weeks :-).");
		
	}

}
