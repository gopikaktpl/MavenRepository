package testNgbasic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class RobotFileUpload {
	WebDriver driver;
  @Test
  public void fileUploadWithRobotcls() throws InterruptedException, AWTException {
	  WebElement browse= driver.findElement(By.xpath("//span[@class='browse']"));
		browse.click();
		
		Thread.sleep(2000);
		
		
		Robot rb= new Robot();
		
		
		StringSelection filepath= new StringSelection("C:\\Users\\DELL NOTEBOOK 3442\\Desktop\\java\\Selenium.pdf");
		
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		rb.keyRelease(KeyEvent.VK_V);
		
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("file uploaded");


  }
  @BeforeMethod
  public void beforeMethod() {
			System.setProperty("webdriver.chrome.driver", "F:\\selenium_drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://resume.naukri.com/resume-quality-score");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
