package base;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mohan Murali\\workspace\\TestAutomation\\chromedriver.exe") ;
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("http://cafetownsend-angular-rails.herokuapp.com/");
		
		
	
	}

}
