package runnerCucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features" , 
				glue = {"stepDefinition"},
				plugin= {"html:Repor/cumcumber-report", 
						"json:Repor/cucumber_report.json",
						"pretty:Repor/pretty_report.text",
						"usage:Repor/usage_report.json",
						"junit:Repor/cumber_junit.xml"}
				)
public class TestRunner {

}
