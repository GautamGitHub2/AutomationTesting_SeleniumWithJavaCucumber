package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {".//Features/OrangeHRM.feature"},
                glue ="stepDefinitions",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty", "html:test-output"},
                tags = "@sanity"
        )
public class TestRun {
}

//{".//Features/Login.feature",".//Features/Customers.feature"},GumtreeCarsAndVehicles.feature
