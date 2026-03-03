package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Automation_Practice {
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void seup(String strBrowser)
	{
		if(strBrowser.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge"))
		{
			driver = new ChromeDriver();
		}
	
	
		 
		  driver.get("https://testautomationpractice.blogspot.com");
		  driver.manage().window().maximize();
	}
  @Test(groups="SanityTest")
  public void radiobox() {
	  
	  
	  
	  WebElement radio=driver.findElement(By.xpath("//input[@id='male']"));
	  if (!radio.isSelected());
	      radio.click();
	  		
  }

  
  @Test(dependsOnMethods = "radiobox")
public void checkbox() {
	  
	 
	  
	  WebElement checkbox = driver.findElement(By.id("monday"));
	  checkbox.click();
	  
	  if(checkbox.isSelected());
	     checkbox.click();
	      
	     }
  
  @Test(dependsOnMethods = "checkbox")
  public void dropdown() {
	  Select dropdown= new Select(driver.findElement(By.id("country")));
	  dropdown.selectByVisibleText("United Kingdom");
	 
	  
//	  Select listdown = new Select(driver.findElement(By.id("animals")));
//	  listdown.selectByIndex(1);
//	  listdown.selectByVisibleText("Rabbit");
//	  listdown.selectByValue("deer");
//	  
	  
	  
  }
  
}
