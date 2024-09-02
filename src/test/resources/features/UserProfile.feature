Feature:Navigate to login and enter valid CSR credentials and navigate to
  Customer Service Portal then click on profile button
  Background:
    When user click on login link
    When user enter "supervisor" and "tek_supervisor" to signIn
    Then user click on "Sign In" button
    Then validate user in "Customer Service Portal" page
    Then user click on profile icon

  @Scenario1
  Scenario: validate information is in Profile Side Drawer is correct
    Then validate information is in Profile Side Drawer is correct

  @Scenario2
  Scenario: click on profile button and then click on Logout button
  make sure user navigate to home page
    When user click on "Logout" button
    Then validate user in "TEK Insurance App" page