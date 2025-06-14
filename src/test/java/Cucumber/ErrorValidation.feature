
Feature: Login Error validation of an Ecommerce site
  I want to use this template for my feature file

  

  @ErrorValidation
  Scenario Outline: Positive test for Login Error validation
    Given I landed on Ecommerse site
    When logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
    
   Examples: 

    | name                  | password | 
    | dsribas623@gmail.com  | Srijit@8 |