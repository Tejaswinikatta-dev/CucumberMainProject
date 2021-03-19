package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	private WebDriver driver;
	
	private By accountsections=By.cssSelector("div[class='row addresses-lists'] span");
	
	//1 constructior
	public AccountPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getaccountpageTitle() {
		return driver.getTitle();
	}
	
	public int countOfAccountSection() {
		return driver.findElements(accountsections).size();
	}
	
	public List<String> getAccountSectionList() {
		List<String> sectionList=new ArrayList<>();
		List<WebElement> elements=driver.findElements(accountsections);
		for(WebElement e:elements) {
			String text=e.getText().toLowerCase();
			sectionList.add(text);
		}
		return sectionList;
	}

}
