package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {".//Feature/IncubyteAccount.feature"},
		glue="StepDefinetion",
		dryRun = true,
		monochrome = true,
		tags = "@MissingFirstName",//scenarios under @sanity tag will be executed
		plugin = {"pretty","html:Reports/cucumber-reports/reports_html.html"}
		)
public class Run extends AbstractTestNGCucumberTests{

}
