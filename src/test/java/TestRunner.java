import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions        (
        glue = {"stepDefs"},
        features = {"src/test/resources/features"},
        plugin = {
                "pretty",
                "html:reports/test-report.html", "json:reports/test-report.json",
        }
)
public class TestRunner {
}
