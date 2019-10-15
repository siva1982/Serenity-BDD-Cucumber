package com.uiautomation.steps;

import cucumber.api.java.Before;
import jline.internal.Log;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.pages.Pages;

/**
 * This is just a place holder class trying to do the UI automation work
 */

public class Hooks {

	//@Before
	public void setSessionVariables() {
		Serenity.setSessionVariable("Env").to("DEV");
		Pages pages = new Pages();
		
		//Read property name
		String url= pages.getConfiguration().getEnvironmentVariables().getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL.getPropertyName());
		Log.info("Application URL: "+ url);

		//Set Property Name
		pages.getConfiguration().getEnvironmentVariables()
		.setProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL.getPropertyName(),"http://base url place holder");
		String url2= pages.getConfiguration().getEnvironmentVariables().getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL.getPropertyName());
		Log.info("Application URL2: "+ url2);

	}
}
