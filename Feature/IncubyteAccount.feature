Feature: Login

@CreateAccount
 Scenario Outline:Successful Create an Account with valid data
	Given User Launch Chrome browser 
	When User opens URL "https://magento.softwaretestingboard.com/" 
	And  Click on Create an Account Link
	And User enters FirstName as"<first>" and LastName as "<last>" and Email as "<email>" and Password as "<password>" and ConfirmPass as "<confirmP>"
	And Click on Create an Account
	Then Page Title should be "Thank you for registering with Main Website Store." 
	And close browser 

Examples:

  | first|last   |     email              |password|confirmP|
  | Raj  |Patidar|raj12345678912@gmail.com|Raj@1234|Raj@1234|

	
@MissingFirstName
 Scenario Outline:Successful Create Account with Missing First Name
	Given User Launch Chrome browser 
	When User opens URL "https://magento.softwaretestingboard.com/" 
	And  Click on Create an Account Link
	And User enters  LastName as "<last>" and Email as "<email>" and Password as "<password>" and ConfirmPass as "<confirmP>"
	And Click on Create an Account
	Then Error Message should be "This is a required field." 
	And close browser 

Examples:

  |last   |   email                |password|confirmP|
  |Patidar|raj12345678912@gmail.com|Raj@1234|Raj@1234|
	
	
	
	
	
@SignIn
 Scenario Outline:Successful User Successful SignIn
	Given User Launch Chrome browser 
	When User opens URL "https://magento.softwaretestingboard.com/" 
	And  Click on Sign-In Link
	And User enters Email as "<emailSign>" and Password as "<passwordSign>"
	And Click on SignIn button
	Then Page Title should be "My Account"
	And close browser 

Examples:

 |     emailSign      |passwordSign|
 |yogesh@gmail.com    |Yogesh@1234|
	
	
	
	