package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class NewTest {

	private static WebDriver driver = null;
  @Test
  public void appiumExampleTest() throws Exception {
	  	// find button with label New Button
		WebElement button=driver.findElement(By.name("New Button"));
		// click on button and start second Activity
		button.click();

		// we are on second screen now
		// check if second screen contains TextView with text “Activity2”
		driver.findElement(By.name("ActivityTwo"));
		
		// find button with label or content-description New Button
		WebElement button2=driver.findElement(By.name("New Button"));
		// click on button and start second Activity
		button2.click();
		

		// we are on first screen now
		// check if second screen contains TextView with text “Activity2”
		driver.findElement(By.name("SimpleAppiumApp"));
	}
  
@BeforeTest
  public static void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app-package", "com.example.danielbaranowski.simpleappiumapp"); //Replace with your app's package
		capabilities.setCapability("app-activity", "com.example.danielbaranowski.simpleappiumapp.MainActivity"); //Replace with app's Activity
		capabilities.setCapability("app", "//home//administator//Downloads//app-release.apk"); 
		capabilities.setCapability("deviceName", "device");
		capabilities.setCapability("platformName", "Android");

		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}


@AfterTest
  public static void tearDown(){
		driver.quit();
	}

}
