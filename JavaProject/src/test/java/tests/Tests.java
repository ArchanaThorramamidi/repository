package tests;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.util.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Tests extends BaseClass {


	@BeforeTest
	public static void scroll(AppiumDriver<MobileElement> driver2, double d, double e, double f, double g) throws Exception {
		// Common Function to Swipe throw the screens


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


	@Test
	public static void SwipeScreen1() throws Exception {


		MobileElement shopee_screen1= driver.findElement(By.xpath("//android.widget.FrameLayout[@index=0]"));
		scroll(driver,0.8,0.2,0.2,0.2);
		System.out.println("Application Screen 1 Swiped");

	}

	@Test
	public static void SwipeScreen2() throws Exception {

		MobileElement shopee_screen2= driver.findElement(By.xpath("//android.widget.LinearLayout[@index=0]"));
		scroll(driver,0.8,0.2,0.2,0.2);
		System.out.println("Application Screen 2 Swiped");

	}

	@Test
	public static void SwipeScreen3() throws Exception {

		MobileElement shopee_screen3= driver.findElement(By.xpath("//android.widget.FrameLayout[@index=0]"));
		scroll(driver,0.8,0.2,0.2,0.2);
		System.out.println("Application Screen 3 Swiped");

	}

	//MobileElement shopee_screen4= driver.findElement(By.xpath("android.widget.Button[@text='START' and @index='1' and @resource-id='com.shopee.sg:id/btn']"));
	//MobileElement shopee_screen4= driver.findElement(By.id("com.shopee.sg:id/btn"));

	@Test
	public static void clickStart() throws Exception {

		List<MobileElement> buttons = driver.findElementsByClassName("com.shopee.sg:id/btn");


		for(MobileElement button : buttons){
			System.out.println(button.getText());

			if(button.getText().equals("START")){
				button.click();
			}
		}



		System.out.println("START Button Clicked to launch the APP");	

	}

	@Test
	public static void allowLocationservices() throws Exception {


		List<MobileElement> popup_selection = driver.findElementsByClassName("android.widget.TextView");


		for(MobileElement button : popup_selection){
			System.out.println(button.getText());

			if(button.getText().equals("OK")){
				button.click();
			}
		}

		System.out.println("Location Services accepted");	

	}

	@Test
	public static void denyAccesstoDeviceLocation() throws Exception {


		List<MobileElement> popup_selection = driver.findElementsByClassName("android.widget.Button");


		for(MobileElement button : popup_selection){
			System.out.println(button.getText());

			if(button.getText().equals("ALLOW")){
				button.click();
			}
		}

		System.out.println("Access Granted to device Locataion !!");	

	}

	@Test
	public static void clickShopeeMall() throws Exception {


		MobileElement popup_selection = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=com.shopee.sg:id/TANGRAM_VIEW_CONTAINER_ID]"));

		popup_selection.click();


		System.out.println("ShopeeMall has been clicked  !!");	

	}

	@Test
	public static void selectMobileSections() throws Exception {


		MobileElement popup_selection = driver.findElement(By.xpath("//android.view.ViewGroup[@index=3]"));

		popup_selection.click();

		//Now select the Mobile devices after selecting the dropdown 

		MobileElement mobile_selection = driver.findElement(By.xpath("//android.widget.ImageView[@index=0]"));

		mobile_selection.click();

		System.out.println("Mobile and Gadjets have been Clicked  has been clicked  !!");	

	}

	@Test
	public static void selectTrendingShops() throws Exception {


		MobileElement popup_selection = driver.findElement(By.xpath("//android.widget.TextView[@text='See All']"));

		popup_selection.click();


		System.out.println("Trending Shops have been selected  !!");	

	}

	@Test
	public static void selectSamsungOfficialStore() throws Exception {


		//Instead of Scrolling down i am using the alphabetbet future to and clicking on S to product list starting with S

		MobileElement popup_selection = driver.findElement(By.xpath("//android.widget.TextView[@text='S']"));

		popup_selection.click();

		System.out.println("Trending Shops have been selected  !!");	

		//Now select **SAMSUNG OFFICIAL STORE**

		MobileElement popup_selection1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Samsung']"));

		popup_selection1.click();

		//Get Last ACtive Status

		MobileElement lastActiveStatus = driver.findElement(By.xpath("//android.widget.TextView[@text='Active 30 minutes ago' AND @index='5']"));

		String last_active_status=lastActiveStatus.getText();

		System.out.print("LastActiveStatus is "+last_active_status);

		//Get Store Rating 

		MobileElement rating = driver.findElement(By.xpath("//android.widget.TextView[@text='4.8 / 5.0' AND @index='0']"));

		String ratingSamsung=rating.getText();

		System.out.print("Rating is is "+ratingSamsung);

		//Number of Followers

		MobileElement followers = driver.findElement(By.xpath("//android.widget.TextView[@text='51.6k' AND @index='0']"));


		String noOfFollowers=followers.getText();

		System.out.print("Number of Followers are"+noOfFollowers);



	}

	@Test
	public static void clickFilterSelection() throws Exception {


		//Click the Filter selection 

		MobileElement filterSelection_1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Filter' AND @index='1']"));

		filterSelection_1.click();


	}

	@Test
	public static void selectDesiredfilters() throws Exception {


		//Click the Filter selection 

		MobileElement rating = driver.findElement(By.xpath("//android.widget.TextView[@text='4 Stars & Up' AND @index='0']"));

		rating.click();

		//Filter Out New Mobile

		MobileElement condition = driver.findElement(By.xpath("//android.widget.TextView[@text='New' AND @index='0']"));

		condition.click();

		//Se4lect Miimum Price

		MobileElement minimumPrice = driver.findElement(By.xpath("//android.widget.TextView[@text='MIN' AND @index='0']"));

		minimumPrice.click();

		int min_value=500;

		minimumPrice.sendKeys(min_value);

		//Se4lect Maximum Price
		MobileElement maximumPrice = driver.findElement(By.xpath("//android.widget.TextView[@text='MAX' AND @index='0']"));


		maximumPrice.click();

		minimumPrice.sendKeys(4000);

		//Apply Filters

		MobileElement apply = driver.findElement(By.xpath("//android.widget.TextView[@text='Apply' AND @index='0']"));

		apply.click();
		apply.submit();

	}

	@Test
	public static List<String> higeshProduct(String price) throws Exception {


		java.util.List<MobileElement>ProductList =(List<MobileElement>) driver.findElement(By.xpath("//android.view.ViewGroup"));

		java.util.List<String> priceOfProduct = new ArrayList<>();

		//Logic to add all price details to list

		for (MobileElement text : ProductList)() {
			priceOfProduct.add(text.getText());
		}

		//logic to logic

		for (int i=0;i< ProductList.size();i++) {
			String actuallist = ProductList.get(i).getText();
			System.out.println("Print Product price from list " +actuallist);
			if(actuallist.equals(price)) {
				driver.findElementByName(price).click();
			} else {
				Util.scrollDown(driver);
			}
		}

		return priceOfProduct;

	}



}
