Feature: Testing of OrangeHRM Website

  Background: Below are the common steps for each scenario
    Given I launch FireFox browser
    When I open orange hrm homepage
    Then I login to the OrangeHRM page with Username and Password
    And I click on Login button

  @regression
  Scenario: Logo presence on OrangeHRM home page
  Given I launch FireFox browser
  When I open orange hrm homepage
  Then I verify that the logo present on page
  And I close browser

  @sanity
  Scenario: Testing of Login to the OrangeHRM and User Drop-downs
    #And I verify Dashboard Title "OrangeHRM" at dashboard page of OrangeHRM
    And I click on User Dropdown arrow
    And I click on About
    And I close About Window
    And I click on User Dropdown arrow
    And I click on Support
    And I click on User Dropdown arrow
    And I click on Change Password
    And I click on User Dropdown arrow
    And I click on Logout
    And I close browser

  @sanity
  Scenario: Testing of Admin Menu Item at Left Navigation Panel
    And I click on Left Navigation Button
    And I click on Right Navigation Button
    And I click on Admin Menu Item
    #And I verify Admin Dashboard Title "User Management"
    And I click on User Dropdown arrow
    And I click on Logout
    And I close browser

  @gautam
  Scenario: Testing of Left Navigation Panel / Menu Items
    And I click on Left Navigation Button
    And I click on Right Navigation Button
    And I click on Left Navigation Panel All Menu Items One By One
    And I click on User Dropdown arrow
    And I click on Logout
    And I close browser

  @testingAtAdminPage
  Scenario: Testing at Admin Page (Select and Delete Selected Record)
    And I click on Left Navigation Button
    And I click on Right Navigation Button
    And I click on Admin Menu Item
    And I click on Reset Button
    And I click on Search Button
    #And I click on 1st Row Checkbox
    #And I click on Delete Selected Button to Delete the selected row or user
    #And I click on Cancel button at the pop up window
    And I click on User Dropdown arrow
    And I click on Logout
    And I close browser

    @testingAtAdminPageTopBarMenu
    Scenario: Testing at Admin Page Top-bar Menu
      And I click on Left Navigation Button
      And I click on Right Navigation Button
      And I click on Admin Menu Item
      And I Navigate to Topbar Menu and Clicking Top Bar Menu One By One
      And I click on User Dropdown arrow
      And I click on Logout
      And I close browser