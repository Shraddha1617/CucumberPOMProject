package StepDefinitions;

import org.testng.Assert;

import com.pages.PhoneFIlter;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class PhoneFilterSteps {
	
	private PhoneFIlter phoneFilter = new PhoneFIlter(DriverFactory.getDriver());
	
	@Given ("user search for {string}")
	public void user_search(String value) {
		DriverFactory.getDriver().get("https://www.amazon.in");
		phoneFilter.enterValueInSearchField(value);
	}
	
    @When ("apply the filter as brand realme")
    public void apply_the_filter() {
    	phoneFilter.applyBrandFilter();
    }
    
    @Then ("filter list should be displayed")
    public void filter_list_should_be_displayed() {
    	String value = phoneFilter.filterValues();
    	Assert.assertTrue(value.contains("realme"));
    }
}
