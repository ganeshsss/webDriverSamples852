package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.JavascriptExecutor;

public class ExplicitwaitTest {
  @Test
  public void  Explicitwait() {
	  
	  	WebDriver driver = new ChromeDriver();
	  	
	  	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(18));
	  	
	  	
		driver.get("http://uitestingplayground.com/ajax");
		driver.manage().window().maximize();
		
		WebElement ajax = driver.findElement(By.id("ajaxButton"));
		ajax.click();
		
//		WebElement text = driver.findElement(By.id("content"));
//		WebElement text = wait.until(ExpectedConditions.textToBePresentInElement(ajax, "Data loaded with AJAX get request."));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("content")), "Data loaded with AJAX get request."));
		
		
		WebElement text = driver.findElement(By.id("content"));
		Assert.assertEquals(text.getText(), "Data loaded with AJAX get request.");
		
		
		System.out.println(text.getText());
  }
		
	@Test	
public void jsExecutorTest() 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(10,document.body.scrollHeight)");
	
}
		
		
  }

