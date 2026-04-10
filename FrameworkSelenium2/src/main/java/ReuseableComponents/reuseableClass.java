package ReuseableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reuseableClass 
{
	WebDriver driver;
	
	public reuseableClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By waitafPrdSelect = By.xpath("//div[@id = 'toast-container']");
	By waitSpinner = By.cssSelector(".ngx-spinner-overlay");
		 
	public void waitAfterPrdSelect()
	{
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.invisibilityOfElementLocated(waitafPrdSelect));
		wt.until(ExpectedConditions.invisibilityOfElementLocated(waitSpinner));
	}

}
