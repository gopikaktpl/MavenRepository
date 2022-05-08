package testNgbasic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AlertTestNG {
	WebDriver driver;
  @Test
  public void alertHandling() {
	  WebElement customerID= driver.findElement(By.name("cusid"));
		 customerID.sendKeys("123");
		 
		 WebElement submit= driver.findElement(By.xpath("//*[@name='submit']"));
		 submit.click();
		 
		 driver.switchTo().alert().accept();
		 //Thread.sleep(2000);
		 
		 driver.switchTo().alert().accept();
		 
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "F:\\selenium_drivers\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}
