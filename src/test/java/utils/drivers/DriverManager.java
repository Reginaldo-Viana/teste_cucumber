package utils.drivers;


import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class DriverManager {
	public static WebDriver navigate(){

		File file = new File("/home/reginaldo/Documents/testeCucumber/teste_cucumber/chrome_driver/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String i = driver.getCurrentUrl();
		System.out.println(i);
		return driver;
	}
	
}


	
