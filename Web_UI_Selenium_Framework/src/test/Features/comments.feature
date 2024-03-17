Feature: Test comments section
#
#  Scenario: Add a new comment
#    Given Login to padlet site in chrome browser
##    When user click on Add comment and enters a new comment
#    Then comment is added to the section


  Scenario Outline: Add comment with parameters
    Given Login to padlet site in "<browserName>" browser
    When user click on Add comment and enters a new comment "<newComment>"
    Then comment is added to the section
    Examples:
      | browserName | newComment  |
      | chrome      | Testing     |
#      | firefox     | Testing5456 |