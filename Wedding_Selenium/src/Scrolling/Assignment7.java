package Scrolling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 
{
	//in this will print no of row, col and 2nd row data
	
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		webtableRow(driver);
		webtableCol(driver);
		webtableRowData(driver);
	}
	
	public static void webtableRow(WebDriver driver)
	{
		List <WebElement> row = driver.findElements(By.cssSelector(".table-display tbody tr"));
		System.out.println("no of rows are: "+row.size());
	}
	
	public static void webtableCol(WebDriver driver)
	{
		List<WebElement> col = driver.findElements(By.cssSelector(".table-display tbody tr th"));
		System.out.println("now of col are: "+col.size());
	}
	
	public static void webtableRowData(WebDriver driver)
	{
		String row2data = driver.findElement(By.xpath("//table[@class = 'table-display']/tbody/tr[3]")).getText();
		System.out.println(row2data);
	}

}
