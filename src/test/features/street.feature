Feature: Crime at Street Level

   In order to returns just the crimes street-level
   As a client
   I want to to be informed  either within a 1 mile radius of a single point

  Scenario: A client call the police data api  with a single point
    Given a request with the values
      | latitude    | longitude | date      |
      | 52.629729   | -1.131592 | 2017-01   |
    When the response status is 200
    Then the category has value "other-theft"