package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhoneFIlter {
	
	private WebDriver driver;
	
	private By searchBar = By.id("twotabsearchtextbox");
	private By brandFilter = By.xpath("//div[@id='brandsRefinements']/ul/span/li//label/i");
	private By filterVal = By.xpath("//div[contains(@data-asin,'B0')]//div/h2/a/span");
	

	public PhoneFIlter(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterValueInSearchField(String searchValue) {
		driver.findElement(searchBar).sendKeys(searchValue);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
	}
	
	public void applyBrandFilter() {
		List<WebElement> values = driver.findElements(brandFilter);
		for(int i=0; i<=values.size(); i++) {
			values.get(0).click();
			break;
		}
	}
	
	public String filterValues() {
		List<WebElement> allValues = driver.findElements(filterVal);
		String value = null;
		for(WebElement e : allValues) {
			value = e.getText();
		}
		return value;
	}
	
	

}
