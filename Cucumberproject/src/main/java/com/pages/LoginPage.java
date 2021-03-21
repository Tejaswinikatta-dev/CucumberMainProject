package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	//1locators
	private WebDriver driver;
	private By username=By.id("email");
	private By password=By.id("passwd");
	private By forgotPwdLink=By.linkText("Forgot your password?");
	private By loginBtn=By.id("SubmitLogin");
	
	// 2 contructions
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	//3Page Methods
	public String getTitle() {
		return driver.getTitle();
	}
	public boolean isFrgotPwdLinkDis() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(username).sendKeys(userName);
	}
	
	public void enterpwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	public AccountPage doLogin(String usname,String pwd) {
		driver.findElement(username).sendKeys(usname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AccountPage(driver);
		
	}
}
