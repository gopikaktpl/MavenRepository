package testNgbasic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class FileUploadSendKey {
	WebDriver driver;
  @Test
  public void FileUploadWithSendKey() {
	  WebElement choosefile= driver.findElement(By.id("uploadfile_0"));
	  choosefile.sendKeys("C:\\Users\\DELL NOTEBOOK 3442\\Desktop\\java\\Selenium.pdf");

	  
  }
  @BeforeClass
  public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "F:\\selenium_drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
