package com.slabs.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.slabs.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[text()='Products']")
	WebElement homeTitle;
	
	@FindBy(xpath="//div[@class='peek']")
	WebElement homeLogo;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartIcon;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement shoppingCartBadge;

	public HomePage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean homeLogoTest()
	{
		return homeLogo.isDisplayed();
	}
	public boolean homeTitleTest()
	{
		return homeTitle.isDisplayed();
	}
	public void cartIconTest()
	{
//		try
//		{
		shoppingCartBadge.isDisplayed();
//		return true;
//		} catch (Exception e){
//			System.out.println("Something went wrong.");
//			return true;
//		}
		
		
	}
	public boolean addToCart()
	{
		addToCartBtn.click();
		return shoppingCartBadge.isDisplayed();
	}

}
