
@tag
Feature: Purchase the order from the Ecommerse website
  I want to use this template for my feature file
  
  Background: 
  Given I landed on Ecommerse site


  @Regression
  Scenario Outline: Positive Test of submitting the order
    Given logged in with username <name> and password <password>
    When I add product <productname> to cart 
    And  checkout product<productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page

    Examples: 
      | name                  | password | productname  |
      | dsribas623@gmail.com  | Srijit@87| ZARA COAT 3  |
      
