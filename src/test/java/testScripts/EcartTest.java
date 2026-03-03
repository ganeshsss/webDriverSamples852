package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EcartTest {
 
  WebDriver driver;
  WebDriverWait wait;
  Properties prop; 
  
  @BeforeTest
  public void ecart() throws IOException {
	  	
//	  	String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//config.properties";
	  	String path = System.getProperty("user.dir") + "/src/test/resources/configFiles/config.properties";
	  	
	  	FileInputStream fin = new FileInputStream(new File(path));
	  	prop = new Properties();
	  	prop.load(fin);
	  	String strBrowser = prop.getProperty("browser");
	  	if(strBrowser.equalsIgnoreCase("chrome")) 
	  	{
	  		driver = new ChromeDriver();
	  	}
	  	
	  	else if(strBrowser.equalsIgnoreCase("edge"))
	  	{
	  		driver = new EdgeDriver();
	  	}
	  	
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		
		//login the application
		WebElement login = driver.findElement(By.id("login2"));
		login.click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		WebElement UsernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
		UsernameField.sendKeys("Selvaganesh");
		
		WebElement PasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
		PasswordField.sendKeys("Selenium@123");
		
		
		WebElement loginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Log in')]")));
		loginbutton.click();
		
		//Verify the name of the user once logged
		WebElement nameofuser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		System.out.println(nameofuser.getText());
		Assert.assertEquals(nameofuser.getText(), "Welcome Selvaganesh");
		
		//scrolling down with javascript
		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(10,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,300)");
		
		//click on the product link
		WebElement Productlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
		Productlink.click();
		
		WebElement SamsungPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Samsung galaxy s6')]")));
		System.out.println(SamsungPage.getText());
		Assert.assertEquals(SamsungPage.getText(), "Samsung galaxy s6");
		
		WebElement addtocart = driver.findElement(By.linkText("Add to cart"));
		addtocart.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		
		WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart")));
		cart.click();
		
		WebElement cartpage = driver.findElement(By.xpath("//div[@class='col-lg-8']/h2"));
		System.out.println(cartpage.getText());
		Assert.assertEquals(cartpage.getText(), "Products");
		
		WebElement Productincart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='tbodyid']/tr[1]")));
		if(Productincart.isDisplayed()); {
			System.out.println("Product is successfuly added to the cart");
		}
		
		
  }	
	
}

