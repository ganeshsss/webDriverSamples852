package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActionTest {
  @Test
  public void actionTest() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://testautomationpractice.blogspot.com");
	  driver.manage().window().maximize();
	  
	  Actions action = new Actions(driver);
	  WebElement btnpoint = driver.findElement(By.cssSelector("button.dropbtn"));
	  
	  action.scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]")));
	  
	  action.moveToElement(btnpoint).perform();
	  WebElement Lap = driver.findElement(By.linkText("Laptops"));
	  action.click(Lap).perform();
	  
	  
	  WebElement doubleclk = driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
	  action.doubleClick(doubleclk).perform();
	  
	  
//	 WebElement doubleclick =  driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
//	 action.contextClick(doubleclick).perform();
	  
	  //rightclick need to perform
//	 
	 
  }
}
