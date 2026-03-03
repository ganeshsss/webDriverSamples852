package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Shadowhost {
  @Test
  public void shadowhost() {
	  
	  WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		WebElement Shadow = driver.findElement(By.id("shadow_host"));
		SearchContext cont = Shadow.getShadowRoot();
		cont.findElement(By.cssSelector("input[type=text]")).sendKeys("SHADOW INPUT");
		
  }
}
