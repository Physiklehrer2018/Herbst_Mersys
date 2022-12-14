package ui.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtilities;
import utils.Driver;
import java.io.File;
import java.time.Duration;

public class Hooks {

   // public static WebDriver driver;

    @Before  // burda kütüphane olarak cucumber secilmeli
    public void setUp() {
     //   driver = Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    }

    @After   // burda kütüphane olarak cucumber secilmeli
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take that screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attach the scenario to the report
            scenario.attach(screenshot, "image/png", scenario.getName() + "_screenshot");
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            // full path to the screenshot location
            String target = System.getProperty("user.dir") + "/test.feature-output/Screenshots/"
                    + source.getName() + "png";
            File finalDestination = new File(target);
        }
        BrowserUtilities.waitFor(3);
        Driver.closeDriver();
    }
}
