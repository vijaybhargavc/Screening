package lowes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ContactManager {
	
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void ContactManager() throws MalformedURLException {
		
		//Test comment to check git
				
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//		capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
//		capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Vijcheku\\Desktop\\Screening\\LowesQE\\src\\test\\resources\\mobileApps\\ContactManager.apk");
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("deviceName", "Pixel API 25");
		capabilities.setCapability("udid", "emulator-5554");
		capabilities.setCapability("app", "C:\\Users\\Vijcheku\\Desktop\\Screening\\LowesQE\\src\\test\\resources\\mobileApps\\ContactManager.apk");
		//installing Apk
		//capabilities.setCapability("app", "C:\\Users\\Vijcheku\\Desktop\\Screening\\Apk\\ContactManager.apk");	
		
		//Running the activity needed directly -- ** getting access denied error
		//capabilities.setCapability("appActivity", "com.example.android.contactmanager.ContactManager");
		//capabilities.setCapability("appPackage", "com.example.android.contactmanager");		
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,capabilities);
		
		driver.findElementById("com.example.android.contactmanager:id/addContactButton").click();
		
		List<MobileElement> textElements = driver.findElements(By.className("android.widget.EditText"));
		System.out.println("No of Text fields in the Add Contact Screen: " + textElements.size());
		
		List<MobileElement> SpinnerSelectElements = driver.findElements(By.className("android.widget.Spinner"));
		System.out.println("No of spinner select fields in the Add Contact Screen: " + SpinnerSelectElements.size());
		
		driver.quit();
		
	}
	

}
