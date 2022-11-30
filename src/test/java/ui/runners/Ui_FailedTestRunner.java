package ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-report.html"},
        features = "@target/rerun.txt",
        glue = "src/test/java/ui/stepDefinitions"
)

public class Ui_FailedTestRunner {
}
