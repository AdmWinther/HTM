Feature: Organization Class

  Scenario Outline: making a new organization with wrong data
    Given the server is running
    When the server is running
    When new organization with name <name> first name <firstName> lastName <lastName> and emailAddress <emailAddress> throws error <error>
    Examples:
    | name          | superUserFirstName  | lastName    | emailAddress    | error                             |
    | "Abc Company" | ""                  | "Doe"       | ""              | "Name is required"                |
    | ""            | "John"              | "Doe"       | "john@doe.com"  | "Organization name is required"   |
#    | "Abc Company" | ""                  | "Doe"       | "john@doe.com"  | "Name is required"                |
#    | "Abc Company" | "John"              | ""          | "john@doe.com"  | "Lastname is required"            |
#    | "Abc Company" | "John"              | "Doe"       | ""              | "Email address is required"       |
#    | "Abc Company" | "John"              | "Doe"       | "john"          | "Email address is not correct"    |
#    | ""            | "John"              | "Doe"       | "john@doe.com"  | "Organization Name is required"   |

  Scenario: making a new Organization with User with company name
    Given the server is running
    When the server is running
    When attempt to make a new user with name "John" lastName "Doe" and emailAddress "John@Doe.com" must be successful