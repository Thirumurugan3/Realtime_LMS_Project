Feature: Login
  Scenario Outline: Login Test

    Given user data "<Testcase_ID>"
    When user enters credentials
    Examples:
      | Testcase_ID |
      | TC_001      |
      | TC_002      |