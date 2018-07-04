Feature: Crimes at a location

   In order to returns just the crimes which occurred at the specified location
   As a client
   I want to to be informed  within a radius.

  Scenario: A client call the police data api  with a specific location
    Given a request with the details
      | location  |  date   |
      | 883373    | 2017-02 |
    When the client receive the status 200
    Then the client result  is "anti-social-behaviour"


