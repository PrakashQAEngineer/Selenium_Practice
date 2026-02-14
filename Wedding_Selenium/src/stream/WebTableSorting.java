package stream;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//span[text() = 'Veg/fruit name']")).click();
		
		List<WebElement> vege = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		List<String> original = vege.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(original);
		
		List<String> sort = original.stream().sorted().collect(Collectors.toList());
		System.out.println("After sorting: "+sort);
		Assert.assertEquals(original, sort);
	}

}
