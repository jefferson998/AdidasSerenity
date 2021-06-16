package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(Cucum)
@CucumberOptions(
        features = "src/test/resources/features/AdidasFallido.feature",
        glue="stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AdidasBadRunner {
}
