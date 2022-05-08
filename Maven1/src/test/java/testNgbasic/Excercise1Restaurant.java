package testNgbasic;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Excercise1Restaurant {
	WebDriver driver;
  @Test(priority=0)
  public void verifyTheSuccesfulLogin() {
	  WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys("admin");
	  WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys("password");
	  WebElement login= driver.findElement(By.xpath("//input[@name='submit']"));
	  login.click();
	  String expected_title= "POS - point of sale Presto Cafeteria";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title);	   
  }
  @Test(priority=1)
  public void verifySearchFunctionUnderProductTab() {
	  WebElement product =driver.findElement(By.xpath("(//*[@class='fa fa-archive'])[1]"));
	  product.click();
	  WebElement search=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	  search.sendKeys("P001");
	  WebElement item= driver.findElement(By.xpath("//table[@id='Table']//tr[1]//td[2]"));
	  String actual=item.getText();
	  String expected= "Veg Fried Rice";
	  Assert.assertEquals(actual, expected);
	  
  }
  
  @Test (priority=2)
  public void isAddStorePresentUnderStoreTab(){
	  WebElement store= driver.findElement(By.xpath("//*[@class='fa fa-hospital-o']"));
	  store.click();
	  WebElement addstore= driver.findElement(By.xpath("//*[@class='btn btn-add btn-lg']"));
	  Boolean actual=addstore.isDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test (priority=3)
  public void isAddedWareHousepresent() throws Exception
  {
	  WebElement settings= driver.findElement(By.xpath("//*[text()='Setting']"));
	  settings.click();
	  WebElement Warehouse= driver.findElement(By.xpath("//*[@href='#warehouses']"));
	  Warehouse.click();
	  Thread.sleep(2000);
	 WebElement addwarehouse=driver.findElement(By.xpath("(//*[@class='btn btn-add btn-lg'])[3]"));
	 addwarehouse.click();
	 
	 WebElement wareHouseName=driver.findElement(By.xpath("//input[@id='WarehouseName']"));
	 wareHouseName.sendKeys("Disney");
	 
	 WebElement wareHousePhone=driver.findElement(By.xpath("//input[@id='WarehousePhone']"));
	 wareHousePhone.sendKeys("123456789");
	 
	 WebElement submit= driver.findElement(By.xpath("(//*[@class='btn btn-add'])[2]"));
	 submit.click();
	 driver.navigate().refresh();
	 WebElement addedWarehouse =driver.findElement(By.xpath("(//table[@class='table'])[2]//tr[4]//td[1]"));
	 
	 Assert.assertTrue(addedWarehouse.isDisplayed());
	
  }
  @Test (priority=4)
  public void isLogOutButtonVisible()
  {
	  WebElement logout=driver.findElement(By.xpath("//*[@class='fa fa-sign-out fa-lg']"));
	 Assert.assertTrue(logout.isDisplayed());
	  
  }
  @Test (priority=5)
  public void verifySuccesfulLogout() throws InterruptedException
  {
	  WebElement logout=driver.findElement(By.xpath("//*[@class='fa fa-sign-out fa-lg']"));
	  logout.click();
	  Thread.sleep(2000);
	  String actul=driver.getTitle();
	  String expected= "POS Login";
	  Assert.assertEquals(actul,expected);
	  
  }
  @BeforeClass
  public void beforeClass() {
	  	System.setProperty("webdriver.chrome.driver", "F:\\selenium_drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qalegend.com/restaurant/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
