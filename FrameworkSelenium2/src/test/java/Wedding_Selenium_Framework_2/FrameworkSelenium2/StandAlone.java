package Wedding_Selenium_Framework_2.FrameworkSelenium2;


import java.io.IOException;

import java.util.Arrays;
import java.util.List;



import org.testng.Assert;
import org.testng.annotations.Test;

import Wedding_Selenium_Framework_2.FrameworkSelenium2.TestComponents.BaseTest;

public class StandAlone extends BaseTest
{
	@Test
	   public void submitOrder() throws IOException
	{
		 List<String> prd = Arrays.asList("IPHONE 13 PRO","ADIDAS ORIGINAL");
		 String countryy = "India";
		 
		 	  
		 LandingPage lp = goTo();
		  
		
		ProductSelection pc = lp.loginApplication();
		
		CartPage cp = pc.getProduct(prd);
		cp.clickOnCart();
		
		CheckOutPage cop = cp.clickCheckOut();
		cop.selectCountry(countryy);
		cop.placeOrder();
		
		
		String astmssg =  cop.confirmationMssg();
		Assert.assertEquals(astmssg, "THANKYOU FOR THE ORDER.");
		
		
		
	}
	

}
