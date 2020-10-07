Feature: Creating a new appointment

Background:
  Given the user is on the form page

  @Appointment
  Scenario: Creating a new appointment
    Given the user fills up the form with valid data
    When he submits the form
    Then a pop up with free slots appears

#