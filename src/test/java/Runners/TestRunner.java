
package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        //glue is where we can find the implementation for gherkin steps
        //here we provide the path of our steps package
        glue = "steps",
        //if we set dryRun to true, then no actual execution happens
        //it will quickly scan all gherkin steps whether they have implementation or not
        dryRun = false,
        //it keeps the console output for the cucumber test easily readable
        //it will remove all the unreadable character
        monochrome = true,
        tags = "@dashboard"
        //strict=true, it check all the steps definition
)

public class TestRunner {
}
