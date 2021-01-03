Feature: Search item feature
  
  In order to search a product on the shopping website, 
  the user can use the search bar to search for  a particular item

  Background: 
    Given User has already logged into the application
      | Username              | Password    |
      | TestEcomUser@gmai.com | Password001 |

  Scenario: User searches for the following items using the search field
    Given User is on Home page
    Then User search for the following
    	|Searched Item|product A price|product B price|product C price|
      | printed Summer Dress  | $28.98 |$30.50 |$16.40 |
      | printed chiffon dress | 
      | printed summer dress  | 
