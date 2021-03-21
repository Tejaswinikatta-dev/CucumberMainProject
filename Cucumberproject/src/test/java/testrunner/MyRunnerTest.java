package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//tags= "not @skip_scenario",
		features = { "src/test/resources/features" }, 
		glue = { "stepdefinitions", "apphooks" },
				plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/" ,"rerun:target/failedrerun.txt"}, 
				monochrome = true,
		 publish = true
		
		)
public class MyRunnerTest {
}
