Feature: Project Class

  Scenario: making a new Project with an empty name
    When attempt to make a new Project with an empty name must throw an error

  Scenario: making a new Project with an null name
    When attempt to make a new Project with a null name must throw an error

  Scenario: making a new Project with valid data must successfully return a new Project object
    When attempt to make a new Project with a valid name and projectManager must return a new Project object

  Scenario: Changing the ProjectManager of a Project
    Given a Project with a ProjectManager is made
    When attempt to change the ProjectManager of the Project
    Then the ProjectManager of the Project must be changed

  Scenario: Changing the name of a Project
    Given a Project with a name is made
    When attempt to change the name of the Project to a valid name
    Then the name of the Project must be changed


  Scenario: Changing the name of a Project with an empty name
    Given a Project with a name is made
    When attempt to change the name of the Project with an empty name
    Then must throw an error saying "The new project name cannot be empty

  Scenario: Changing the name of a Project with a null name
    Given a Project with a name is made
    When attempt to change the name of the Project with a null name
    Then must throw an error saying "The new project name cannot be null"

  Scenario: removing the ProjectManager of a Project
    Given a Project with a ProjectManager is made
    When attempt to remove the ProjectManager of the Project
    Then must throw an error saying "The ProjectManager cannot be null"

  Scenario: attempt to removing a user from the project while user was not in the project
    Given a Project with a ProjectManager is made
    When attempt to remove a user from the project while user was not in the project
    Then must throw an error saying "The user is not in the project"

  Scenario: attempt to removing a user from the project while user was in the project
    Given a Project with a ProjectManager is made
    When attempt to remove a user from the project while user was in the project
    Then the user must be removed from the project