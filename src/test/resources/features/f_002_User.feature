Feature: User Class

  Scenario Outline: making a new user with wrong data
    Given the server is running
    When the server is running
    When attempt to make a new user with name <name> lastName <lastName> and emailAddress <emailAddress> must throw an error error <error>
    Examples:
      | name    | lastName    | emailAddress    | error                           |
      | ""      | "Doe"       | ""              | "Name is required"              |
      | ""      | "Doe"       | "john@doe.com"  | "Name is required"              |
      | "John"  | ""          | "john@doe.com"  | "Lastname is required"          |
      | "John"  | "Doe"       | ""              | "Email address is required"     |
      | "John"  | "Doe"       | "john"          | "Email address is not correct"  |

  Scenario: making a new user with correct data
    Given the server is running
    When the server is running
    When attempt to make a new user with name "John" lastName "Doe" and emailAddress "John@Doe.com" must be successful