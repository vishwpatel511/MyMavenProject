package tests;


import org.testng.annotations.Test;

import pages.SpiceJetFormPage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DepartureArrivalTest {
	
	SpiceJetFormPage page = new SpiceJetFormPage();
	
//  @Test
  public void LeavingBothEmptyTest() {
	
	  page.getDriver().findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	  Assert.assertEquals(page.getDriver().findElement(By.xpath("//div[@id='view-origin-station']")).getText(), "Select Departure City");
	  Assert.assertEquals(page.getDriver().findElement(By.xpath("//div[@id='view-destination-station']")), "Select Arrival City");
  }
  
 // @Test
  public void LeavingDestinationEmpty() throws InterruptedException {
	
	  page.getDriver().findElement(By.xpath("(//input[@id='ctl00_mainContent_ddl_originStation1_CTXT'])")).click();
	  Thread.sleep(2000);
	  page.getDriver().findElement(By.xpath("(//div[@class='dropdownDiv'])[1]/ul[3]/li[2]")).click();
	  Assert.assertEquals(page.getDriver().findElement(By.xpath("(//input[@id='ctl00_mainContent_ddl_originStation1_CTXT'])")).getAttribute("value"), "Kanpur (KNU)");  
  
  }
  
  
 // @Test
  public void LeavingDepartureEmpty() throws InterruptedException {
	
	  page.getDriver().findElement(By.xpath("//input[@id= 'ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
	  Thread.sleep(2000);
	  Assert.assertEquals(page.getDriver().findElement(By.xpath("//input[@id= 'ctl00_mainContent_ddl_destinationStation1_CTXT']")).getAttribute("menuselection"), "false");  
  
  }
  
//	@BeforeMethod
	  public void beforeMethod() {

		page.igniteBrowser();
			
	  }

//	  @AfterMethod
	  public void afterMethod() {
		  page.getDriver().quit();
		  
	  }


}
