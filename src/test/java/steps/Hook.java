package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.drivers.DriverManager;


public class Hook extends DriverManager {
	public static WebDriver driver;

	@Before
	public static void setUp(){
		driver = navigate();
	}
	

	@After
	public void tearDown(Scenario scenario) throws Exception  {
			driver.close();
		}
		
}


