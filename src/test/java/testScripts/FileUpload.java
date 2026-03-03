package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
  @Test
  public void file_upload() {
  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/upload");
	  
	  //locating the file upload element-because it is an iput element
	  WebElement Choosefile = driver.findElement(By.id("file-upload"));
	  
	  //from our project current directory taking the png file
	  String path = System.getProperty("user.dir") + "//screenshots//" + "1770786116543.png";
	  
	  //passing the file into that input element
	  Choosefile.sendKeys(path);
	  
	
	  
	  //clicking the upload button
	  driver.findElement(By.id("file-submit")).click();
	  
	  
	  
	  
  }
  
  @Test
  public void filedownload()
  {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/dowdload");
	  
	  WebElement download = driver.findElement(By.linkText("tmp84ee8fy5.txt"));
	  download.click();
	  
  }
  
  
  
}
