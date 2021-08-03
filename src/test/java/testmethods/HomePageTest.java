package testmethods;

import org.testng.annotations.Test;

import initializer.PageInitializer;

public class HomePageTest extends PageInitializer{
	
	
	@Test(groups = { "Home Page test", "assignment", })
	public void searchFlightDetails() throws Exception {
		
		homePage()
		//.verifyLogoInHomePage()
		.enterFromAndToDetails()
		.selectRoundTripDetails()
		  .selectDepartAndReturnOnDetails() 
		  .selectAdults() .selectChild()
		  .clickOnSearchFlightsButton() 
		  .clickOnBookButton();
		 
	}
}
