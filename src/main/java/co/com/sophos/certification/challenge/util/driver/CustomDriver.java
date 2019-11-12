package co.com.sophos.certification.challenge.util.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomDriver {
	
	private WebDriver driver;
	
	public CustomDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized","--incognito");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(24, TimeUnit.SECONDS);
	}
	
	public static CustomDriver chromeDriver() {
		return new CustomDriver();
	}
	
	public WebDriver onPageURL(String url) {
		driver.get(url);
		return driver;
	}

}
