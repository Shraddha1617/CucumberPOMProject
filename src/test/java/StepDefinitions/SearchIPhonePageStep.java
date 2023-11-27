package StepDefinitions;


import com.pages.Search_iPhonePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchIPhonePageStep {
	
	private Search_iPhonePage searchPage = new Search_iPhonePage(DriverFactory.getDriver());
	
	@Given("Search for {string}")
	public void Search_iPhone(String searchValue) {
		DriverFactory.getDriver().get("https://www.amazon.in");
		searchPage.enterValueInSearchField(searchValue);
	}
	
    @When("click on the first iphone link")
    public void click_on_the_first_iphone_link() throws InterruptedException {
    	searchPage.selectValue();
    }
    
    @And("Go to the Product details and add to cart")
    public void Go_to_the_Product_details() throws InterruptedException {
    	String price = searchPage.navigateToProductDetailPage();
    	System.out.println(price);
    }
    
    @Then("Product should be added to cart")
    public void Product_should_be_added_to_cart() {
    	
    }
	
}

