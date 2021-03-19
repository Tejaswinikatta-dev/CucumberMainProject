package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qe.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageStepDefinition {
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;

	@Given("the user has alreaddy loggedin into application")
	public void the_user_has_alreaddy_loggedin_into_application(DataTable dataTable) {
		List<Map<String, String>> li = dataTable.asMaps();
		String username = li.get(0).get("username");
		String pwd = li.get(0).get("password");
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage = loginpage.doLogin(username, pwd);

	}

	@Given("User is on accounts page")
	public void user_is_on_accounts_page() {

		String title = accountPage.getaccountpageTitle();
		System.out.println("ttile of account page::" + title);
	}

	@Then("user gets the accounts sections")
	public void user_gets_the_accounts_sections(DataTable dataTable) {
		List<String> expectedvalues = dataTable.asList();
		List<String> actualValues = accountPage.getAccountSectionList();
		Assert.assertTrue(expectedvalues.containsAll(actualValues));
	}

	@Then("sections count should be {int}")
	public void sections_count_should_be(Integer expectedcount) {
	
		int actualcount= accountPage.countOfAccountSection();
		Assert.assertTrue(actualcount==expectedcount);
	}

}
