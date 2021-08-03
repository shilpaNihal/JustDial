package testmethods;
 

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

 

public class ClearTrip {
    
    WebDriver driver;
    @Test
    public void getBankTitle() throws InterruptedException {
    
    try {
      //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ujwalrajshekar\\Desktop\\Exe2\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/flights/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//p[contains(text(),'Round trip')]")).click();
        
        Thread.sleep(5000);
        
        
        WebElement DepartsOn = driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]/button[1]"));
        DepartsOn.click();
        
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        
        WebElement fromDate = driver.findElement(By.xpath("//div[text()='August 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='13']"));
       // fromDate.sendKeys(Keys.ENTER);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", fromDate);
        
        Thread.sleep(3000);
        
        WebElement toDate = driver.findElement(By.xpath("//div[text()='September 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='6']"));
       // toDate.click();
      //  JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", toDate);
        
        Thread.sleep(3000);
        
    } finally {
        driver.quit();
    }
    }

 

}