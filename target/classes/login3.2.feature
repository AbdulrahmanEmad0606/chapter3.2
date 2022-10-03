###########################################################
## For the duplicated annotations ##
############################################################

Feature: Login Functionality
	In order to do internet banking
	As a valid Para Bank customer
	I want to login successfully
	
Scenario: Login Successful
Given I am in the login page of the Para Bank Application
When I enter valid credentials
Then I should be taken to the Overview page
Scenario: Login Successful


Given I am in the login page 
When I enter valid credentials
Then I should be taken to the Overview page


###########################################################
## For the scenario outline && Hooks ##
############################################################
#Feature: Login Functionality
#	In order to do internet banking
#	As a valid Para Bank customer
#	I want to login successfully
#
#Scenario Outline: Login Successful
    #Given I am in the login page of the Para Bank Application
    #When I enter valid <username> and <password>
    #Then I should be taken to the Overview page
    #
    #Examples:
    #|username|password|
    #|"abdo"|"123456"|
    #|"abdo2"|"123456"|


###########################################################
## For data table ##
############################################################
#
 #Feature: Login Functionality
#	In order to do internet banking
#	As a valid Para Bank customer
#	I want to login successfully
    #
#Scenario: Login Successful - Inline Parameters
#Given I am in the login page of the Para Bank Application
#When I enter valid credentials
        #|abdo|123456|
#Then I should be taken to the Overview page



###########################################################
## Dependency injection ##
############################################################
#
#Feature: Login Functionality 
#	In order to do internet banking
#	As a valid Para Bank customer
#	I want to login successfully
#
#Scenario Outline: Login Successful
    #Given I am in the login page of the Para Bank Application
    #When I enter valid <username> and <password> with <userFullName>
    #Then I should be taken to the Overview page
#
#Examples:
    #|username|password|userFullName|
    #|"abdo"|"123456"|" x s"|
    #|"abdo2"|"123456"|" k k"|