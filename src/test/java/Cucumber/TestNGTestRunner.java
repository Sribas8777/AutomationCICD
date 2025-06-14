package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//To run Cucumber feature files ,its take help from TestNG or JUnit , we can choose then as per the project framework
@CucumberOptions(features="src/test/java/Cucumber",glue="SrijitLearning.StepDefinetion",
monochrome=true, tags="@Regression", plugin= {"html:target/cucumber.html"}) //it will only run the regression test
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
