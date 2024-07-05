 Feature: User Class

  Scenario Outline: making a new user with wrong data
    When attempt to make a new user while any of name <name> lastName <lastName> emailAddress <emailAddress> password <password> and userRole <userRole> are invalid must throw an error error <error>
    Examples:
      | name    | lastName| emailAddress  | password                                                      | userRole| error                           |
      | ""      | "Doe"   | "john@doe.com"| "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq"| "Admin" | "User name is required"         |
      | "John"  | ""      | "john@doe.com"| "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq"| "Admin" | "User lastname is required"     |
      | "John"  | "Doe"   | ""            | "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq"| "Admin" | "User email address is required"|
      | "John"  | "Doe"   | "john@doe.com"| ""                                                            | "User"  | "User password is required"     |
      | "John"  | "Doe"   | "john@doe.com"| "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq"| ""      | "User role is required"         |
      | "John"  | "Doe"   | "john@doe.com"| "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq"| "Chief" | "User role is not valid"        |

  Scenario: making a new user with correct data
    Given attempt to make a new user with name "John" lastName "Doe" and emailAddress "John@Doe.com" password "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq" and userRole "Admin"
    When the user is created
    Then the user name is "John"
    And the user has an ID