Feature: Search and place the order for the Products

  Scenario: Search experience for the product search in both Home page and Offers page

    Given User is on GreenKart Landing page
    When User search with shortname "Tom" and extracted actual name of the product
    Then User search for "Tom" shortname in offers page
    And Validate product name in Offers page matches with Landing page