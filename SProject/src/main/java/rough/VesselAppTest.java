package rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class VesselAppTest {

//	protected static AppiumServer appiumServer = new AppiumServer();
	public static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws InterruptedException {
		capabilities();
		Thread.sleep(2000);
		// Clicking on the Vessel
		List<AndroidElement> elmts = driver.findElements(By.id("com.swire.ssvessel:id/imo_id_tv"));
		for (WebElement elmt : elmts) {
			if (elmt.getText().trim().equals("961 4543")) {
				elmt.click();
				break;
			}

		}
		driver.findElement(By.xpath("//android.widget.TextView[@text='LOGIN']")).click();
		findById("com.swire.ssvessel:id/pin1").sendKeys("1");
		findById("com.swire.ssvessel:id/pin2").sendKeys("2");
		findById("com.swire.ssvessel:id/pin3").sendKeys("3");
		findById("com.swire.ssvessel:id/pin4").sendKeys("4");
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		findById("com.swire.ssvessel:id/report_submit_view").click();
		findById("android:id/button1").click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='AUBNE -2003-N (GMT+10:00)']")).click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		findById("com.swire.ssvessel:id/report_submit_txt1").click();
		findById("com.swire.ssvessel:id/bt_submit").click();
		performArrivalReport();
		Thread.sleep(10000);
		enterOilVariables();
		enterGeneralDetails();
	}

	public static void capabilities() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("platformName", "Android");
//		cap.setCapability("app", "C:\\Users\\Karthik.Rajendran\\Desktop\\ssVessel_apk\\SSVessel_dev_21022020.apk");
		cap.setCapability("platformVersion", cap.getCapability("platformVersion"));
		cap.setCapability("appPackage", "com.swire.ssvessel");
		cap.setCapability("appActivity", "com.swire.ssvessel.view.SplashScreen");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("noReset", true);
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static void performArrivalReport() {
		findById("com.swire.ssvessel:id/submit_arrival_report").click();
		findById("android:id/text1").click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Anchor']")).click();
		findById("com.swire.ssvessel:id/lat_input").sendKeys("12.972442");
		findById("com.swire.ssvessel:id/long_input").sendKeys("77.580643");
		scrollToElement("IFO");
		enterOilVariables();
		findById("com.swire.ssvessel:id/eta_date_input").click();
		driver.findElement(By.xpath("//android.view.View[@text='"+getDate()+"']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		findById("com.swire.ssvessel:id/eta_time_input").click();
		driver.findElement(By.id("android:id/button1")).click();
		findById("com.swire.ssvessel:id/submit").click();
	}
	
	public static void enterOilVariables() {
		findById("com.swire.ssvessel:id/eosp_ifo_input").sendKeys("10");
		findById("com.swire.ssvessel:id/eosp_lsfo_input").sendKeys("5");
		findById("com.swire.ssvessel:id/eosp_mgo_mdo_a_input").sendKeys("10");
		findById("com.swire.ssvessel:id/eosp_lsgo_input").sendKeys("10");
		findById("com.swire.ssvessel:id/at_berth_ifo_input").sendKeys("5");
		findById("com.swire.ssvessel:id/at_berth_lsfo_input").sendKeys("5");
		scrollToElement("Voyage Summary");
		findById("com.swire.ssvessel:id/at_berth_mgo_mdo_a_input").sendKeys("6");
		findById("com.swire.ssvessel:id/at_berth_lsgo_input").sendKeys("10");
		findById("com.swire.ssvessel:id/draft_fore_input").sendKeys("20");
		findById("com.swire.ssvessel:id/draft_aft_input").sendKeys("10");
		findById("com.swire.ssvessel:id/distance_made_input").sendKeys("50");
		findById("com.swire.ssvessel:id/avg_speed_input").sendKeys("20");
		scrollToElement("Next Port");
	}
	
	public static void enterGeneralDetails() {
		
	}
	

	public static void scrollToElement(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward().scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
	
	public static AndroidElement findById(String value) {
		return driver.findElement(By.id(value));
	}
	
	public static int getDate() {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
		return cal.get(Calendar.DAY_OF_MONTH);

	}
	

}
