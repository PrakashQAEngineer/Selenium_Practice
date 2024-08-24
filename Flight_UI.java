import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Flight_UI 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//selecting the data form the static dropdown---Currency part
		WebElement wb1 = driver.findElement(By.xpath("//select[contains(@id,'DropDownListCurrency')]"));
		Select sc = new Select(wb1);
		sc.selectByVisibleText("AED");
		
		//Selecting the no of pax using the loop for the new latest dropdown
		
		driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
		
		//for Adult
		for(int i=0;i<2;i++)
		{
			driver.findElement(By.xpath("//span[@id = 'hrefIncAdt']")).click();
		}
		
		//for Child selection
		for(int j=0;j<=2;j++)
		{
			driver.findElement(By.xpath("//span[@id = 'hrefIncChd']")).click();
		}
		
		//for infant selection
		for(int k=0;k<=1; k++)
		{
			driver.findElement(By.xpath("//span[@id = 'hrefIncInf']")).click();
		}
		driver.findElement(By.xpath("//input[@id = 'btnclosepaxoption']")).click();
		
		//select the country from auto suggest dropwn
		driver.findElement(By.xpath("//input[@id = 'autosuggest']")).sendKeys("In");
		
		List<WebElement> li = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']"));
		
		for(WebElement lis: li)
		{
			String str = lis.getText();
			System.out.println(str);
			
			if(str.equalsIgnoreCase("China"))
			{
				driver.findElement(By.xpath("//a[text() = 'China']")).click();
				break;
			}
		}
		// selection of the Deperature city
		
		driver.findElement(By.xpath("//input[contains(@id,'originStation1_CTXT')]")).click();
		driver.findElement(By.xpath("//a[text() = ' Jharsuguda (JRG)']")).click();
		
		//selection of the arrival city
		
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1')] //a[text() = ' Hyderabad (HYD)']")).click();
		
	}

}
