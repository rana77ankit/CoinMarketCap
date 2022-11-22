package stepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;


public class apiRunSteps {

    @Given("I retrieve ID of BTC USDT ETH")
    public void retrieveIDs() {

        String resp = given()
                .header("X-CMC_PRO_API_KEY", "ba99e6c0-2649-4522-89d8-acc535051c2b")
//                .queryParams("symbol","{BTC,ETH}")
                .queryParam("symbol","ETH")
//                .queryParam("symbol","BTC")
                .log().all()
                .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest")
                .then()
                .log().all()
                .extract().asString();

        JsonPath js = new JsonPath(resp);
        System.out.println("YYYYYYYYYYY[1]: " + js.prettyPrint());






    }
}
