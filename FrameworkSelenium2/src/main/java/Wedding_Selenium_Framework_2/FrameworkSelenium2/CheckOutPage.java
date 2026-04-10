package Wedding_Selenium_Framework_2.FrameworkSelenium2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReuseableComponents.reuseableClass;

public class CheckOutPage extends reuseableClass
{
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder = 'Select Country']")
	WebElement findCountry;
	
	@FindBy(css = ".list-group-item")
	List<WebElement> MultipleCountry;
	
	@FindBy(css = ".action__submit")
	WebElement PlaceOrder;
	
	@FindBy(tagName = "h1")
	WebElement tg1;
	
	
	
	public void selectCountry(String countryy)
	{
		findCountry.sendKeys(countryy);
		for(int i=0;i<MultipleCountry.size();i++)
		{
			String text = MultipleCountry.get(i).getText();
			System.out.println(text);
			
			if(text.equalsIgnoreCase(countryy))
			{
				MultipleCountry.get(i).click();
			}
			
			
		}
	}
	
	public void placeOrder()
	{
		PlaceOrder.click();
	}
	
	public String  confirmationMssg()
	{
		return tg1.getText();
	}
	

}
