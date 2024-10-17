Feature: calculator

  Scenario: add two number

    Given jbgroup is an user in the calculator

    When he want to add "4" + "5"

    Then he expected the result should be "9"