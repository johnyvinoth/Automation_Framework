Feature: Test padlet test site login

  @SmokeTest
  Scenario Outline: Login to Padlet test site
#    Given Login to padlet test site
    Given Login to padlet site in "<browserName>" browser
    When user logs into the padlet site with valid login
    Then dashboard page will be displayed
    And user logout from the padlet site
    Examples:
      | browserName |
      | firefox     |
#      | chrome      |
