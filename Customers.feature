Feature: Customers
  Scenario: Add a new Customer
    Given User Launch Firefox browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customer Menu
    And click on customer menu item
    And click on add new button
    Then User can view add new customer page
    When user enter customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And User can close browser