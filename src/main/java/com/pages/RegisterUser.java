package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterUser {
	
	private WebDriver driver;
	
	private By signInBtn = By.id("nav-link-accountList");
	private By createAccLink = By.xpath("//a[contains(text(),'Create your Amazon account')]");
	private By txtYourName = By.id("ap_customer_name");
	private By mobileNumber = By.id("ap_phone_number");
	private By password = By.id("ap_password");
	private By mobileNumLink = By.xpath("//div[contains(@class,'a-section a-spacing-extra-large')]//*[contains(text(),'Verify mobile number')]");
	
	public RegisterUser(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnCreateUser() {
		driver.findElement(signInBtn).click();
		driver.findElement(createAccLink).click();
	}
	
	public void registerUser() throws InterruptedException {
		driver.findElement(txtYourName).sendKeys("z");
		driver.findElement(mobileNumber).sendKeys("4664647856");
		driver.findElement(password).sendKeys("Gfiywef@1234");
		Thread.sleep(5000);
		driver.findElement(password).sendKeys(Keys.TAB);
		driver.findElement(mobileNumLink).click();
	}
	
}
