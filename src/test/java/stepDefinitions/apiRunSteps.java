package stepDefinitions;

import POJO.ID.Datum;
import POJO.ID.FetchID;
import POJO.convert.Convert;
import POJO.info.Info;
import POJO.mineable.Mine;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class apiRunSteps {

    private FetchID fetch;
    private Info info;
    private Mine mine;

    //    @Given("^I retrieve ID for (.+)$")
    @Given("I retrieve ID for {string}")
    public void iRetrieveIDFor(String crypto) {

        fetch = given()
            .header("X-CMC_PRO_API_KEY", BaseClass.prop.getProperty("xAPIKey"))
                .queryParam("symbol", crypto)
            .when()
            .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map")
            .as(FetchID.class);

        List<Datum> id = fetch.getData();
        for(int i=0; i<id.size(); i++) {

            Assert.assertEquals(id.get(i).id, Integer.parseInt(BaseClass.prop.getProperty(""+id.get(i).symbol+"_id")));
        }
    }

    @Then("Convert price to {string}")
    public void convertPriceTo(String convert) {

        List<Datum> id = fetch.getData();
        for(int i=0; i<id.size(); i++) {

            Convert con = given()
                .header("X-CMC_PRO_API_KEY", BaseClass.prop.getProperty("xAPIKey"))
                    .queryParam("id", id.get(i).id)
                    .queryParam("amount", "100")
                    .queryParam("convert", convert)
                .when()
                .get("https://pro-api.coinmarketcap.com/v1/tools/price-conversion")
                .as(Convert.class);

            Assert.assertNotNull(con.getData().getQuote().getvES().getPrice());

        }
    }

    @Given("Retrieve ID of {string}")
    public void retrieveIDOf(String crypto) {

        info = given()
            .header("X-CMC_PRO_API_KEY", BaseClass.prop.getProperty("xAPIKey"))
                .queryParam("symbol", crypto)
            .when()
            .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/info")
            .as(Info.class);

        int ETH_id = info.getData().geteTH().getId();
        Assert.assertEquals(ETH_id, Integer.parseInt(BaseClass.prop.getProperty("ETH_id")));

    }

    @Then("Check logo of ETH")
    public void checkLogoOf() {

        String ETH_logo = info.getData().geteTH().getLogo();
        Assert.assertEquals(ETH_logo, BaseClass.prop.getProperty("ETH_logo"));
    }

    @Then("Confirm that the technical_doc Url is present")
    public void confirmThatTheTechnical_docUrlIsPresent() {

        String technical_doc = info.getData().geteTH().getUrls().getTechnical_doc().get(0);
        Assert.assertEquals(technical_doc, BaseClass.prop.getProperty("technical_doc"));

    }

    @Then("Confirm that the symbol of the currency is ETH")
    public void confirmThatTheSymbolOfTheCurrencyIsETH() {

        String symbol = info.getData().geteTH().getSymbol();
        Assert.assertEquals(symbol, BaseClass.prop.getProperty("ETH_symbol"));
    }

    @Then("Confirm that the date added")
    public void confirmThatTheDateAdded() {

        String date_added = String.valueOf(info.getData().geteTH().getDate_added());
        Assert.assertEquals(date_added, BaseClass.prop.getProperty("ETH_date_added"));
    }

    @Then("Confirm that the currency has not the mineable")
    public void confirmThatTheCurrencyHasNotTheMineable() {

        boolean flag = false;
        ArrayList<String> tags = info.getData().geteTH().getTags();
        for (String tag : tags) {

            if (tag.contains("mineable")) {
                flag = true;
                break;
            }
        }

        Assert.assertFalse(flag);
    }

    @Given("Retrieve the first {int} currencies")
    public void retrieveTheFirstCurrencies(int id) {

        for(int idx = 1; idx <= id; idx++) {

            mine = given()
                .header("X-CMC_PRO_API_KEY", BaseClass.prop.getProperty("xAPIKey"))
                .queryParam("id", idx)
                .when()
                .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/info")
                .as(Mine.class);
        }
    }

    @Then("Check which {int} currencies have the mineable")
    public void checkWhichCurrenciesHaveTheMineable(int id) {

        boolean mineable = false;
        for(int idx = 1; idx <= id; idx++) {

//            ArrayList<String> tags = mine.getData().[_idx].getTags();
//            for (String tag : tags) {
//                mineable = true;
//                break;
//            }

//            System.out.println("YYYY:"+mine.getData().geteTH().getSymbol());
//            Assert.assertFalse(mineable);
        }
    }
}
