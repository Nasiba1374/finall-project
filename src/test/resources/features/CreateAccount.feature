Feature: Navigate to Home page, User should navigate to Create Account

  @Scenario1
  Scenario: Navigate to Home page then click on Create Primary Account Button.
    When user click on "Create Primary Account" link
    When validate user in "Create Primary Account Holder" page


  @Scenario2
  Scenario: On Create primary account holder form fill up the form and click on create Account Button
  Validate user navigate to page and email address shows as expected.
    When user click on "Create Primary Account" link
    And user enter "randomEmail" in the "Email Address" field
    When user enter "Mathias" in the "First Name" field
    When user enter "Akowanou" in the "Last Name" field
    When user enter "employee" in the "Employment Status" field
    When user enter "11161992" in the "Date Of Birth" field
    When user select "Male" from "Gender" field
    When user select "Mr." from "Title" field
    When user select "Single" from "Marital Status" field
    Then user click on "Create Account" button
    Then validate user navigate to page and email address shows as expected

  @Scenario3
  Scenario: Create account with existing email address and validate error message as expected
    When user click on "Create Primary Account" link
    And user enter "akomas7967@gmail.com" in the "Email Address" field
    When user enter "Mathias" in the "First Name" field
    When user enter "Akowanou" in the "Last Name" field
    When user enter "employee" in the "Employment Status" field
    When user enter "11161992" in the "Date Of Birth" field
    When user select "Male" from "Gender" field
    When user select "Mr." from "Title" field
    When user select "Single" from "Marital Status" field
    Then user click on "Create Account" button
    Then validate error message "Account with email akomas7967@gmail.com is exist" is displayed as expected


  @Scenario4
  Scenario: Create Account with Age less that 18 Years Old
    When user click on "Create Primary Account" link
    And user enter "randomEmail" in the "Email Address" field
    When user enter "Mathias" in the "First Name" field
    When user enter "Akowanou" in the "Last Name" field
    When user enter "employee" in the "Employment Status" field
    When user enter "10102023" in the "Date Of Birth" field
    When user select "Male" from "Gender" field
    When user select "Mr." from "Title" field
    When user select "Single" from "Marital Status" field
    Then user click on "Create Account" button
    Then validate error message "you must be 18 years or older to create account" is displayed as expected

  @Scenario5
  Scenario: Validate Full Name display at Profile Section by clicking on profile Icon
    When user click on "Create Primary Account" link
    And user enter "randomEmail" in the "Email Address" field
    When user enter "Mathias" in the "First Name" field
    When user enter "Akowanou" in the "Last Name" field
    When user enter "employee" in the "Employment Status" field
    When user enter "11161992" in the "Date Of Birth" field
    When user select "Male" from "Gender" field
    When user select "Mr." from "Title" field
    When user select "Single" from "Marital Status" field
    Then user click on "Create Account" button
    Then validate user in "Sign up your account" page
    When user enter signUp information
    Then user click on "Submit" button
    Then validate user in "Sign in to your Account" page
    When user enter "RandomUsername" and "Akomas21" to signIn
    Then user click on "Sign In" button
    Then validate user in "Primary Account Portal" page
    Then user click on profile icon
    Then validate full name display at profile section