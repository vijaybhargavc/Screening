package lowes;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Calculator {
	
	static AppiumDriver<MobileElement> driver;
	
	@Test
	public void calculator() throws Exception {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "7.1.1");
		capability.setCapability("deviceName", "Pixel API 25");
		capability.setCapability("udid", "emulator-5554");
		
		// app package and activity can be set in a reusable method for testing multiple activities and apps depending the testing workflow design
		capability.setCapability("appPackage", "com.android.calculator2");
		capability.setCapability("appActivity", "com.android.calculator2.Calculator");
		//capability.setCapability("automationName","uiautomator2");

		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,capability);
		
		MobileElement noThreeButton = driver.findElementById("com.android.calculator2:id/digit_3"); 
		// reusable method can be created to enter number with any no of digits 
		// using the number chars one by one directly at the end of locator string
		MobileElement multiplyButton = driver.findElementById("com.android.calculator2:id/op_mul");
		MobileElement noSevenButton = driver.findElementById("com.android.calculator2:id/digit_7");
		MobileElement formulaField = driver.findElementById("com.android.calculator2:id/formula");
		MobileElement equalToButton = driver.findElementById("com.android.calculator2:id/eq");
		MobileElement resultField = driver.findElementById("com.android.calculator2:id/result");

		
		noThreeButton.click();
		multiplyButton.click();
		noSevenButton.click();
		
		System.out.println("Value in field after entering multiplying no's is: " + formulaField.getText()); 
		
		equalToButton.click();
		
		System.out.println("Answer for 3 * 7 in Result field after pressing equal button is: " + resultField.getText()); 

		//*** sync for visibility of clear button***
		MobileElement clearButton = driver.findElementById("com.android.calculator2:id/clr");
		clearButton.click();
		
		System.out.println("Value of Result field after clear is: '" + resultField.getText() + "'"); 
		
		driver.quit();
		
		//com.android.calculator2:id/formula
		//com.android.calculator2:id/del

	}

}
