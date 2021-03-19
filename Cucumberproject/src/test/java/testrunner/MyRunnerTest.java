package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/" ,"rerun:target/failedrerun.txt"}, 
		monochrome = true,
		//tags= "not @skip_scenario",
		features = { "src/test/resources/features" }, 
		glue = { "stepdefinitions", "apphooks" },
		 publish = true
		
		)
public class MyRunnerTest {
}
