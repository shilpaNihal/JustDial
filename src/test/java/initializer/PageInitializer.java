package initializer;

import org.openqa.selenium.support.PageFactory;

import mainclass.MainClassWebDriver;
import pageobjects.HomePageObjects;
import pageobjects.ItineraryPageObjects;


public class PageInitializer extends MainClassWebDriver {

	

	public HomePageObjects homePage() {
		HomePageObjects homePage = PageFactory.initElements(driver, HomePageObjects.class);
		return homePage;
	}

	public ItineraryPageObjects ItineraryPage() {
		ItineraryPageObjects ItineraryPage = PageFactory.initElements(driver, ItineraryPageObjects.class);
		return ItineraryPage;
	}
	
	
	

}
