Feature: Backend Tasks

  @BackendTask @BackendTask1
  Scenario: Convert IDs to Bolivian
    Given I retrieve ID for "BTC,USDT,ETH"
    Then Convert price to "VES"

  @BackendTask @BackendTask2
  Scenario: Check Logo and other fields
    Given Retrieve ID of "ETH"
    Then Check logo of ETH
    Then Confirm that the technical_doc Url is present
    Then Confirm that the symbol of the currency is ETH
    Then Confirm that the date added
    Then Confirm that the currency has not the mineable

  @BackendTask @BackendTask2
  Scenario: Check mineable tag on first 10 cryptocurrencies
    Given Retrieve the first "1,2,3,4,5,6,7,8,9,10" currencies
    Then Check which 10 currencies have the mineable
    Then Verify that the correct cryptocurrencies have been printed out



