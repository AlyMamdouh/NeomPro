package ScryAIGroundX.com.qa.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
features = "classpath:/features/ForgotPassword.feature", //the path of the feature files
glue={"ScryAIGroundX.com.qa.stepdefinitions.forgotPassword","ScryAIGroundX.com.qa.commons"}, //the path of the step definition files
plugin= {"pretty", //:test-output/cucumber-pretty.txt***** Cucumber logs in cucumber-pretty.txt file with pretty
        "html:test-output/cucumber-html-report.html",
        "json:test-output/cucumber.json",
        "rerun:test-output/rerun.txt",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }, //to generate different types of reporting
monochrome = true, //display the console output in a proper readable format
dryRun = false //to check the mapping is proper between feature file and step definition file
)

public class ForgotPasswordRunner extends AbstractTestNGCucumberTests {

}