Feature: Navigate to Customer Service Portal with valid CSR credentials and navigate to Plans Page

  Background:
    When user click on login link
    When user enter "supervisor" and "tek_supervisor" to signIn
    Then user click on "Sign In" button
    Then validate user in "Customer Service Portal" page
    When user click on "Plans" link

  Scenario:  Validate 4 row of data is present
    Then user validate four row of data is present

  Scenario: validate Create Date is today date in (EST Time zone) and
  Date Expire is a day after (EST Time Zone)
    When user validate create date is today date (EST Time zone) and expire date is tomorrow date (EST Time zone)