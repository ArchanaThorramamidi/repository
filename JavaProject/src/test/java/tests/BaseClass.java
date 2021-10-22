package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseClass {
	
	
	static AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() {
		
		try {
		
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "AOSP on IA Emulator");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.shopee.sg");
		cap.setCapability("appActivity", "com.shopee.app.ui.home.HomeActivity_");

		URL url = new URL("http://127.0.0.1:4723/");
		
		driver = new AppiumDriver<MobileElement>(url, cap);

		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		
		
	}
	
	

	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		driver.quit();
		
	}
	

}
