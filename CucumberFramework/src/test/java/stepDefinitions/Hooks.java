package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	@After
	public void afterScenario() throws IOException
	{
		testContextSetup.testBase.webDriverManager().quit();
	}
@AfterStep
public void addScreenshot(Scenario scenario) throws IOException
{
	WebDriver driver = testContextSetup.testBase.webDriverManager();
	if(scenario.isFailed())
	{
		File sourcepath =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcepath);
		scenario.attach(fileContent, "image/png", "image");
	}
}
}
