package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        features = "./src/test/java/features",
        glue = { "stepDefinitions" }
//       ,tags = "@predefined"
)
public class TestRunner extends AbstractTestNGCucumberTests {}

