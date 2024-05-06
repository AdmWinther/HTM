Feature: Project Class

  Scenario: making a new Project with an empty name
    When attempt to make a new Project with an empty name must throw an error

  Scenario: making a new Project with an null name
    When attempt to make a new Project with a null name must throw an error

  Scenario: making a new Project with valid data must successfully return a new Project object
    When attempt to make a new Project with a valid name and projectManager must return a new Project object

  Scenario: Changing the ProjectManager of a Project
    Given a Project with a ProjectManager
    When attempt to change the ProjectManager of the Project
    Then the ProjectManager of the Project must be changed