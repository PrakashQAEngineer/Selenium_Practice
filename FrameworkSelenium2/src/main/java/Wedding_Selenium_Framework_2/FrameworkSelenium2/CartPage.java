package Wedding_Selenium_Framework_2.FrameworkSelenium2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReuseableComponents.reuseableClass;

public class CartPage extends reuseableClass
{
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		 super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@routerlink = '/dashboard/cart']")
	WebElement cartClick;
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]") 
	WebElement cartCheckout;
	
	@FindBy(css = ".w-40")
    WebElement moveView;
	
	
	public void clickOnCart()
	{
		Actions act = new Actions(driver);
		act.moveToElement(moveView).build().perform();
		waitAfterPrdSelect();
		cartClick.click();
		
	}
	
	public CheckOutPage clickCheckOut() 
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // ✅ scroll to checkout button
        js.executeScript("arguments[0].scrollIntoView(true);", cartCheckout);
        
		cartCheckout.click();
		
		CheckOutPage cop = new CheckOutPage(driver);
		return cop;
	}
}
