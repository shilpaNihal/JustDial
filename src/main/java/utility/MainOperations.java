package utility;


import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import mainclass.MainClassWebDriver;

public class MainOperations extends MainClassWebDriver {

	Logger log = Logger.getLogger(MainOperations.class);


	
	public void waitTillPageLoads() {
		new WebDriverWait(driver, 60)
				.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
	}

	
	public MainOperations selectElementByIndex(WebElement webElement, int index) {
		Select select = new Select(webElement);
		select.selectByIndex(index);
		log.info("Select using Webelement index :" + index);
		return this;
	}
	
	public MainOperations selectElementByVisibleText(WebElement webElement, String text) {
		Select select = new Select(webElement);
		select.selectByVisibleText(text);
		log.info("Select using Visible text :" + text);
		return this;
	}
	
	public MainOperations sendKeys(WebElement webElement, String text) {
		webElement.sendKeys(text.trim());
		log.info("Enter text :" + text.trim());
		return this;
	}

	// new method switching control from parent to new tab
		
		public MainOperations SwitchToNewTab(int tab) throws Exception {
			ArrayList<String> Newtabs = new ArrayList<String>(driver.getWindowHandles());
			log.info("Available tabs :" + Newtabs);
			driver.switchTo().window(Newtabs.get(tab));
			return this;
		}

		// new method switching back control to parent tab
		
		public MainOperations SwitchBackToParentTab() throws Exception {
			ArrayList<String> Newtabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(Newtabs.get(0));
			return this;
		}
		
		public MainOperations moveToElement(By byLocator) {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(getDriver().findElement(byLocator)).build().perform();
			log.info("Moved to webelement");
			return this;
		}


		public String getTitle() {
			log.info("Get page title");
			return getDriver().getTitle();

		}
	

}
