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


  Scenario: Call the police data api with different locations
    Given  requests with the following  <latitude> <longitude> <date>
    When http status is 200
    Then the possible value are <result>

    Examples:
      | latitude    | longitude | date      |
      | 0           | 0         | 0         |
      | 53.947659   | -1.071358 | 2017-12   |
      | -1.071358   | 53.947659 | 2017-12   |
      | 53.947659   | -1.071358 | 2017-13   |
      | 53.947659   | -1.071358 | 0000-00   |
      | -91.00000   | 181.00000 | 0000-00   |

    Examples:
    | result    |
    | A         |
    | B         |
