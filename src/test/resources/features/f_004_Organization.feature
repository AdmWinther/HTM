Feature: Organization Class

  Scenario Outline: making a new organization with wrong data
    When attempt to make a new organization with invalid name <name> firstName <firstName> lastName <lastName> and emailAddress <emailAddress> must throw an <error>
    Examples:
      | name          | firstName | lastName  | emailAddress    | error                               |
      | "Abc Company" | ""        | "Doe"     | ""              | "User name is required"             |
      | ""            | "Babak"   | "Doe"     | "john@doe.com"  | "Organization name too short, the minimum length is 3 characters."     |
      | "Abc Company" | ""        | "Doe"     | "john@doe.com"  | "User name is required"             |
      | "Abc Company" | "Martin"  | ""        | "john@doe.com"  | "User lastname is required"         |
      | "Abc Company" | "Robert"  | "Doe"     | ""              | "User email address is required"    |
      | "Abc Company" | "Pernille"| "Doe"     | "john"          | "User email address is not correct" |
      | "as"            | "Luise"   | "Doe"     | "john@doe.com"  | "Organization name too short, the minimum length is 3 characters."     |


  Scenario Outline: making a new organization successfully with correct data
    When attempt to make a new organization with correct name <name> firstName <firstName> lastName <lastName> and emailAddress <emailAddress> must succeed
    Then the organization must have the correct name <name> firstName <firstName> lastName <lastName> and emailAddress <emailAddress>
    And the organization must have an id
    Examples:
      | name          | firstName   | lastName  | emailAddress              |
      | "Abc Company" | "John"      | "Doe"     | "johnDoe@abcCompany.com"  |
      | "Abc Company" | "Jacob"     | "Sørensen"| "johnDoe@abcCompany.com"  |

  Scenario Outline: making a new organization successfully with a few SuperUsers
    Given a new organization with correct name <name> firstName <firstName> lastName <lastName> and emailAddress <emailAddress>
    When adding a few SuperUsers with correct firstName <secondFirstName> lastName <SecondlastName> and emailAddress <secondEmailAddress>
    Then the organization must have two SuperUsers
    And the superUsers ID must be equal to the user ID of User and secondUser.
    Examples:
      | name          | firstName   | lastName  | emailAddress              | secondFirstName | SecondlastName | secondEmailAddress         |
      | "Abc Company" | "John"      | "Doe"     | "johnDoe@abcCompany.com"  | "Jacob"         | "Sorensen"    | "JacobSo@abcCompany.com"   |
      | "Abc Company" | "Jack"      | "Nick"     | "jackNi@abcCompany.com"  | "Roberto"         | "Carlos"    | "RobeCa@abcCompany.com"   |

    Scenario: making a new organization with a null User must throw an error
      When attempt to make a new organization with correct name <name> but a null User must throw an error