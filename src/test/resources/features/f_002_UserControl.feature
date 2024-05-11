Feature: User Class

  Scenario: get a random user
    Given the server is running the app
    When the client calls the url "user/generateRandomUser"
    Then the client receives a response with a random user
    And the client receives status code of 200