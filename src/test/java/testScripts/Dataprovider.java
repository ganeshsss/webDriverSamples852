package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Dataprovider {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		Map<String,Object> prefs = new HashMap();
		  
		  //Disable the "save password" pop-up
		  prefs.put("credentials_enable_service", false);
		  prefs.put("profile.password_manager_enabled",false);
		  
		  //Disable the "change your password" pop-up
		  prefs.put("profile.password_manager_leak_detection",false);
		  
		  //create ChromeOptions object
		  ChromeOptions options=new ChromeOptions();
		  options.setExperimentalOption("prefs", prefs);
		  
		driver = new ChromeDriver(options);
		
		
	}
  @Test(dataProvider = "loginData")
  public void dataprovidetest(String struser, String strpwd) {
	  	
	  	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  	
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id(readObjPath("username"))).sendKeys(struser);
		driver.findElement(By.id(readObjPath("password"))).sendKeys(strpwd);
//		driver.findElement(By.id("login-button")).submit();
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(readObjPath("loginBtn"))));
		element.click();
		
		WebElement prodcuts_page = driver.findElement(By.xpath(readObjPath("heaserMsg")));
		Assert.assertTrue(prodcuts_page.isDisplayed(),"Assertion verfication is failed");
		System.out.println("Assertion verfication is passed");
  }
  		//csv reader
		@DataProvider(name="loginData")
		public Object[][] getData() throws CsvValidationException, IOException {
		    String path = System.getProperty("user.dir") + "/src/test/resources/testData/loginData.csv";
		    CSVReader reader = new CSVReader(new FileReader(path));
		    
		    String[] cols; // Corrected array declaration
		    ArrayList<Object[]> dataList = new ArrayList<Object[]>(); // Explicitly store Object arrays
		    
		    // Corrected the assignment inside the while condition
		    while ((cols = reader.readNext()) != null) {
		        Object[] record = { cols[0], cols[1] };
		        dataList.add(record);
		    }
		    reader.close();
		    
		    // Fixed the syntax for toArray
		    return dataList.toArray(new Object[dataList.size()][]);
		}
		
		//excel reader
		public String readObjPath(String objName)  {
			String objPath ="";
			String path = System.getProperty("user.dir") + "/src/test/resources/testData/loginRepo.xlsx";
			
			FileInputStream fin;
			XSSFWorkbook workbook = null;
			
			try {
				fin = new FileInputStream(path);
				workbook = new XSSFWorkbook(fin);
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
            		
		   XSSFSheet loginSheet = workbook.getSheet("loginPage");
		   int numRows = loginSheet.getLastRowNum();
		   for(int i=1; i<=numRows; i++) {
			   XSSFRow row = loginSheet.getRow(i);
			   if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
				   objPath = row.getCell(1).getStringCellValue();
			   }
		   }
		   return objPath;
		
		}
		
  }

  

