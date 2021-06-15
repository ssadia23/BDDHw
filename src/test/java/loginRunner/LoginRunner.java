package loginRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:features", 
		glue="defSteps", 
		tags ="@Bank",
		monochrome=true, 
		dryRun=false, 
		plugin= { "pretty", "html:target/cucumber", "json:target/cucumber.json" } 
		
		)

public class LoginRunner {

}
