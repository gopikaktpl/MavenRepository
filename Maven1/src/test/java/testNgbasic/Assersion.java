package testNgbasic;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Assersion {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
  @Test
 (priority = 0)
	public void verifyTheCurrentURLOfThePage() {
		String expectedURL = "https://qalegend.com/restaurant/login";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL,expectedURL);
		
		//softAssert.assertEquals(actualURL,expectedURL);
		//softAssert.assertAll();

	}
	@Test(priority = 1)
	public void verifyThePageTitle()
	{
		String expectedTitle = "POS Login";

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		//softAssert.assertEquals(actualTitle,expectedTitle);
		//softAssert.assertAll();

	}
	@Test(priority = 2)
	public void verifyTheUSerNameAfterSuccessfulLogin() {
		WebElement userName = driver.findElement(By.xpath("//*[@placeholder='Username']"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
		password.sendKeys("password");
		WebElement loginBtn = driver.findElement(By.name("submit"));
		loginBtn.click();
		WebElement name = driver.findElement(By.xpath("//span[contains(text(),'admin Doe')]"));  
		String expectedName = "  admin Doe";
		String actualName = name.getText();
		Assert.assertEquals(actualName, expectedName);
		//softAssert.assertEquals(actualName, expectedName);
		//softAssert.assertAll();
	}
	@Test(enabled=false)
	public void isSpotLightStoreAvailable() {
		WebElement spotLight = driver.findElement(By.xpath("//*[text()='Spotlight']"));
		Boolean actual = spotLight.isDisplayed();
		Assert.assertTrue(actual);
		//softAssert.assertTrue(actual);
		//softAssert.assertAll();
		
	}
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "F:\\selenium_drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qalegend.com/restaurant/login");
		driver.manage().window().maximize();
	}

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
