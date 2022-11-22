Feature: Frontend Tasks

  @FrontendTask @FrontendTask1
  Scenario: Verify that last row is displayed or not
    Given I open url "https://coinmarketcap.com/"
    When Scroll to Show rows to 100
    Then Verify that 100 rows are displayed

  @FrontendTask @FrontendTask2
  Scenario: Verify that correct records are displayed as per the filter applied
    Given I open url "https://coinmarketcap.com/"
    When Click on Filters button
    And Filter records by MarketCap $1B to $10B and Price $101 to $1000
    Then Check records displayed on page are correct as per the filter applied