Feature: OrangeHRM Login Test

  @test
  Scenario Outline: OrangeHRM Login Data Driven
    Given I launch FireFox browser
    When I open orange hrm homepage
    And I enter Email as "<username>" and Password as "<password>"
    And I click on Login button
    And I click on User Dropdown arrow
    And I click on Logout
    And I close browser

    Examples:
    | username  | password   |
    | Admin     | admin123   |
    | Admin2314 | admin87689 |