package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Dynamicwebtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
		
		
//		driver.navigate().back();
		
//		driver.navigate().to("https://the-internet.herokuapp.com/tables");
//		String title=driver.getTitle();
//		Assert.assertEquals(title,"The Internet");
		
//		List<WebElement> items=driver.findElements(By.xpath("//table[@id=\"table1\"]//td[contains(text(),'Jason')]//following-sibling::td"));
//		System.out.println(items.size());
//		for (WebElement item: items) {
//			System.out.println(item.getText());
		}
		
	}


