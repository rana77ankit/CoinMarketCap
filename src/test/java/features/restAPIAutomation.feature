Feature: Backend Tasks

  @BackendTask @BackendTask1
  Scenario: Convert IDs to Bolivian
    Given I retrieve ID of BTC USDT ETH


#  Backend Task1
#  1. Retrieve the ID of bitcoin (BTC), usd tether (USDT), and Ethereum (ETH), using the
#  /cryptocurrency/map call.
#  2. Once you have retrieved the IDs of these currencies, convert them to Bolivian
#  Boliviano, using the /tools/price-conversion call.
#  Backend Task2
#  1. Retrieve the Ethereum (ID 1027) technical documentation website from the
#  cryptocurrency/info call.
#  2. Confirm that the following logo URL is present:
#
#  “logo”: https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png.
#  3. Confirm that the technical_doc Url is present:
#  “technical_doc”: [ https://github.com/thereum/wiki/wiki/White-Paper ]
#  4. Confirm that the symbol of the currency is ETH: “symbol”: “ETH”
#  5. Confirm that the date added is: “date_added”: “2015-08-07T00:00:00.000Z”
#  6. Confirm that the currency has the mineable tag associated with it:
#  "tags": [ "mineable" ]
#  Backend Task3 (Extra points)
#  1. Retrieve the first 10 currencies from the cryptocurrency/info call (ID 1, 2, 3 ... 10).
#  2. Check which currencies have the mineable tag associated with them.
#  3. Verify that the correct cryptocurrencies have been printed out.