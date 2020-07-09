#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
    
Feature:  Login to Costco
Scenario: Login to Costco with correct  username and password
Given Navigate to Costco Home Page
When title of Home Page is Costco
Then I enter the following Login
  | username | password|
  | goodName | goodPw  |

And I click on login button
Then I should see the userform page
Then user close the browser


Scenario: Login to Costco with incorrect  username and password
Given Navigate to Costco Home Page
When title of Home Page is Costco
Then I enter the following Login
  | username | password|
  | badName  | badPw   |

And I click on login button
Then I should see invalid username or password
Then user close the browser