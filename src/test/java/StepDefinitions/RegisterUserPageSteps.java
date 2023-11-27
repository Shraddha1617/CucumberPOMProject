package StepDefinitions;

import org.testng.Assert;

import com.pages.RegisterUser;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class RegisterUserPageSteps {
	
	private RegisterUser registerUser = new RegisterUser(DriverFactory.getDriver());
	
	private static String title;
	
	@Given("user is on Home page")
	public void user_is_on_Home_page() {
		DriverFactory.getDriver().get("https://www.amazon.in");
		registerUser.clickOnCreateUser();
	}
	
	@When("add all details to register user")
	public void add_all_details_to_register_user() throws InterruptedException {
		registerUser.registerUser();
		
	}
	
    @Then("New User should be created")
    public void New_User_should_be_created() {
    	
    }

}
