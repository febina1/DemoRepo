package com.slabs.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.slabs.qa.base.TestBase;
import com.slabs.qa.pages.HomePage;
import com.slabs.qa.pages.LoginPage;
import com.slabs.qa.util.TestUtil;

public class LoginTest extends TestBase{
	LoginPage login;
	HomePage home;
	String sheetName="Sheet1";
	public LoginTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialize();
		login=new LoginPage(driver);
	}
	//------------------- for fetching data from excel-------------------------------------------
//	@DataProvider
//	public Object[][] getSlabsTestData()
//	{
//		Object data[][]=TestUtil.getTestData(sheetName);
//		return data;
//	}
	
//	@Test(dataProvider="getSlabsTestData")
//	public void loginTesting(String username, String password) throws IOException
//	{
//		login.loginTest(prop.getProperty("username"), prop.getProperty("password"));
//		login.loginTest(username,password);
//				
//	}
//----------------------------------------------------------	----------------------------------
	@Test
	public void loginTesting() throws IOException
	{
		login.loginTest(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void loginLogoTesting()
	{
		Assert.assertTrue(login.loginLogoTest());
	}
	
	@Test
	public void loginImgTesting()
	{
		Assert.assertTrue(login.loginImgTest());
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
