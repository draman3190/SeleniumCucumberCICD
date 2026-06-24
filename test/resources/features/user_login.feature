Feature: User Login

  As a registered user
  I want to log in with my credentials
  So that I can access the dashboard

    Scenario: The user logs in successfully with valid credentials
      Given the user is on the login page
      When the user enters a valid username and password
      And clicks the login button
      Then the user should be redirected to the dashboard