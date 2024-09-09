Feature: Test comments section


#  Scenario Outline: Add comment with parameters
#    Given Login to padlet site in "<browserName>" browser
#    When user click on Add comment and enters a new comment "<newComment>"
#    Then comment is added to the section
#    Examples:
#      | browserName | newComment     |
#      | chrome      | Testing        |
##      | safari      | Safari_Testing |

  @SITest
  Scenario Outline: Add comment with logged in user
#    Given Login to padlet test site
    Given Login to padlet site in "<browserName>" browser
    When user logs into the padlet site with valid login
    When user click on Add comment and enters a new comment "<newComment>"
    Then comment is added to the section
    Then user logout from the padlet site
    Examples:
      | browserName | newComment |
      | chrome      | Testing    |
#
#  Scenario Outline: Add comment with parameters
#    Given Login to padlet site in "<browserName>" browser
#    When user click on Add comment and enters a new comment "<newComment>"
#    Then comment is added to the section
#    Examples:
#      | browserName | newComment  |
#      | firefox     | Testing5456 |