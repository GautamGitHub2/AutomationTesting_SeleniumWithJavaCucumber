Feature: GumtreeCarsAndVehicles
  Background: Below are the common steps for each scenarios
    Given User Launch Safari browser
    When User opens URL "https://www.gumtree.com/"

  Scenario: Click on Vans from the Cars & Vehicles Grid
    Given User Mouse hover at the Cars & Vehicles Grid
    When User click on Vans link
    And close browser
