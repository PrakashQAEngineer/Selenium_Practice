package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink 
{
    public static void main(String[] args) throws IOException 
    {
        // Set up ChromeDriver
       

        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Navigate to the target website
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        // Print total number of links found
        System.out.println("Total Link Size: " + links.size());
        
        // Get the base URL of the current page (to handle relative URLs)
        String baseUrl = driver.getCurrentUrl();
        
        // Iterate through each link
        for (int i = 0; i < links.size(); i++) 
        {
            // Get each link element
            WebElement element = links.get(i);
            
            String url = element.getAttribute("href");
            
            // Skip if the URL is empty or null
            if (url == null || url.isEmpty()) 
            {
                System.out.println("Skipping empty link...");
                continue;
            }
            
            // Handle relative URLs by resolving them to absolute URLs
            if (!url.startsWith("http://") && !url.startsWith("https://")) 
            {
                url = baseUrl + url;  // Resolve relative URL to absolute
            }
            
            try 
            {
                // Create URL object to check the link
                URL link = new URL(url);
                HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
                httpConn.connect();
                
                // Get the response code
                int code = httpConn.getResponseCode();
                
                // Check if the link is valid or broken
                if (code >= 400) 
                {
                    System.out.println("Broken Link: " + url + " Response Code: " + code);
                } 
                else 
                {
                    System.out.println("Valid Link: " + url + " Response Code: " + code);
                }
            } 
            catch (MalformedURLException e) 
            {
                System.out.println("Malformed URL: " + url + " Exception: " + e.getMessage());
            }
            catch (IOException e) 
            {
                System.out.println("Error with link: " + url + " Exception: " + e.getMessage());
            }
        }

        // Final message
        System.out.println();
        System.out.println("All Links Checked");
        
        // Close the browser
        driver.quit(); 
    }
}