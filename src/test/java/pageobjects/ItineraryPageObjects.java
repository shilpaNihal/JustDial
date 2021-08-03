package pageobjects;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import initializer.PageInitializer;
import utility.WaitingMethods;

public class ItineraryPageObjects extends PageInitializer {
	//WebDriver driver;
	
	WaitingMethods waiting = new WaitingMethods(driver);

	@FindBy(xpath = "//h3[text()='Standard fare']/../div[@class='flex']")
	public WebElement standardFeeLocator;
	
	@FindBy(xpath = "//h3[text()='Protect your trip with travel insurance']/../..//div/button")
	public WebElement addTravelInsuranceLocator;
	
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement continueLocator;
	
	@FindBy(xpath = "//button[text()='Select seats']")
	public WebElement selectSeatsLocator;
	
	@FindBy(xpath = "//div[text()='Onward']/..//span[normalize-space(text())='BOM']")
	public WebElement onwardLocator;
	
	@FindBy(xpath = "//div[@data-testid='51']")
	public WebElement chooseSeatLocator;
		
	@FindBy(xpath = "//div[text()='Onward']/..//span[normalize-space(text())='DEL']")
	public WebElement returnLocator;
	
	@FindBy(xpath = "//button[text()='Done']")
	public WebElement clickDoneLocator;
	
	@FindBy(xpath = "//span[text()='Save and Exit']")
	public WebElement saveAndExitLocator;
	
	@FindBy(xpath = "//button[text()='View menu']")
	public WebElement addMealLocator;
	
	@FindBy(xpath = "//button[text()='View baggage options']")
	public WebElement viewBaggageLocator;
	
	//@FindBy(css = "svg[data-testid='/incrementVeg Diabetic Meal']")
	@FindBy(xpath = "//*[local-name()='svg' and @data-testid='incrementBhel - Phudina (Jain)']")
	private WebElement selectMealLocator;
	
	@FindBy(xpath = "//*[local-name()='svg' and @data-testid='increment5 KG']")
	private WebElement selectBaggageLocator;
	
	@FindBy(xpath = "//div[@class='c-pointer']/following-sibling::div//div/button[text()='Continue']")
	private WebElement clickContinueOnAddonLocator;
	
	@FindBy(xpath = "//input[@data-testid='mobileNumber']")
	private WebElement enterMobileNumberLocator;
	
	@FindBy(xpath = "//input[@data-testid='email']")
	private WebElement enterEmailAddressLocator;
	
	@FindBy(xpath = "//input[@data-testid='password']")
	private WebElement enterPasswordLocator;
	
	@FindBy(xpath = "//div[@class='']/following-sibling::div//div/button[text()='Continue']")
	private WebElement continueOnAddContactLocator;
	
	@FindBy(xpath = "//h4[text()='Adult 1']/following-sibling::div[@class='row']//input[@data-testid='firstName']")
	private WebElement enterTravellerAdult1FirstNameLocator;
	
	@FindBy(xpath = "//h4[text()='Adult 1']/following-sibling::div[@class='row']//input[@data-testid='lastName']")
	private WebElement enterTravellerAdult1SecondNameLocator;
	
	@FindBy(xpath = "//h4[text()='Adult 1']/following-sibling::div[@class='row']//button/div[text()='Gender']")
	private WebElement enterTravellerAdult1GenderLocator;
	
	@FindBy(xpath = "//h4[text()='Adult 1']/following-sibling::div[@class='row']//div[@class='col-4']//li[text()='Male']")
	private WebElement selectAdult1GenderLocator;
	
	@FindBy(xpath = "//h4[text()='Adult 2']/following-sibling::div[@class='row']//input[@data-testid='firstName']")
	private WebElement enterTravellerAdult2FirstNameLocator;
	
	@FindBy(xpath = "//h4[text()='Adult 2']/following-sibling::div[@class='row']//input[@data-testid='lastName']")
	private WebElement enterTravellerAdult2SecondNameLocator;
	
	@FindBy(xpath = "//h4[text()='Adult 2']/following-sibling::div[@class='row']//button/div[text()='Gender']")
	private WebElement enterTravellerAdult2GenderLocator;
	
	@FindBy(xpath = "//h4[text()='Adult 2']/following-sibling::div[@class='row']//div[@class='col-4']//li[text()='Male']")
	private WebElement selectAdult2GenderLocator;
	
	@FindBy(xpath = "//h4[text()='Child 1']/following-sibling::div[@class='row']//input[@data-testid='firstName']")
	private WebElement enterTravellerChild1FirstNameLocator;
	
	@FindBy(xpath = "//h4[text()='Child 1']/following-sibling::div[@class='row']//input[@data-testid='lastName']")
	private WebElement enterTravellerChild1SecondNameLocator;
	
	@FindBy(xpath = "//h4[text()='Child 1']/following-sibling::div[@class='row']//button/div[text()='Gender']")
	private WebElement enterTravellerChild1GenderLocator;
	
	@FindBy(xpath = "//h4[text()='Child 1']/following-sibling::div[@class='row']//div[@class='col-4']//li[text()='Male']")
	private WebElement selectChild1GenderLocator;
	
	@FindBy(xpath = "//h4[text()='Child 1']/following-sibling::div[@class='row'][2]//input")
	private WebElement enterDateOfBirthLocator;
	
	@FindBy(xpath = "//button[text()='Continue to payment']")
	private WebElement continueToPaymentLocator;
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public ItineraryPageObjects verifySearchTextInPLP(String[] searchText) throws InterruptedException {
		Thread.sleep(1500);
		Set<String> allTabs;
		Iterator<String> itr;
		String main;
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		allTabs = driver.getWindowHandles();
		itr = allTabs.iterator();
		main=itr.next();
		String PLP=itr.next();
		driver.switchTo().window(PLP);
	//	log.info("Switched to PLP tab");
		WebElement searchResult = driver.findElement(By.xpath("//div[@class='searchResults']/p"));
		// actions.moveToElement(searchResult).build().perform();
		Assert.assertTrue(searchResult.getText().contains(searchText[0]), "Did not navigate to respective search text");
	//	log.info("Verified searched text in PLP :"+searchText[0]);
		driver.close();
		driver.switchTo().window(main);
		return this;
	}
	
	public ItineraryPageObjects selectStandardFee() throws InterruptedException  {
		waiting.waitForVisibilityOfElement(standardFeeLocator, 6);
		standardFeeLocator.click();
		return this;
	}
	
	public ItineraryPageObjects addTravelInsurance() throws InterruptedException  {
		waiting.waitForVisibilityOfElement(addTravelInsuranceLocator, 6);
		jse.executeScript("arguments[0].click()", addTravelInsuranceLocator);
		Thread.sleep(3000);
		//addTravelInsuranceLocator.click();
		return this;
	}
	
	public ItineraryPageObjects clickContinueButton() throws InterruptedException  {
		waiting.waitForVisibilityOfElement(continueLocator, 6);
		jse.executeScript("arguments[0].click()", continueLocator);
		//continueLocator.click();
		Thread.sleep(1000);
		return this;
	}
	
	public ItineraryPageObjects chooseSeats() throws InterruptedException  {
		waiting.waitForVisibilityOfElement(selectSeatsLocator, 6);
		jse.executeScript("arguments[0].click()", selectSeatsLocator);
		//selectSeatsLocator.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		waiting.waitForVisibilityOfElement(onwardLocator, 6);
		jse.executeScript("arguments[0].click()", onwardLocator);
		//onwardLocator.click();
		driver.findElement(By.xpath("//div[@data-testid='31']")).click();
		driver.findElement(By.xpath("//div[@data-testid='41']")).click();
		driver.findElement(By.xpath("//div[@data-testid='51']")).click();
		waiting.waitForVisibilityOfElement(returnLocator, 6);
		returnLocator.click();
		driver.findElement(By.xpath("//div[@data-testid='21']")).click();
		driver.findElement(By.xpath("//div[@data-testid='11']")).click();
		driver.findElement(By.xpath("//div[@data-testid='01']")).click();
		waiting.waitForVisibilityOfElement(clickDoneLocator, 6);
		jse.executeScript("arguments[0].click()", clickDoneLocator);
		Thread.sleep(2000);
		waiting.waitForVisibilityOfElement(saveAndExitLocator, 6);
		saveAndExitLocator.click();
		return this;
	}
	
	public ItineraryPageObjects chooseMeals() throws InterruptedException  {
		waiting.waitForVisibilityOfElement(addMealLocator, 6);
		jse.executeScript("arguments[0].click()", addMealLocator);
		//addMealLocator.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		waiting.waitForVisibilityOfElement(selectMealLocator, 6);
		//jse.executeScript("arguments[0].click()", selectMealLocator);
		selectMealLocator.click();
	
		waiting.waitForVisibilityOfElement(clickDoneLocator, 6);
		clickDoneLocator.click();
		waiting.waitForVisibilityOfElement(saveAndExitLocator, 6);
		saveAndExitLocator.click();
		return this;
	}
	
	public ItineraryPageObjects chooseBaggage() throws InterruptedException  {
		waiting.waitForVisibilityOfElement(viewBaggageLocator, 6);
		viewBaggageLocator.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		waiting.waitForVisibilityOfElement(selectBaggageLocator, 6);
		selectBaggageLocator.click();
	
		waiting.waitForVisibilityOfElement(clickDoneLocator, 6);
		clickDoneLocator.click();
		waiting.waitForVisibilityOfElement(saveAndExitLocator, 6);
		saveAndExitLocator.click();
		return this;
	}
	
	public ItineraryPageObjects clickContinueOnAddOnPage()   {
		waiting.waitForVisibilityOfElement(clickContinueOnAddonLocator, 6);
		jse.executeScript("arguments[0].click()", clickContinueOnAddonLocator);
		//clickContinueOnAddonLocator.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this;
	}
	
	public ItineraryPageObjects addContactDetails()   {
		waiting.waitForVisibilityOfElement(enterMobileNumberLocator, 6);
		enterMobileNumberLocator.clear();
		enterMobileNumberLocator.sendKeys("6361586393");
		enterEmailAddressLocator.clear();
		enterEmailAddressLocator.sendKeys("shilpaprasad.ds@gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		waiting.waitForVisibilityOfElement(enterMobileNumberLocator, 6);
		enterMobileNumberLocator.clear();
		return this;
	}

	public ItineraryPageObjects clickContinueOnContactPage()   {
		waiting.waitForVisibilityOfElement(continueOnAddContactLocator, 6);
		jse.executeScript("arguments[0].click()", continueOnAddContactLocator);
		//continueOnAddContactLocator.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this;
	}
	
	public ItineraryPageObjects addTravellerDetails()   {
		waiting.waitForVisibilityOfElement(enterTravellerAdult1FirstNameLocator, 6);
		enterTravellerAdult1FirstNameLocator.clear();
		enterTravellerAdult1FirstNameLocator.sendKeys("Vinu");
		enterTravellerAdult1SecondNameLocator.clear();
		enterTravellerAdult1SecondNameLocator.sendKeys("dsouza");
		waiting.waitForVisibilityOfElement(enterTravellerAdult1GenderLocator, 6);
		enterTravellerAdult1GenderLocator.click(); 
		selectAdult1GenderLocator.click(); 
		
		
		waiting.waitForVisibilityOfElement(enterTravellerAdult1FirstNameLocator, 6);
		enterTravellerAdult2FirstNameLocator.clear();
		enterTravellerAdult2FirstNameLocator.sendKeys("stepha");
		enterTravellerAdult2SecondNameLocator.clear();
		enterTravellerAdult2SecondNameLocator.sendKeys("dsouza");
		waiting.waitForVisibilityOfElement(enterTravellerAdult2GenderLocator, 6);
		enterTravellerAdult2GenderLocator.click(); 
		selectAdult2GenderLocator.click(); 
		
		waiting.waitForVisibilityOfElement(enterTravellerAdult1FirstNameLocator, 6);
		enterTravellerChild1FirstNameLocator.clear();
		enterTravellerChild1FirstNameLocator.sendKeys("Nihal");
		enterTravellerChild1SecondNameLocator.clear();
		enterTravellerChild1SecondNameLocator.sendKeys("dsouza");
		waiting.waitForVisibilityOfElement(enterTravellerChild1GenderLocator, 6);
		enterTravellerChild1GenderLocator.click(); 
		selectChild1GenderLocator.click(); 
		
		waiting.waitForVisibilityOfElement(enterDateOfBirthLocator, 6);
		enterDateOfBirthLocator.clear();
		enterDateOfBirthLocator.sendKeys("01 / 11 / 1989");
		
		return this;
	}
	
	public ItineraryPageObjects clickContinueToPaymentPage()   {
		waiting.waitForVisibilityOfElement(continueToPaymentLocator, 6);
		jse.executeScript("arguments[0].click()", continueToPaymentLocator);
		//continueToPaymentLocator.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this;
	}
	
	
}
