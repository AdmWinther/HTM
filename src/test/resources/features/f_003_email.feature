Feature: Email

  Scenario: Check if a String is an email, the email address must include an @
    Given the server is running
    When "abcdefgh.com" is passed to Email.isEmail
    Then the method Email.isEmail must return false

  Scenario: Check if a String is an email, the email address must include an .
    Given the server is running
    When "abcd@efghcom" is passed to Email.isEmail
    Then the method Email.isEmail must return false

  Scenario: Check if a String is an email, the email address must include at least one character before the @
    Given the server is running
    When "@abc.com" is passed to Email.isEmail
    Then the method Email.isEmail must return false

  Scenario: Check if a String is an email, the email address must include at least three character between the @ and .
    Given the server is running
    When "a@bc.com" is passed to Email.isEmail
    Then the method Email.isEmail must return false

  Scenario: Check if a String is an email, the email address must include at least two character after the .
    Given the server is running
    When "a@bc.c" is passed to Email.isEmail
    Then the method Email.isEmail must return false

  Scenario: Check if a String is an email, a valid email address must be approved
    Given the server is running
    When "a@abc.de" is passed to Email.isEmail
    Then the method Email.isEmail must return true

  Scenario: make a new Email, if the constructor is called with a valid email address, a new object Email must be created
    Given the server is running
    When "a@abc.de" is passed to Email constructor
    Then the method Email must return a not null object Email

  Scenario: make a new Email, if the constructor is called with an invalid email address, a null object Email must be created
    Given the server is running
    When the server is running
    Then Trying to make a new Email with argument abc@d.com must throw an exception "Invalid email address"
