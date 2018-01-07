Feature: About Smoke Login Functionality
  
  In order to ensure Facebook Login and RaightStart UserRegistration Functionality works fine,
  I want to run the cucumber test to verify it is working


  Scenario Outline: Right Start Login Functionality
    Given User navigates to URL with excel row "<row_index>" dataset
    When User enter data using with excel row "<row_index>" dataset
    Then click on signIn button
    Then Login should be successful
    
    Examples: 
      | row_index |
      |         1 |

    

  