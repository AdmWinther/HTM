Feature: the version can be retrieved

  Scenario: Reading app.roles from application.properties
    Given the server is running App_Prop
    When the client calls app_config_getRoles
    Then the client receives app.roles

  Scenario: Reading app.domain from application.properties
    Given the server is running App_Prop
    When the client calls app_domain
    Then the app_domain is equal to "http://localhost:3000"

  Scenario: Reading app.verbose from application.properties
    Given the server is running App_Prop
    When the client calls app_verbose
    Then the app_verbose is equal to True