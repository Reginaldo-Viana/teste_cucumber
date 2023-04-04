package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/resources/features",
        glue = { "steps" },
        tags = "@google",
        plugin = { "pretty", "html:test-output",
                "json:target/cucumber-report/cucumber.json"
        },
        dryRun = false, monochrome = true
)
public class RunnerTest {

}
