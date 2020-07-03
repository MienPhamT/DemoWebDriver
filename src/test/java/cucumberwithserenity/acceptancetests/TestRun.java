package cucumberwithserenity.acceptancetests;

import com.google.gson.internal.bind.util.ISO8601Utils;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/", glue="cucumberwithserenity.steps")
public class TestRun {
}
