Feature: Verify login functionality of Sauce Demo
@login
Scenario Outline: verify login function of Sauce Demo
Given User launches the browser
When User opens sauce Labs url
And user enters "<username>" and "<password>"
And Clicks on login
Then Homepage gets opened

Examples:
|username     | password |
|standard_user| secret_sauce|
|visual_user  | secret_sauce|