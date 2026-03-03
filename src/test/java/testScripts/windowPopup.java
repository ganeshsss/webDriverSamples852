package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class windowPopup {
  @Test
  public void windowPopup() {
	  	WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		
		WebElement simplealert = driver.findElement(By.id("alertBtn"));
		simplealert.click();
		
//		Alert alert =driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(),"I am an alert box!");
		alert.accept();
		
		driver.findElement(By.id("confirmBtn")).click();
		Alert confirm = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(),"Press a button!");
		alert.dismiss();
		
		WebElement prompt = driver.findElement(By.id("promptBtn"));
		prompt.click();
		Alert alert1 = driver.switchTo().alert();
		
		alert1.sendKeys("Selenium");
		alert1.accept();
		
		WebElement textdemo = driver.findElement(By.id("demo"));
		System.out.println(textdemo.getText());
	    Assert.assertEquals(textdemo.getText(), "Hello selenium! How are you today?");
		
		
		
		
				
}}
