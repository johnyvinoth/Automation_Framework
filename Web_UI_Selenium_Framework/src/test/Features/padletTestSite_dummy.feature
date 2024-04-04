Feature: Test padlet test site login

  @SmokeTest
  Scenario Outline: Login to Padlet test site
    Given Login to padlet site in "<browserName>" browser

    Examples:
      | browserName |
      | chrome      |
