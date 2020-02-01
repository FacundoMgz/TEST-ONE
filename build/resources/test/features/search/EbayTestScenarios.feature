Feature: test Ebay functionality

  @cucumber
  Scenario: testing Ebay
    Given I am on Ebay homepage
    When I search for "zapatos"
    When I filter "Puma" on brands
    And I filter size 10
    Then I get some results
    When I order the results ascendantly

