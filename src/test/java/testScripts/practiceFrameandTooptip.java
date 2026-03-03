package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practiceFrameandTooptip {
  @Test
  public void PracticeFrameandtooltiptest() {
	  
	  	WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		action.scrollByAmount(10, 900);
		
		WebElement praframe= driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(praframe);
		
		WebElement inpage = driver.findElement(By.id("age"));
		action.moveToElement(inpage).perform();
		
		String altTxt = driver.findElement(By.cssSelector("#ui-id-1")).getText();
		Assert.assertEquals(altTxt,"We ask for your age only for statistical purposes.");
		
		driver.switchTo().defaultContent();
		String strTxt = driver.findElement(By.cssSelector("div.demo-description")).getText();
		System.out.println(strTxt);
		
		
		
	  
  }
}
