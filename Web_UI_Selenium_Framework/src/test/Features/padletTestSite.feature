Feature: Test padlet test site login

  Scenario Outline: Add comment with logged in user
    Given Login to padlet site in "<browserName>" browser
    When user logs into the padlet site with valid login
    Then dashboard page will be displayed

    Examples:
      | browserName |
      | chrome      |
