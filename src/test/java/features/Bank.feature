@Bankinfo
Feature: Techfios bank and cash New Account Functionality

Background:
Given User is on the TechFios login page
	
@Bank
Scenario Outline: User should be able to login with valid credentials and open a new account	
	When User enters the "<username>" and "<password>"  
	And  User clicks on login button
	Then User should be able to see the dashboard
	When User clicks on bank and cash 
	When User clicks on new account 
	When User fill up the form entering "<accountTitle>"and "<description>"and "<initialBalance>"and "<accountNumber>"and "<contactPerson>"and "<phone>"and "<internetBankingUrl>" clicks on submit 
	Then User should be able to validate new account created
	Examples:
	
	|username          | password | accountTitle | description| initialBalance | accountNumber | contactPerson | phone    | internetBankingUrl     |
	|demo@techfios.com | abc123   | Thingymiggy  | lalalala   | 999999999.99   | 0123456789000 | Obama         | -666-6666| https://www.google.com/|
	
	