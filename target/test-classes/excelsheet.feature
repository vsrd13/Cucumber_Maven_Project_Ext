Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |

  Scenario Outline: Verifying Excel Sheet Functionality
    Given I want to write the excel reports <name>
    When I want to check for the <value> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |

  Scenario Outline: Writing Excel Sheet for the third time
    Given I want to write the excel sheet with third test <name>
    When I want to check for the third test <value> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |

      
      