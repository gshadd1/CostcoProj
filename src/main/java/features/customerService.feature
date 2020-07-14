#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
    
Feature:  Customer Service Page
Scenario: Verify Customer Servie Links
Given user is already on Costco Customer Service Page
When title of page Customer Service  
Then user clicks on one of the service buttons
|servicebutton | 
|returns       |


Then page for associated button will appear
Then verify the corect page
Then users close the browser
   
