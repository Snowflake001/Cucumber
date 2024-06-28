package testRunner;

import io.cucumber.testng.CucumberOptions;
import stepDefinitions.BaseClass;

@CucumberOptions(
		
		features = {"src/test/resources/Features/filter.feature"},
		glue="stepDefinitions",
		dryRun = false ,
		monochrome = true,
		tags = "@login",//scenarios under @sanity tag will be executed
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		)


public class Runner extends BaseClass{

}