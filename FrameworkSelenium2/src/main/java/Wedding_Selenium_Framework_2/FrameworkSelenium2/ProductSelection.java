package Wedding_Selenium_Framework_2.FrameworkSelenium2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReuseableComponents.reuseableClass;

public class ProductSelection extends reuseableClass
{
  WebDriver driver;
  public ProductSelection(WebDriver driver)
  {
	  super(driver);
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
    @FindBy(css=".mb-3")
    List<WebElement> productSelection;
    By addToCart = By.xpath(".//button[@class = 'btn w-10 rounded']");
    
    
    
    public CartPage getProduct(List<String> prd)
    {
    	
    	for(WebElement prod: productSelection)
    	{
    		String getlist = prod.findElement(By.tagName("b")).getText();
    		//System.out.println(getlist);
    		if(prd.contains(getlist))
    		{
    			prod.findElement(addToCart).click();
    			waitAfterPrdSelect();	
    			
    			
    		}
       }
    	CartPage cp = new CartPage(driver);
		return cp;
    }
}
