package stepdefinitions;

import org.junit.Assert;
import com.pages.LoginPage;
import com.qe.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefinition {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println(DriverFactory.getDriver());
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		title = loginPage.getTitle();
		System.out.println("title:::"+title);
	}

	@Then("title of the page should be {string}")
	public void title_of_the_page_should_be(String expectedTitle) {

		Assert.assertEquals(title, expectedTitle);

	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {

		Assert.assertTrue(loginPage.isFrgotPwdLinkDis());
	}

	@When("user Enters Username {string}")
	public void user_enters_username(String userName) {
		loginPage.enterUserName(userName);

	}

	@When("user Enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterpwd(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() throws Exception {
		loginPage.clickLoginBtn();
		Thread.sleep(10000);
	}

}
