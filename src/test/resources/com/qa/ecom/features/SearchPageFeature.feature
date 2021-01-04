Feature: Search item feature
  
  In order to search a product on the shopping website, 
  the user can use the search bar to search for  a particular item

  Background: 
    Given User has already logged into the application
      | Username              | Password    |
      | TestEcomUser@gmai.com | Password001 |

  #
  #Scenario Outline: User searches for the following item using the search field
  #Given User is on Home page
  #When User search for the following "<Searched Item>"
  #Then User is displayed items as per the "<productDisplayedCount>"
  #
  #Examples:
  #| Searched Item         | product A price | product B price | product C price | productDisplayedCount |
  #| printed Summer Dress  | $28.98          | $30.50          | $16.40          |                     3 |
  #| printed chiffon dress | $16.40          | $30.50          | $0              |                     2 |
  #
  #Scenario: User search with out providing any search keyword
  #Given User is on Home page
  #When User search for the following ""
  #Then User is displayed "Please enter a search keyword" on the UI
  
  #Scenario Outline: Invalid search
    #Given User is on Home page
    #When User search for the following "<Invalid searches>"
    #Then No results were found for your search "<Invalid searches>" message is displayed to the user
#
    #Examples: 
      #| Invalid searches |
      #| apple watch SE   |
      #| google           |
      #| test user        |
      
   
