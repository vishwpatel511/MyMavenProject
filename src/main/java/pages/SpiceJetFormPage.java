package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SpiceJetFormPage {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void igniteBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
	}

	public WebElement radioButtonSelector(int index) {
		WebElement genericRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[" +index + "]"));
		return genericRadioButton;
	}
	
	public void paxNumberSelector(String id, String Elementvalue) {
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Select genericSelector = new Select(driver.findElement(By.xpath("//p[@id='" + id +" ']/select")));
		genericSelector.selectByValue(Elementvalue);
	}
	
	public void DepartureArrival() {
		
	}
}
