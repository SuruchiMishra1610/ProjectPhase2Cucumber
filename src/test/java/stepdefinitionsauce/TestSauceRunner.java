package stepdefinitionsauce;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome = true,
		plugin = {"html:target/html-cucumber","json:target/cucumber.json"},
		features = "src/test/java/featuresphase2",
		glue = "stepdefinitionsauce",
		tags = {"@sanity or @regression"}
		
		)

public class TestSauceRunner {
	
	

}
