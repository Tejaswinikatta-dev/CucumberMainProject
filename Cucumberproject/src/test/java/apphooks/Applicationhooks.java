package apphooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qe.factory.DriverFactory;
import com.qe.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Applicationhooks {
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	private WebDriver driver;
	Properties prop;
	
	@Before(value="@skip_scenario",order=0)
	public void skipscenario(Scenario sc) {
		
		System.out.println("Skipped Scenario Name"+sc.getName());
		Assume.assumeTrue(false);
	}
	@Before(order=1)
	public void getProperty() {
		configReader=new ConfigReader();
		prop=configReader.init_Properties();
		System.out.println(prop);
	}
	
	@Before(order=2)
	public void launch_Browser(Scenario sc){
		String browser=prop.getProperty("browser");
		System.out.println("-------------------*********---------------");
		System.out.println("browser");
		
		driverFactory=new DriverFactory();
		if(browser.equalsIgnoreCase("saucelab")) {
			driver=driverFactory.setUpSauce("chrome", "windows 10", "85.0", sc.getName());
		}
		else {
			driver=driverFactory.init_driver(browser);
		}
		
		
	}
	
	@After(order=0)
	public void quitBrowser(){
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()) {
			String screeshotName=scenario.getName().replaceAll(" ", "_");	
			byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screeshotName);
			
		}
		
	}

}
