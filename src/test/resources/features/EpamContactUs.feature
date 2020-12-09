# new feature
# Tags: optional

Feature: Address on the Contact Us page
  As a guest user
  I want to see address
  So I can find EPAM

  @RunMe
  Scenario: Find and Parse Address
    Given I am guest user
    When I open the page "EpamContactUs"
    Then I see address
      | country | city    | postcode | streetName       | streetNumber |
      |  USA    | Newtown | PA 18940 | University Drive | 41           |
