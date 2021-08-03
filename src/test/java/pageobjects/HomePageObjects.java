package pageobjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import initializer.PageInitializer;
import utility.WaitingMethods;



public class HomePageObjects extends PageInitializer {
	//WebDriver driver;
	WaitingMethods waiting = new WaitingMethods(driver);
	
	  Actions actions = new Actions(driver);
	
	@FindBy(xpath = "//h4[text()='From']/..//div/input")
	public WebElement fromTextboxLocator;
	
	@FindBy(xpath = "//h4[text()='To']/..//div/input")
	public WebElement toTextboxLocator;
	
	@FindBy(xpath = "//p[text()='Round trip']/../..")
	public WebElement selectRoundTripLocator;
	
	@FindBy(xpath = "//div[contains(@class, 'flex flex-between flex-middle mt-5 pl-1 pr-1') and contains(@class, 'flex')]/following-sibling::div//button[1]")
	public WebElement departOnLocator;
	
	@FindBy(xpath = "//div[contains(@class, 'flex flex-between flex-middle mt-5 pl-1 pr-1') and contains(@class, 'flex')]/following-sibling::div//button[2]")
	public WebElement returnOnLOcator;
	
	@FindBy(xpath = "//h4[text()='Adults']/../select")
	public WebElement adultsLOcator;
	
	@FindBy(xpath = "//h4[text()='Children']/../select")
	public WebElement childrenLOcator;
	
	@FindBy(xpath = "//button[text()='Search flights']")
	public WebElement searchFlightsLOcator;
	
	@FindBy(xpath = "//button[text()='Book']")
	public WebElement bookButtonLOcator;
	
	@FindBy(xpath = "//a[@data-test-attrib='cleartrip-logo']")
	public WebElement logoLOcator;
	
	@FindBy(xpath = "//div[text()='August 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='1']")
	public WebElement selectRoundTripDateLocator;
	
	
	
	
	//@Step("Verify welcome msg for logged in user")
	public HomePageObjects verifyLogoInHomePage() throws Exception {
		Thread.sleep(5000);
		//waiting.waitTillPageLoads();
		Assert.assertTrue(logoLOcator.isDisplayed(), "Successfully navigated to homepage");
		//log.info("User is successfully logged in");
		return this;
	}
	
	//public HomePageObjects enterFromAndToDetails(String From , String To) {
	public HomePageObjects enterFromAndToDetails() throws InterruptedException {
		waiting.waitForVisibilityOfElement(fromTextboxLocator, 60);
		fromTextboxLocator.clear();
		fromTextboxLocator.sendKeys("Mumbai");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='Mumbai, IN - Chatrapati Shivaji Airport (BOM)']")).click();
		waiting.waitForVisibilityOfElement(toTextboxLocator, 60);
		toTextboxLocator.clear();
		toTextboxLocator.sendKeys("DEL - New Delhi, IN");
		driver.findElement(By.xpath("//p[text()='New Delhi, IN - Indira Gandhi Airport (DEL)']")).click();
		//toTextboxLocator.sendKeys(Keys.ENTER);
		return this;
	}
	
	public HomePageObjects selectRoundTripDetails() throws InterruptedException {
       //  Actions actions = new Actions(driver);
 		actions.moveToElement(selectRoundTripLocator).build().perform();       
		//waiting.waitForVisibilityOfElement(selectRoundTripLocator, 60);
		selectRoundTripLocator.click();
		Thread.sleep(3000);
		return this;
	}
	
	public HomePageObjects selectDepartAndReturnOnDetails() throws InterruptedException {
		
		WebElement DepartsOn = driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]/button[1]"));
        DepartsOn.click();
        
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        
        WebElement fromDate = driver.findElement(By.xpath("//div[text()='August 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='4']"));
       // fromDate.click();
       // fromDate.sendKeys(Keys.ENTER);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", fromDate);
        
        Thread.sleep(3000);
        
      // WebElement toDate = driver.findElement(By.xpath("//div[text()='September 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='6']"));
       // toDate.click();
        WebElement toDate = driver.findElement(By.xpath("//div[text()='August 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='6']"));
        
        jse.executeScript("arguments[0].click()", toDate);
        
        Thread.sleep(3000);
		
		
		/*
		 * waiting.waitForVisibilityOfElement(departOnLocator, 60);
		 * departOnLocator.click(); Thread.sleep(1000);
		 * 
		 * driver.findElement(By.linkText(
		 * "//div[@class='DayPicker-Week'][2]//div[text()='4']")).click();
		 * //actions.moveToElement(selectRoundTripDateLocator).build().perform();
		 * //driver.findElement(By.
		 * linkText("//div[text()='August 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='1']"
		 * )).click(); //new WebDriverWait(driver, 10).until(ExpectedConditions.
		 * invisibilityOf("//div[text()='August 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='4']"
		 * ))); Thread.sleep(1000); waiting.waitForVisibilityOfElement(returnOnLOcator,
		 * 60); returnOnLOcator.click(); Thread.sleep(3000);
		 * driver.findElement(By.linkText(
		 * "//div[@class='DayPicker-Week'][2]//div[text()='4']")).click();
		 */
	//	driver.findElement(By.xpath("//div[text()='September 2021']/../following-sibling::div[@class='DayPicker-Body']//div[text()='6']")).click();
		return this;
	}
	
	public HomePageObjects selectAdults() {
		Select select = new Select(adultsLOcator);
		select.selectByVisibleText("2");
		return this;
	}
	
	public HomePageObjects selectChild() {
		Select select = new Select(childrenLOcator);
		select.selectByVisibleText("1");
		return this;
	}
	
	
    public HomePageObjects clickOnSearchFlightsButton() throws Exception 
	  { 
		  logger = Logger.getLogger("click on search flight button"); Thread.sleep(2000);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchFlightsLOcator);
	  logger.info("clicked on search flight button"); 
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  return this; 
	  }
	 
    public HomePageObjects clickOnBookButton() throws Exception 
	  { 
		  logger = Logger.getLogger("click on Book button"); Thread.sleep(2000);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookButtonLOcator);
	  logger.info("clicked on Book button"); 
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	  Thread.sleep(3000);
	  return this; 
	  }
	
	
}
