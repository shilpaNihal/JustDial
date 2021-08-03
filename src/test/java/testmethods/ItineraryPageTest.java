package testmethods;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import initializer.PageInitializer;

public class ItineraryPageTest extends PageInitializer{
	
	@Test(groups = { "Itinerary Page test", "assignment", })
	public void enterItineraryPageDetails() throws Exception {
		Thread.sleep(1500);
		String currentHandle= driver.getWindowHandle();
		
		  Set<String> allTabs;
		  Iterator<String> itr; 
		  String main; 
		  Thread.sleep(3000);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  allTabs =
		  driver.getWindowHandles(); 
		  itr = allTabs.iterator();
		  main=itr.next(); 
		  String window2=itr.next(); driver.switchTo().window(window2); 
		  Thread.sleep(2000);
		 
		ItineraryPage()
		.selectStandardFee()
		.addTravelInsurance()
		.clickContinueButton()
		.chooseSeats()
		.chooseMeals()
		.chooseBaggage()
		.clickContinueOnAddOnPage()
		.addContactDetails()
		.clickContinueOnContactPage()
		.addTravellerDetails()
		.clickContinueToPaymentPage();
		
		
	}
	
}
