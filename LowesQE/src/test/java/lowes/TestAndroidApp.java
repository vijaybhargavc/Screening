package lowes;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class TestAndroidApp {
	public AndroidDriver<MobileElement> driver;

	@Test
	public void addcontact() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");

		caps.setCapability("platformName", "Android");

		caps.setCapability("app", "C:\\Users\\Vijcheku\\Desktop\\Screening\\LowesQE\\src\\test\\resources\\mobileApps\\ContactManager.apk");
		// caps.setCapability("appActivity",
		// "com.google.android.finsky.activities.MainActivity");
		// caps.setCapability("noReset", "true");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		driver.findElementById("Add Contact").click();
		driver.findElementById("com.example.android.contactmanager:id/contactNameEditText").sendKeys("test");
		driver.findElementByAccessibilityId("Save").click();
		driver.quit();

	}

}
