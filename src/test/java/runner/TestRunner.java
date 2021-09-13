package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:Features", // features tells cucumber options where features files are located
        glue = "stepDefinitions", //glue tells cucumber options where step Definitions class located 
        tags = {"@SmokeTest"},
        dryRun= false, // dry run if sets to false checks if all steps in feature fils has steo
        monochrome= true, // if set to true, makes the console output readable.
        strict= false, // if set to fals will fail if there are pending underfined steps.
        format = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/r" 
        }


        )

public class TestRunner {

}
