package com.loginFunctioality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
		WebDriver driver;
		
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	private WebElement UserName;
	@FindBy(id ="password")
	private WebElement Password;
	@FindBy(id = "log-in")
	private WebElement LogIn;
	@FindBy(id = "amount")
	private WebElement Amount;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement RememberMe;
	
	public void SendUserName(String UserName) {
		this.UserName.sendKeys(UserName);
	}
	
	public void sendPassword(String Password) {
		this.Password.sendKeys(Password);
	}
	
	public void ClickOnLogin() {
		this.LogIn.click();
	}
	public void clickOnAmount_Header() {
		this.Amount.click();
	}
	public void ClickOnRememberme() {
		this.RememberMe.click();
	}
}
