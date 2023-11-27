package com.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search_iPhonePage {
	
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	private By searchBar = By.id("twotabsearchtextbox");
	private By selectLink = By.xpath("//div[contains(@data-asin,'B0')]//a/*[contains(text(),'iPhone')]");
	private By price = By.xpath("//*[contains(@class,'priceToPay')]//span[@class='a-price-whole']");
	private By addToCartBtn = By.xpath("(//input[@id='add-to-cart-button'])[2]");
	private By cartSuccessMsg = By.xpath("//div[@id='attachDisplayAddBaseAlert']//h4[text()='Added to Cart']");
	private By plan = By.xpath(" //*[contains(text(),'Add a Protection Plan')]");
	
	public static String price1;
	
	public Search_iPhonePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterValueInSearchField(String searchValue) {
		driver.findElement(searchBar).sendKeys(searchValue);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
	}
	
	public void selectValue() throws InterruptedException {
		List<WebElement> values = driver.findElements(selectLink);
		for(int i=0; i<=values.size(); i++) {
			values.get(0).click();
			Thread.sleep(5000);
			break;
		}
	}
	
	public String navigateToProductDetailPage() throws InterruptedException {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				price1 = driver.findElement(price).getText();
//				System.out.print(price1);
				Thread.sleep(5000);
				js.executeScript("arguments[0].scrollIntoView();", plan);
				driver.findElement(addToCartBtn).click();
				addedToCart();
				driver.close();
			}
		}
		//switch to the parent window
		driver.switchTo().window(parent);
		return price1;
		}
	
	public String addedToCart() {
		String successMsg = driver.findElement(cartSuccessMsg).getText();
		System.out.println(successMsg);
		return successMsg;
	}
	
}
