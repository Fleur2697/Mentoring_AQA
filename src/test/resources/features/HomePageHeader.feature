Feature: Homepage header
  As a guest user
  I want to see main header elements
  So I can easy understand navigation

  Scenario: Basic header elements are present on the Homepage
    Given I am guest user
    When I open the page "HomePage"
    Then singInRegister, Navigation Menu and Banner are displaying
