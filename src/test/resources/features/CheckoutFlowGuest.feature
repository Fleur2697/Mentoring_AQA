Feature: Checkout flow for Guest user
  As a guest user
  I want to perform Checkout flow
  So I can place the order


  Scenario: guest user adds products to the basket page and starts Checkout flow
    Given I am guest user
    And I open the page "HomePage"
    And I enter to search field test product "1934793" and click on the Search button
    And I click on the product name reference on PLP
    And I click on Add to Cart button on PDP
    When I click on Checkout button on Added to Cart popup
    Then I see Total and Subtotal on Basket page and they are
    | subTotal | total  |
    | $99.85   | $99.85 |
    And I click on the bottom Checkout button
    And I enter my email "test@user.com" to Email and Confirm email fields
    And I click on "Checkout as Guest" button
    And I see Total and Subtotal on Shipment page
    | subTotal  | total  | taxes                          |
    |  $99.85   | $99.85 | Your order includes $4.75 tax. |




