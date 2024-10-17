Feature: WhenDo
  Scenario: create task
    Given eynar has access to whendo
    When he creates a new task
      |title| mobile|
      |note | this is a note|
    Then he expected the task "mobile" should be displayed

  Scenario: delete task
    Given eynar has access to whendo with 2 task
    When he deletes one task
    Then he expected the tasks count to be 1
