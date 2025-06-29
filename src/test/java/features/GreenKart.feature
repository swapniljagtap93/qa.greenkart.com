@Test
Feature: Search and place the order for the Products

  Scenario: Search experience for the product search in both Home page and Offers page

    Given User is on GreenKart Landing page
    When User searched with shortname "Pot" and extracted actual name of product
    And User click on Top Deals link in the Landing Page
    Then User searched for "Pot" shortname in offers page
    And Validate product name in offers page matches with Landing page

  Scenario: Verify all the products from the landing page has prices
    Given User is on GreenKart Landing page
    When User fetches all the products from the landing page
    Then User should see all the products and their prices