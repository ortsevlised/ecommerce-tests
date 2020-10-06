@Api
Feature: Testing the weather API

  @This
  Scenario Outline: Checkin temperature appears in C and F
    Given the weather app is running
    When I search for the temperature in ireland in <format> format
    Then  I get a response where "<response>"

    Examples:
      | format | response                            |
      | SI     | temp.units is C and temp.value < 20 |
      | US     | temp.units is F and temp.value < 70 |
