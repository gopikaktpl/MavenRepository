package testNgbasic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class DropdownTestNG 
{
	 WebDriver driver;
  @Test
  public void selectItemFromDropDown() {
	  WebElement passengersDrop = driver.findElement(By.name("passCount"));
		passengersDrop.click();
		Select select = new Select(passengersDrop);
		select.selectByValue("3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "F:\\selenium_drivers\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/newtours/reservation.php");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
