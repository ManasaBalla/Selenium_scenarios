package com.source;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (plugin= {"pretty","html:target/cucumber"}, 
							features = "src/test/java/com/source/", 
							glue = "com/source/", 
							tags= "@TheInternet_CheckBoxes"
				)

public class TestRunner{

}
