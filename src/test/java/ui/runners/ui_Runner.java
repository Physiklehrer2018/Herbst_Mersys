package ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/default-reports.html",
                  "rerun:target/rerun.txt"},
        features = "src/test/resources/uiFeatures",
        glue = "ui/stepDefinitions",
        tags = "@smoke")

public class ui_Runner {
}
