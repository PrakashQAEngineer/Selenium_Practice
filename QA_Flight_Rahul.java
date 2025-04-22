import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QA_Flight_Rahul 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//selecting India from the Auto-suggestive dropdown
		driver.findElement(By.xpath("//input[@id = 'autosuggest']")).sendKeys("Ind");
		List <WebElement> wb1 = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']"));
		
		for(int i=0;i<wb1.size();i++)
		{
			String country = wb1.get(i).getText();
			
			if(country.equalsIgnoreCase("India"))
			{
				driver.findElement(By.xpath("//a[text() = 'India']")).click();
			}
		}
		//Selecting the Round Trip and thenn one way Trip
		
		driver.findElement(By.xpath("//input[contains(@id,'Trip_1')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'Trip_0')]")).click();
		
		//Selecting the Departre and Arrival city
		
		driver.findElement(By.xpath("//input[contains(@id,'originStation1')]")).click();
		driver.findElement(By.xpath("//a[text() = ' Jharsuguda (JRG)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1')] //a[@text='Port Blair (IXZ)']")).click();
		
		//select the current date from calander
		
		//driver.findElement(By.xpath("//a[@class = 'ui-state-default ui-state-active']")).click();
		driver.findElement(By.className("ui-state-active")).click();
		
		driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
		//select 3 Adult
		for(int i=0;i<=1;i++)
		{
			driver.findElement(By.xpath("//span[@id = 'hrefIncAdt']")).click();
		}
		//select 3 child
		for(int j=0;j<=2;j++)
		{
			driver.findElement(By.xpath("//span[@id = 'hrefIncChd']")).click();
		}
		driver.findElement(By.xpath("//input[@id = 'btnclosepaxoption']")).click();
		
       //select the currency dropdown
		
		WebElement wbb = driver.findElement(By.xpath("//select[contains(@id,'DropDownListCurrency')]"));
		Select sc = new Select(wbb);
				sc.selectByVisibleText("USD");
				
				//click on the search button
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@type = 'submit']")).click();
	}

}
