package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\Users\\2303700\\eclipse-workspace\\GSDAutomation\\FeatureFiles\\login.feature"}, glue = "stepDefinitions")
public class testRun {
	
	
	

}