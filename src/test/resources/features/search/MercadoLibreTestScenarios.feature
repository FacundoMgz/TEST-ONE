Feature: test MercadoLibre functionality

  @cucumber
  Scenario: Test Searching for Zapatos on MercadoLibre
    Given I am on MercadoLibre homepage
    When I search for zapatos
    Then I display the number of results

#    And I filter Puma on brands
#    And I filter size 10
#    Then I display the number of results
#    When I order the results placing lower prices first
#    Then I select the first 5 results
#    And I display the name and prices of the first 5 results
#    When I order the results by distance and filter by condition Nuevo con defectos
#    Then I display the name and prices of the first 5 results
#    When I order the results placing higher prices first
#    Then I display the name and prices of the first 5 results