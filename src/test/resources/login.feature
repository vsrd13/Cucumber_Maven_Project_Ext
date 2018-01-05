Feature: About Smoke Login Functionality
  
  In order to ensure Facebook Login and RaightStart UserRegistration Functionality works fine,
  I want to run the cucumber test to verify it is working

##  #@Sanity @Regression
 ## Scenario Outline: Login Functionality
 ##   Given user navigates to URL with excel row "<row_index>" dataset
   ## When user logs in using with excel row "<row_index>" dataset
    ##And clicked on login button
    ##Then login should be successful
    ##And user click on the logout button
    ##Then logout should be successful

    #Then Close the Browser
    ####Examples: 
      ##| row_index |
      ##|         1 |
      

  #|         2 |
  Scenario Outline: Right Start Login Functionality
    Given User navigates to URL with excel row "<row_index>" dataset
    When User enter data using with excel row "<row_index>" dataset
    Then click on signIn button
    Then Login should be successful
    
    Examples: 
      | row_index |
      |         1 |
