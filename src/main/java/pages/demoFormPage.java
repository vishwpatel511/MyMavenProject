package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demoFormPage {

	 public WebDriver driver;
	
	 public void init() {
	 
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\geckodriver.exe");
		 driver = new FirefoxDriver();
		  driver.get("http://demo.automationtesting.in/Register.html");
		  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		  
	 }
}
