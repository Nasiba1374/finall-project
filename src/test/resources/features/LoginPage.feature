Feature: Navigate to login page

  Background:
    When user click on login link

  @Scenario1
  Scenario: Navigate to login by clicking on Login button and enter valid csr user
    When user enter "supervisor" and "tek_supervisor" to signIn
    Then user click on "Sign In" button
    Then validate user in "Customer Service Portal" page

  @Scenario2
  Scenario Outline: Navigate to login and enter wrong credentials and validate error message as expected
    When user enter "<username>" and "<password>" to signIn
    Then user click on "Sign In" button
    Then validate error message "Password not matched" is displayed as expected
    Examples:
      | username   | password          |
      | supervisor | tek_supervisor222 |

  @Scenario2
  Scenario Outline:
    When user enter "<username>" and "<password>" to signIn
    Then user click on "Sign In" button
    Then wait for 1000 ms
    Then validate error message "" is displayed as expected
    Examples:
      | username     | password         |
      | supervisor23 | tek_supervisor   |
      | supervisor23 | tek_supervisor00 |

#//div[@id='chakra-modal--body-:r3:']/div/div/div/p[following-sibling::p or following-sibling::ul]
#//div[@id='chakra-modal--body-:r3:']/div/div/div/p[following-sibling::*]/following-sibling::*
#//div[@id='chakra-modal--body-:r3:']//p/following-sibling::*