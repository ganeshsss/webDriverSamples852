package testScripts;

import java.time.Duration;

import commonUtilis.Utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Ecart_Test_ExtentReport {

	public WebDriver driver;
	public WebDriverWait wait;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	

	@BeforeMethod

	public void setup() {

		driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}
	
	@BeforeTest 
    public void extendreport() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
		
	}
	
	@AfterTest
	public void finishExtent() {
		extentReports.flush();
	}

	@AfterMethod

	public void teardown(ITestResult result) {
		
		if(result.getStatus() == result.FAILURE) {
			extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			String path = Utility.geScreenshotPath(driver);
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}

		driver.quit();

	}
	


	@Test(priority = 1)
	public void login()

	{
		extentTest = extentReports.createTest("Login and Verification of the page");
		
//	  login the application
		WebElement login = driver.findElement(By.id("login2"));
		login.click();

//	  Enter the username and password ,click the login button

		WebElement Usernamefield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
		Usernamefield.sendKeys("Selvaganesh");

		WebElement Passwordfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
		Passwordfield.sendKeys("Selenium@123");

		WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginbutton.click();

//	  verify the name of the user once logged
		WebElement nameofuser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		System.out.println(nameofuser.getText());
		Assert.assertEquals(nameofuser.getText(), "Welcome Selvaganesh");

	}

	@Test(priority = 2, dependsOnMethods = { "login" }, retryAnalyzer = MyRetry.class)
	public void addtocart() {

		extentTest = extentReports.createTest("Verifying adding cart is successfull");
		
//	  click on the product item
		WebElement Productlink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
		Productlink.click();

//	  Verify the product page contains -"Samsung galaxy s6"
		WebElement Samsungpage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Samsung galaxy s6')]")));
		System.out.println(Samsungpage.getText());
		Assert.assertEquals(Samsungpage.getText(), "Samsung galaxy s6");

//	  Click on the add to cart link
		WebElement addtocart = driver.findElement(By.linkText("Add to cart"));
		addtocart.click();

//	  Handling the alert
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

//	  click the cart link
		WebElement cart = driver.findElement(By.linkText("Cart"));
		cart.click();

//	  Verify the cart page contains- "Products"
		WebElement cartpage = driver.findElement(By.xpath("//div[@class='col-lg-8']/h2"));
		System.out.println(cartpage.getText());
		Assert.assertEquals(cartpage.getText(), "Product");

//	  Verify items added to the cart or not
		WebElement Productincart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='tbodyid']/tr[1]")));
		if (Productincart.isDisplayed()) {
			System.out.println("Product is successfully added to the cart");
		}
	}

	@Test(priority = 3, dependsOnMethods = { "addtocart" }, enabled = false)
	public void placeorder() {

//	  click the Place order button	  
		WebElement Placeorder = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
		Placeorder.click();

//	  Fill all the details for Purchase
		WebElement Placeorder_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		Placeorder_name.sendKeys("Vijay");

		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.id("card")).sendKeys("123456789");
		driver.findElement(By.id("month")).sendKeys("Feb");
		driver.findElement(By.id("year")).sendKeys("2026");
		driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();

//	  Verify the confirmation page
		WebElement confirmation = driver
				.findElement(By.xpath("//h2[contains(text(),\"Thank you for your purchase!\")]"));
		System.out.println(confirmation.getText());
		Assert.assertEquals(confirmation.getText(), "Thank you for your purchase!");
		System.out.println("Order Placed Successfully");
		driver.findElement(By.xpath("//button[contains(text(),\"OK\")]")).click();

	}

}
