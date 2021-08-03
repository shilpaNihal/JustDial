package mainclass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class MainClassWebDriver {
//	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	public static WebDriver driver  = new ChromeDriver();
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public Logger logger = Logger.getLogger(MainClassWebDriver.class);
	
	@BeforeClass
	public void intialSetup() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Unilog\\Personal\\MyPracice\\jar\\chromedriver.exe");
	//	WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/flights/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//new WaitingMethods(getDriver()).waitTillPageLoads();
		Thread.sleep(3000);
		//this.driver=driver;
		new WebDriverWait(driver, 60)
		.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
	}
	
	@AfterClass
	public void closeBrowser() {
		//driver.close();
		//getDriver().quit();
		logger.info("browser closed");
	}

	/*
	 * public WebDriver getDriver() { return driver; }
	 * 
	 * public void setDriver(WebDriver driver) { this.driver = driver; }
	 */
}
