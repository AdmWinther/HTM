Feature: the version can be retrieved

  Scenario: client makes call to GET /version
    Given the server is running
    When the client calls "version"
    Then the client receives server version
    And the client receives status code of 200