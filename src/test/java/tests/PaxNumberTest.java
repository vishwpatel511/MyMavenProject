package tests;

import org.testng.annotations.Test;

import pages.SpiceJetFormPage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PaxNumberTest {
	
	SpiceJetFormPage page = new SpiceJetFormPage();
	
//	@Test
  public void paxDropDown() {
		
	
		page.getDriver().findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Assert.assertTrue(page.getDriver().findElement(By.id("divpaxOptions")).getCssValue("display").equals("block"));
		
  }
	
//	@Test(dependsOnMethods = "paxDropDown")
	public void adultDropDown() {
		
		page.paxNumberSelector("adultDropdown", "7");
		Assert.assertTrue(page.getDriver().findElement(By.xpath("//div[contains(@id, 'divpaxinfo')]")).getText().contains("7 Adult"));
	}
	
	
//	@Test(dependsOnMethods = "paxDropDown")
	public void childDropDown() {
		
		page.paxNumberSelector("childDropdown","2");
		Assert.assertTrue(page.getDriver().findElement(By.xpath("//div[contains(@id, 'divpaxinfo')]")).getText().contains("2 Child"));
	}
	

//	@Test(dependsOnMethods = "paxDropDown")
	public void InfantDropDown() {
		
		page.paxNumberSelector("infantDropdown","1");
		Assert.assertTrue(page.getDriver().findElement(By.xpath("//div[contains(@id, 'divpaxinfo')]")).getText().contains("1 Infant"));
	}
	
//	@BeforeMethod
  public void beforeMethod() {

	page.igniteBrowser();
  
	}

// @AfterMethod
  public void afterMethod() {
	  page.getDriver().quit();
	  
  }

}
