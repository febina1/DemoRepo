package com.slabs.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.slabs.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringDecorator e_driver;
	
	public TestBase() throws IOException
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\Prabhanjan Sharma\\eclipse-workspace\\SwagLabs\\src\\main\\java\\com\\slabs\\qa\\config\\config.properties");
		prop.load(ip);
	}

	public void initialize()
	{
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium sw\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if (browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Selenium sw\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new FirefoxDriver();
		}
		
//		e_driver=new EventFiringDecorator(driver);
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));
				
	}
}
