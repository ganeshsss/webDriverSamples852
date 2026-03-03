package parallelscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class sampletwotest {
	
	WebDriver driver;

  @Test
  public void testone() 
  {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test21 in sampleone...."+id);
  }
  
  @Test

  public void testtwo() 
  {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test22 in sampleone...."+id);
  }
  
  @Test
  public void testthree() 
  {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test23 in sampleone...."+id);
  }
}
