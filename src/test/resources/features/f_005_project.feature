#Feature: Project Class
#
#  Scenario: making a new Project with an empty name
#    When attempt to make a new Project with an empty name must throw an error
#
#  Scenario: making a new Project with an null name
#    When attempt to make a new Project with a null name must throw an error
#
#  Scenario: making a new Project with valid data must successfully return a new Project object
#    When attempt to make a new Project with a valid name and projectManager must return a new Project object
#
#  Scenario Outline: making a new project successfully with a few ProjectManagers
#    Given a new project named <ProjectName> with a projectManager firstName <firstName> lastName <lastName> and emailAddress <emailAddress> is made
#    When adding a new projectManager with correct firstName <secondFirstName> lastName <SecondlastName> and emailAddress <secondEmailAddress>
#    Then the project must have two projectManagers
#    And the projectManagers ID must be equal to the user ID of User and secondUser.
#    Examples:
#      | ProjectName         | firstName   | lastName  | emailAddress              | secondFirstName | SecondlastName | secondEmailAddress         |
#      | "Sample Project 1"  | "John"      | "Doe"     | "johnDoe@abcCompany.com"  | "Jacob"         | "Sorensen"    | "JacobSo@abcCompany.com"   |
#      | "Test Project"      | "Jack"      | "Nick"     | "jackNi@abcCompany.com"  | "Roberto"         | "Carlos"    | "RobeCa@abcCompany.com"   |
#
#
#  Scenario: Attempt to removing the only ProjectManager of a Project must throw an error
#    Given a new Project named "Sample" with a projectManager firstName "John" lastName "Doe" and emailAddress "john.d@sample.com" is made
#    When attempt to remove the ProjectManager of the Project must throw an error
#
#  Scenario: Changing the name of a Project
#    Given a new Project named "Sample" with a projectManager firstName "John" lastName "Doe" and emailAddress "john.d@sample.com" is made
#    When changing the name of the Project to "New Name"
#    Then the name of the Project must be "New Name"
#
#  Scenario: Changing the name of a Project with an empty name
#    Given a new Project named "Sample" with a projectManager firstName "John" lastName "Doe" and emailAddress "john.d@sample.com" is made
#    When changing the name of the Project to "" must throw an error
#
#  Scenario: Changing the name of a Project with a null name
#    Given a new Project named "Sample" with a projectManager firstName "John" lastName "Doe" and emailAddress "john.d@sample.com" is made
#    When changing the name of the Project to null must throw an error
#
#  Scenario Outline: removing the ProjectManager of a Project that has two project managers must successfully remove the ProjectManager
#    Given a new project named <ProjectName> with a projectManager firstName <firstName> lastName <lastName> and emailAddress <emailAddress> is made
#    And adding a new projectManager with correct firstName <secondFirstName> lastName <SecondlastName> and emailAddress <secondEmailAddress>
#    When removing the first projectManager
#    Then the project must have one projectManager
#    And the projectManager ID must be equal to the user ID of secondUser.
#    Examples:
#      | ProjectName | firstName | lastName | emailAddress | secondFirstName | SecondlastName | secondEmailAddress |
#      | "Sample Project 1"  | "John"      | "Doe"     | "johnDoe@abcCompany.com"  | "Jacob"         | "Sorensen"    | "JacobSo@abcCompany.com"   |
#
#  Scenario Outline: attempt to removing a projectManager from the project while user was not the project manager
#    Given a new project named <ProjectName> with a projectManager firstName <firstName> lastName <lastName> and emailAddress <emailAddress> is made
#    And adding a new projectManager with correct firstName <secondFirstName> lastName <SecondLastName> and emailAddress <secondEmailAddress>
#    When removing the projectManager with a projectManager firstName "Lary" lastName "Black" and emailAddress "Lary@black.com" must throw an error
#    Examples:
#      | ProjectName | firstName | lastName | emailAddress | secondFirstName | SecondLastName | secondEmailAddress |
#      | "Sample Project 1"  | "John"      | "Doe"     | "johnDoe@abcCompany.com"  | "Jacob"         | "Sorensen"    | "JacobSo@abcCompany.com"   |
