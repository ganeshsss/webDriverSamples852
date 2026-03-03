package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class FirstSampleTest {
  @Test
  public void loginTest() {
	  
	  Map<String,Object> prefs = new HashMap();
	  
	  //Disable the "save password" pop-up
	  prefs.put("credentials_enable_service", false);
	  prefs.put("profile.password_manager_enabled",false);
	  
	  //Disable the "change your password" pop-up
	  prefs.put("profile.password_manager_leak_detection",false);
	  
	  //create ChromeOptions object
	  ChromeOptions options=new ChromeOptions();
	  options.setExperimentalOption("prefs", prefs);
	  
	  WebDriver driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/login");
	  
	  
	  //username 
//	  WebElement userinput = driver.findElement(By.id("username"));
	  WebElement userinput = driver.findElement(By.xpath("//input[@type='text' and @name='username']"));
	  userinput.sendKeys("tomsmith");
	  
	  //password
	  WebElement userpassword = driver.findElement(By.name("password"));
	  userpassword.sendKeys("SuperSecretPassword!");
	  
	  //click button
//	  WebElement Submit = driver.findElement(By.className("radius"));
//	  WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
//	  WebElement Submit = driver.findElement(By.xpath("//button[@type='submit' and @class='radius']"));
	  WebElement Submit = driver.findElement(By.xpath("//button[@type='submit' or @class='radius']"));
	  Submit.click();
	  
//	  verify the title and navigate back
//	  driver.navigate().back();
	  String title=driver.getTitle();
	  Assert.assertEquals(title,"The Internet");
	  
	  //partial and link text-After the login page
//	  driver.findElement(By.linkText("Elemental Selenium")).click();
	  driver.findElement(By.partialLinkText("Selenium")).click();
	  
	  
  }
}
