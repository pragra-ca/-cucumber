Feature: Verify the course info data
  Scenario: Pull the data for particular course id
    Given We have access to url "https://app.pragra.io/api"
    When  we will call api with course id "6116c308df858e6d5ed1507b" to path "/course-info/{id}"
    Then  we should get status 200
    And   course name should be "FullStack - Java"