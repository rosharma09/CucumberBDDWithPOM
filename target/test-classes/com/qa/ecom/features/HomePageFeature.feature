Feature: Home page Feature
  
  On logging in to the application with valid credentials the user can perform certain sprecific operation like placing order 
  searching the application for products, check the orders places and payments, and add to cart feature.

  Background: 
    Given User has already logged into the application
      | Username              | Password    |
      | TestEcomUser@gmai.com | Password001 |

  Scenario: If a user logs into the application using valid credentials
    Given User is on Home page
    Then Title of the page is displayed as "My account - My Store"

  Scenario: If the user is logged in to the application,
    	Here you can manage all of your personal information and orders.

    Given User is on Home page
    Then the following options are displayed to the user
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |

  Scenario Outline: The user can click on the various options displayed on the account section
    Given User is on Home page
    When User clicks on the "<Account links>" link

    Examples: 
      | Account Links             |
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      
    Scenario: Once logged into the system, the uesr header info is displayed to the user Ex: Sign out and the user name
   	Given User is on Home page
    Then User info header is displayed 
   
