Feature: User Class

  Scenario Outline: making a new user with wrong data
    When attempt to make a new user with name <name> lastName <lastName> and emailAddress <emailAddress> must throw an error error <error>
    Examples:
      | name    | lastName    | emailAddress    | error                           |
      | ""      | "Doe"       | ""              | "User name is required"              |
      | ""      | "Doe"       | "john@doe.com"  | "User name is required"              |
      | "John"  | ""          | "john@doe.com"  | "User lastname is required"          |
      | "John"  | "Doe"       | ""              | "User email address is required"     |
      | "John"  | "Doe"       | "john"          | "User email address is not correct"  |

  Scenario: making a new user with correct data
    Given attempt to make a new user with name "John" lastName "Doe" and emailAddress "John@Doe.com"
    When the user is created
    Then the user name is "John"
    And the user has an ID