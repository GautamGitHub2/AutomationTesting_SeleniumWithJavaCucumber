Feature: GumtreeSearchCars
  Background: Below are the common steps for each scenarios
    Given User Launch Safari browser
    When User opens URL "https://www.gumtree.com/"

 Scenario: Search Cars from search box
   Given User Enters Cars at the search box Gumtree
   When User click on ENTER button
   And close browser
