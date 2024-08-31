Feature: OrangeHRM Login
  Scenario: Logo presence on OrangeHRM home Page
    Given I launch safari browser
    When I open orange hrm homepage
    Then I verify that the logo present on homepage
    And close browser


