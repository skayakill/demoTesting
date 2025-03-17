package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/resources/features",
        glue = "stepDef",
        tags = "@Positive or @Negative",
        plugin = {"pretty", "html:target/Regression.html"}
)
public class testRun {

}
