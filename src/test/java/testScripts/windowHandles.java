package testScripts;

import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class windowHandles {
  @Test
  public void windowhand() {
	  
	  	WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		String Parentwin = driver.getWindowHandle();
		System.out.println(Parentwin);
		
		driver.findElement(By.xpath("//button[contains(text(),'New Tab')]")).click();
		Set<String> wins = driver.getWindowHandles();
		System.out.println("wins.size()");
		System.out.println(driver.getTitle());
		
		for(String win : wins)
		{
			System.out.println(win);
			if(!win.equalsIgnoreCase(Parentwin)) {
				driver.switchTo().window(win);
				System.out.println("child window"+ driver.getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(Parentwin);
		driver.findElement(By.id("alertBtn")).click();
		driver.quit();
  }
}
