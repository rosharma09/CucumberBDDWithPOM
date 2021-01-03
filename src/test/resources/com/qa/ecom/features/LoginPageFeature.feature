Feature: Login page features
  In order to login to the application, the user is provided the login page

  Scenario: To check the page title is displayed correctly
    Given User is on login page
    Then Title of the page is displayed as "Login - My Store"

  Scenario: In case the user forgets the password, the user can recall the password using the
    			forgot password link

    Given User is on login page
    Then Forgot password link is displayed
    When User clicks on forgot password link
    Then Title of the page is displayed as "Forgot your password - My Store"

  Scenario: To check that the user is able to log into the application using the valid credentials
    Given User is on login page
    Then Username and password fields are displayed
    When User enter the "TestEcomUser@gmai.com" and "Password001"
    And Click on the login button
    Then Title of the page is displayed as "My account - My Store"

  Scenario: In order to search an item on ecom application, the search bar should be displayed
    Given User is on login page
    Then search bar is displayed

  Scenario: Under the my account section in the footer, the various option are displayed
    Given User is on login page
    Then The below metioned hyperlinks are avaiable
      | My orders        |
      | My credit slips  |
      | My addresses     |
      | My personal info |
