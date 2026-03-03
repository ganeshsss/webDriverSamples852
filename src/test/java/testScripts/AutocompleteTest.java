package testScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutocompleteTest {
  @Test(groups="SmokeTest")
  public void Autocomplete() throws InterruptedException {
	  
	  String expValue = "BASIC";
	  
	  WebDriver driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
		driver.get("https://jqueryui.com/autocomplete/");
		driver.manage().window().maximize();
		
		WebElement iframe =driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		WebElement inputbox = driver.findElement(By.id("tags"));
		inputbox.sendKeys("as");
		
//		Thread.sleep(2000);
		
		List<WebElement> items = driver.findElements(By.cssSelector("#ui-id-1 li"));
		System.out.println("NumbeR of matching items..."+ items.size());
		
		for(WebElement item : items) {
			System.out.println(item.getText());
			if(item.getText().equalsIgnoreCase(expValue)) {
				item.click();
				break;
			}
		}
		
  }
  
}
