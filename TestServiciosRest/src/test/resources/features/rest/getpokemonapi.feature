Feature: Get Pokemon Information
  As a user of PokeAPI
  I want to get information about a specific Pokemon
  So that I can learn more about it

  @GetPokemonInfo
  Scenario Outline: Get Pokemon Information Successful
    Given the user has a valid authentication token
    When the user sends a GET request to <endpoint> with the '<name>' of the Pokemon
    Then the user receives a <status> response code and the '<type>' and '<ability>' of the Pokemon
    Examples:
      | name       | status | type     | ability |
      | pikachu    | 200    | Electric | Static  |
      | charmander | 200    | Fire     | Blaze   |
      | missingno  | 404    | ''       | ''      |