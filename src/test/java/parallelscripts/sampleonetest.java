package parallelscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class sampleonetest {
	
	WebDriver driver;

  @Test
  public void testone() 
  {
	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test11 in sampleone...."+id);
  }
  
  @Test

  public void testtwo() 
  {
	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test12 in sampleone...."+id);
  }
  
  @Test
  public void testthree() 
  {
	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test13 in sampleone...."+id);
  }
}
