package com.uiautomation.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = { "src/test/resources/features/api/userActions.feature" },
		glue = {"com.uiautomation.apisteps" },
		tags = {}
		)
public class APITest {
}
