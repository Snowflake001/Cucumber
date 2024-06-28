Feature: Verify login functionality of Sauce Demo
@login
Scenario Outline: verify login function of Sauce Demo
Given User launches the browser
When User opens sauce Labs url
And user enters "<username>" and "<password>"
And Clicks on login
Then Homepage gets opened
Then User Selects A to Z filter and validate
Then User Selects Z to A filter and validate
Then User Selects Low to High Filter and validate
Then User Selects High to Low Filter and validate

Examples:
|username     | password |
|standard_user| secret_sauce|
#|visual_user  | secret_sauce|