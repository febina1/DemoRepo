package com.slabs.qa.pages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.slabs.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement loginLogo;
	
	@FindBy(xpath="//div[@class='bot_column']")
	WebElement loginImg;
	
	public LoginPage(WebDriver driver) throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean loginLogoTest()
	{
		return(loginLogo.isDisplayed());
	}
	
	public boolean loginImgTest()
	{
		return(loginImg.isDisplayed());
	}
	public void loginTest(String un,String pwd) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
	}
}
