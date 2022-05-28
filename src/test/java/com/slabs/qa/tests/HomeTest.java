package com.slabs.qa.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.slabs.qa.base.TestBase;
import com.slabs.qa.pages.HomePage;
import com.slabs.qa.pages.LoginPage;

public class HomeTest extends TestBase{
	
	LoginPage login;
	HomePage home;
	
	public HomeTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialize();
		login=new LoginPage(driver);
		home=new HomePage(driver);
		login.loginTest(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	
	@Test(priority=1)
	public void homeTitleTest()
	{
		Assert.assertTrue(home.homeTitleTest());
	}
	
	@Test(priority=3)
	public void addToCartTest() throws InterruptedException
	{
		Assert.assertTrue(home.addToCart());
		Thread.sleep(3000);
	}
	
	@Test (priority=2, expectedExceptions=org.openqa.selenium.NoSuchElementException.class)
	public void cartIconTesting()
	{
		home.cartIconTest();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
