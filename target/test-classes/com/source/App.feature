#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Selenium complex scenarios
   
      @Search
      Scenario: Search for a course
      Given The given url is opened and is logged in 
      When course name is searched in the search field
      Then should be able to select the given course
      
      @POMDemo
      Scenario: Demonstrating POM
      Given The url is opened
      When Select Selenium course and switch tab
   	  Then Get Title of the new tab
   	  
   	  @Myntra
   	  Scenario: Window Handling
   	  Given The url is opened and logged in
   	  When Open Aromas & Candles from Home Decor column in Home and Living category
   	  Then Add product to bag and handling cart
   	  
   	  @TheInternet_CheckBoxes
   	  Scenario: CheckBox
   	  Given URl is opened
   	  When The checkbox url is clicked
   	  Then Select the desired checkbox
   	  
   	  @TheInternet_DropDown
   	  Scenario: Drop Down
   	  Given URl is opened
   	  When The Drop down url is clicked
   	  Then Select the desired option 
   
