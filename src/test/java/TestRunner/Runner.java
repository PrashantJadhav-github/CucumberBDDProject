package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//features = ".//Features/AddCustomer.feature",
		features = ".//Features/",
		glue = "StepDefinition",
		//tags = "@Sanity",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports/reports12.html"}
		)

//Generating Reports in different format
//html format - plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
//json format - plugin = {"pretty","json:target/cucumber-reports/reports_json.json"}
//html format - plugin = {"pretty","junit:target/cucumber-reports/reports_xml.xml"}

public class Runner extends AbstractTestNGCucumberTests{

}
