Feature: Add Customer
Background: Common Steps for all Scenarios
		Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/admin/"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And User click on Login button
    Then User can view Dashboard
	
	@Regression
	Scenario: Add New Customer
    When User click on customers Menu
    And Click on customers Menu Irem
    And Click on Add New button
    Then User can view Add New customer page 
    When User enter customer information
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And User close browser
    
    @Regression
    Scenario: Search Customer by Email
    		When User click on customers Menu
    		And Click on customers Menu Irem
    		And Enter customer Email
    		When Click on search button
    		Then User should found Email in the Search table
    		And User close browser
    
    @Regression		
    Scenario: Search Customer by Name
    		When User click on customers Menu
    		And Click on customers Menu Irem
    		And Enter customer FirstName
    		And Enter customer LastName
    		When Click on search button
    		Then User should found Name in the Search table
    		And User close browser
