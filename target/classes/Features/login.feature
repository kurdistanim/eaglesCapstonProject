Feature: Login to Retail website
# In feature will be use a comment
# Every Feature file starts with Feature: <Name of Feature>

@login @Regression @SmokeTest
Scenario: Login to MyAccount

Given User is on Retail Website
When User click on MyAccount
And User click on Login
And User enter userName 'eagles@tekschool.us' and password 'eagles'
And User click on login button
Then User should be logged in to my Account Dashboard

#instead of writting this scenation 3 times and changing values 
#cucumber provides scenario outline with examples keyword to do 
#data driven testing
@test
Scenario Outline: Login to MyAccount with Multiple users

Given User is on Retail Website
When User click on MyAccount
And User click on Login
And User enter userName '<userName>' and password '<password>'
And User click on login button
Then User should be logged in to my Account Dashboard

Examples:
|username|password|
|eagles@tekschool.us|eagles|
|hawks@tekschool.us|hawks|
|falcons@tekschool|falcons|