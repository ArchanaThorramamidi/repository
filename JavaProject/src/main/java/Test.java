
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Test {
	
	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		openShopee();
			//swipeScreen();
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		
		
	}
	
	@BeforeTest
	public static void openShopee() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "AOSP on IA Emulator");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.shopee.sg");
		cap.setCapability("appActivity", "com.shopee.app.ui.home.HomeActivity_");
		
		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application Started");
		
		Thread.sleep(60);
		
		MobileElement shopee_screen1= driver.findElement(By.xpath("//android.widget.FrameLayout[@index=0]"));
		scroll(driver,0.8,0.2,0.2,0.2);
		System.out.println("Application Screen 1 Swiped");
		
		
		MobileElement shopee_screen2= driver.findElement(By.xpath("//android.widget.LinearLayout[@index=0]"));
		scroll(driver,0.8,0.2,0.2,0.2);
		System.out.println("Application Screen 2 Swiped");
		
		MobileElement shopee_screen3= driver.findElement(By.xpath("//android.widget.FrameLayout[@index=0]"));
		scroll(driver,0.8,0.2,0.2,0.2);
		System.out.println("Application Screen 3 Swiped");
		
		
		MobileElement shopee_screen4= driver.findElement(By.xpath("android.widget.Button[@text='START' and @index='1']"));
		shopee_screen4.click();
		
		System.out.println("Application Screen 4 Swiped");					

	}
	


	public static void scroll(AppiumDriver<MobileElement> driver2, double d, double e, double f, double g) throws Exception {
		// TODO Auto-generated method stub
		
		
		Dimension dimension = driver.manage().window().getSize();
		
		int start_d= (int) (dimension.width * d);
		int start_e= (int) (dimension.height * e);
		int start_f= (int) (dimension.width * f);
		int start_g= (int) (dimension.height * g);
		
		TouchAction touch = new TouchAction(driver);
		
		touch.press(PointOption.point(start_d, start_e))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(start_f, start_g)).release().perform();
		
		Thread.sleep(3000);
		
	}

	public static void swipeScreen() throws Exception{
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "AOSP on IA Emulator");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.shopee.sg");
		cap.setCapability("appActivity", "com.shopee.sg:id/image_");
		
		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		TouchAction ts = new TouchAction(driver);
		
		ts.press(PointOption.point(540,1420)).moveTo(PointOption.point(560,1420)).release().perform();
		
			

  }
	
	@AfterTest
	public void teardown() {};
	
}
