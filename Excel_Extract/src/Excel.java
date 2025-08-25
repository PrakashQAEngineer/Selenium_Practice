import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    WebDriver driver;
    FileWriter reportWriter;

    @BeforeClass
    public void setup() throws IOException {
        // Create HTML Report File
        reportWriter = new FileWriter("UrlReport.html");
        reportWriter.write("<html><head><title>URL Test Report</title></head><body>");
        reportWriter.write("<h2>URL Opening Test Report</h2>");
        reportWriter.write("<table border='1' cellpadding='5' cellspacing='0'>");
        reportWriter.write("<tr><th>URL</th><th>Status</th><th>Page Title</th></tr>");
    }

    @Test
    public void openUrlsFromExcel() throws IOException, InterruptedException {
        // Load Excel File
        FileInputStream fis = new FileInputStream("C:\\links\\book.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // First sheet

        int tabCounter = 0;
        int batchSize = 30; // 30 tabs per browser

        // Loop through all rows
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(0);
                if (cell != null) {
                    String url = cell.getStringCellValue();
                    String status = "❌ Failed";
                    String title = "N/A";

                    // Open new browser after every 30 tabs
                    if (tabCounter % batchSize == 0) {
                        if (driver != null) {
                            driver.quit();
                        }
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                    }

                    try {
                        // Open in new tab
                        ((JavascriptExecutor) driver).executeScript("window.open('" + url + "','_blank');");

                        // Switch to new tab
                        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
                        driver.switchTo().window(tabs.get(tabs.size() - 1));

                        Thread.sleep(2000); // wait for page load

                        title = driver.getTitle();
                        status = "✅ Success";
                    } catch (Exception e) {
                        status = "❌ Failed (" + e.getMessage() + ")";
                    }

                    // Write result into HTML table
                    reportWriter.write("<tr>");
                    reportWriter.write("<td>" + url + "</td>");
                    reportWriter.write("<td>" + status + "</td>");
                    reportWriter.write("<td>" + title + "</td>");
                    reportWriter.write("</tr>");

                    tabCounter++;
                }
            }
        }

        workbook.close();
        fis.close();
    }

    @AfterClass
    public void tearDown() throws IOException {
        if (driver != null) {
            driver.quit();
        }
        // Close HTML tags
        reportWriter.write("</table></body></html>");
        reportWriter.close();

        System.out.println("✅ HTML Report generated: UrlReport.html");
    }
}
