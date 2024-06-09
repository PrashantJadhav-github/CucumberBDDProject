Feature: Login Functionality

  @Sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/admin/"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And User click on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    And User close browser
    
  @Regression    
  Scenario Outline: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/admin/"
    And User enters Email as "<email>" and Password as "<password>"
    And User click on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    And User close browser
    
 Examples:
 |email|password|
 |admin@yourstore.com|admin|
 |test@yourstore.com|admin|