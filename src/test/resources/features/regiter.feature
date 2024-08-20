@Register
Feature: Register
  @validRegister
  Scenario: Successful register
    Given User is on the register page
    And : Register username with "Registariuser"
    And : Register password with "secret_sauce"
    When : User click  register button
    Then User receives alert register successfull
    And : User is on homepage
  @invalidRegister
  Scenario: Unsuccessful register
    Given User is on the register page
    And : Register username with "invalid_user"
    Then : User click  register button
    And : User see error register message