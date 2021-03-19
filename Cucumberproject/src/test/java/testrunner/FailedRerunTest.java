package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "@target/failedrerun.txt" }, glue = { "stepdefinitions", "apphooks" },
		// tags= "@smoke",
		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/" ,"rerun:target/failedrerun.txt"}, monochrome = true, publish = true)


public class FailedRerunTest {

}
