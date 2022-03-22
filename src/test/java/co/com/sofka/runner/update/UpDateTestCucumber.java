package co.com.sofka.runner.update;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/update/update.feature"},
        glue = {"co.com.sofka.stepdefinition.update"},
        tags = ""
)
public class UpDateTestCucumber {
}
