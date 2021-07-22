package tests;

import org.testng.annotations.Test;

import data.ExcelDatareader;
import pages.SpiceJetFormPage;
import pages.demoFormPage;
import utils.Xls_Reader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;


public class formFilling {
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\vishw\\Desktop\\dataFordemo.xlsx");
	SpiceJetFormPage page = new SpiceJetFormPage();
	demoFormPage demopage = new demoFormPage();
	ExcelDatareader excelreader = new ExcelDatareader();
	
  @Test(dataProvider = "dataforWeb")
  public void formFillingExcel(String firstName, String lastName, String address, String email) {
	  
	demopage.driver.findElement(By.xpath("//form/div[1]/div[1]/input")).sendKeys(firstName);
	demopage.driver.findElement(By.xpath("//form/div[1]/div[2]/input")).sendKeys(lastName);
	demopage.driver.findElement(By.xpath("//form/div[2]/div/textarea")).sendKeys(address);
	demopage.driver.findElement(By.xpath("//form/div[3]/div[1]/input")).sendKeys(email);
	
  }
  
 @DataProvider
  public Object[][] dataforWeb(){
	  Object[][] data = new Object[reader.getRowCount("Sheet1") - 1][reader.getColumnCount("Sheet1")];
	
	  int counter = 0;
	  for(int i = 0; i<reader.getRowCount("Sheet1") - 1; i++) {
		  
		  for(int j = 0; j<reader.getColumnCount("Sheet1"); j++) {
		  
			  data[i][j] = excelreader.retrivingExcel().get(counter);
		  		counter++;
	  }

		  }
	return data;
	  }

  @Test
  public void rowCountPrint() {
	  System.out.println("Total rows are: " + reader.getRowCount("Sheet1"));
	  System.out.println("Total columns are: " + reader.getColumnCount("Sheet1"));
	  System.out.println(excelreader.retrivingExcel());
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	demopage.init();  
	  
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  demopage.driver.quit();
  }

}
