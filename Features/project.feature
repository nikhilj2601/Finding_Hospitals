Feature: Run the project

	Scenario: testing the Practo
		
		Given get City and get Doctor type
		When Filter the Doctor as per Requirement
		Then get Doctor Names,  Expierence, and Fees
		When click on Surgeries
		Then print all the Surgies names
		When click the Workplace Health
		When enter the Wrong Details
		Then check the submit button is diaplayed or not
		When enter the Correct Details
		Then check the ThankYou message 