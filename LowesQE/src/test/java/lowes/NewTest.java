package lowes;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

//import base.tmobase;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	private WebDriver driver;
	public AppiumDriver<MobileElement> driver1;

//This is my test here
	@Test
	public void testweb() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vijcheku\\Desktop\\Screening\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).click();
		driver.findElement(By.id("search_query_top")).clear();
		driver.findElement(By.id("search_query_top")).sendKeys("tshirt");
		driver.findElement(By.name("submit_search")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText(),
				"No results were found for your search \"tshirt\"");
		driver.quit();
	}
	

}
