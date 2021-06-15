@Login 
Feature: Validate TechFios login functionality using scenario outline 

#Background: 
#	Given User is on the techfios login page

@Scenario1 
Scenario: User should be able to login with valid credentials 
	Given User is on the techfios login page 
	When User enters username "demo@techfios.com" 
	When User enters password "abc123"
	And User clicks signin button
	Then User should be landing on the Dashboard page
