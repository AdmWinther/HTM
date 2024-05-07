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

#  Scenario Outline: making a new project successfully with a few ProjectManagers
#    Given a new project with correct user as a projectManager
#    When adding a new projectManager with correct firstName <secondFirstName> lastName <SecondlastName> and emailAddress <secondEmailAddress>
#    Then the project must have two projectManagers
#    And the projectManagers ID must be equal to the user ID of User and secondUser.
#    Examples:
#      | name          | firstName   | lastName  | emailAddress              | secondFirstName | SecondlastName | secondEmailAddress         |
#      | "Abc Company" | "John"      | "Doe"     | "johnDoe@abcCompany.com"  | "Jacob"         | "Sorensen"    | "JacobSo@abcCompany.com"   |
#      | "Abc Company" | "Jack"      | "Nick"     | "jackNi@abcCompany.com"  | "Roberto"         | "Carlos"    | "RobeCa@abcCompany.com"   |


  Scenario: Attempt to removing the only ProjectManager of a Project must throw an error

  Scenario: Changing the name of a Project

  Scenario: Changing the name of a Project with an empty name

  Scenario: Changing the name of a Project with a null name

  Scenario: removing the ProjectManager of a Project

  Scenario: attempt to removing a projectManager from the project while user was not the project manager

  Scenario: attempt to removing a user from the project while user was in the project
