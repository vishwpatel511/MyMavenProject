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

public class RadioButtonsTest {
  
	SpiceJetFormPage page = new SpiceJetFormPage();
	
	
//	@Test
	public void OneWayRadioButtonTest() {
		
	
	page.radioButtonSelector(1).click();
	Assert.assertTrue((page.getDriver().findElement(By.xpath("//div[@id='Div1']")).getCssValue("opacity").equals("0.5")));
	}
	
//	@Test
	public void RoundTripButtonTest() {
		page.radioButtonSelector(2).click();
		Assert.assertTrue((page.getDriver().findElement(By.xpath("//div[@id='Div1']")).getCssValue("opacity").equals("1")));
	}
	
//	@Test
	public void multiCityButtonTest() {
		
		page.radioButtonSelector(3).click();
		Assert.assertTrue(page.getDriver().findElement(By.xpath("//a[@id='MultiCityModelAlert']")).isDisplayed());
		
	}
	
 // @BeforeMethod
  public void beforeMethod() {
		
		page.igniteBrowser();
  }

 // @AfterMethod
  public void afterMethod() {
	  
	  page.getDriver().quit();
	  
  }

}
