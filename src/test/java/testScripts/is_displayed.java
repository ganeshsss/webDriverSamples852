package testScripts;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;

public class is_displayed  {
  @Test(groups="SmokeTest")
  public void Verifyisdisplayed() throws IOException{
	  
	  WebDriver driver = new ChromeDriver();
		driver.get("https://automationbookstore.dev");
		driver.manage().window().maximize(); 
		
		driver.findElement(By.xpath("//*[@id=\"searchBar\"]")).sendKeys("BOOKS");
		
		TakesScreenshot src = (TakesScreenshot)driver;
		File srcfile = src.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(srcfile, new File(path));
		
		
		WebElement closeicon = driver.findElement(By.cssSelector("a[title='Clear text']"));
		System.out.println(closeicon.isDisplayed());
		if(closeicon.isDisplayed()) {
			closeicon.click();
		}
		
		
		
		driver.close();
	}


  }

