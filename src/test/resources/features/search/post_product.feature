@feature:searchProduct
Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  @positive
  Scenario Outline: Search available product
    Given call endpoint for <product>
    When the response code is 200
    Then verify the results displayed for <product>

    Examples:
      | product |
      | "apple" |
      | "mango" |
      | "tofu"  |

  @negative
  Scenario: Search unavailable product
    Given call endpoint for "car"
    Then  verify the results does not displayed for unavailable product

