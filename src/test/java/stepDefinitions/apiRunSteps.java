package stepDefinitions;

import POJO.ID.Datum;
//import POJO.mineable.Datum;
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

    @Given("Retrieve the first {string} currencies")
    public void retrieveTheFirstCurrencies(String value) {

        mine = given()
            .header("X-CMC_PRO_API_KEY", BaseClass.prop.getProperty("xAPIKey"))
            .queryParam("id", value)
            .when()
            .get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/info")
            .as(Mine.class);


        Assert.assertNotNull(mine.getData().get_1().getSymbol());
        Assert.assertNotNull(mine.getData().get_2().getSymbol());
        Assert.assertNotNull(mine.getData().get_3().getSymbol());
        Assert.assertNotNull(mine.getData().get_4().getSymbol());
        Assert.assertNotNull(mine.getData().get_5().getSymbol());
        Assert.assertNotNull(mine.getData().get_6().getSymbol());
        Assert.assertNotNull(mine.getData().get_7().getSymbol());
        Assert.assertNotNull(mine.getData().get_8().getSymbol());
        Assert.assertNotNull(mine.getData().get_9().getSymbol());
        Assert.assertNotNull(mine.getData().get_10().getSymbol());

    }

    @Then("Check which {int} currencies have the mineable")
    public void checkWhichCurrenciesHaveTheMineable(int value) {

        boolean mineable = false;
        ArrayList<String> tags1 = mine.getData().get_1().tags;
        for (String tag : tags1) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags2 = mine.getData().get_2().tags;
        for (String tag : tags2) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags3 = mine.getData().get_3().tags;
        for (String tag : tags3) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags4 = mine.getData().get_4().tags;
        for (String tag : tags4) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags5 = mine.getData().get_5().tags;
        for (String tag : tags5) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags6 = mine.getData().get_6().tags;
        for (String tag : tags6) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags7 = mine.getData().get_7().tags;
        for (String tag : tags7) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags8 = mine.getData().get_8().tags;
        for (String tag : tags8) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags9 = mine.getData().get_9().tags;
        for (String tag : tags9) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);

        mineable = false;
        ArrayList<String> tags10 = mine.getData().get_10().tags;
        for (String tag : tags10) {

            if (tag.contains("mineable")) {
                mineable = true;
                break;
            }
        }
        Assert.assertTrue(mineable);
    }

    @Then("Verify that the correct cryptocurrencies have been printed out")
    public void verifyThatTheCorrectCryptocurrenciesHaveBeenPrintedOut() {

        Assert.assertEquals(mine.getData().get_1().getSymbol(),BaseClass.prop.getProperty("crypto1"));
        Assert.assertEquals(mine.getData().get_2().getSymbol(),BaseClass.prop.getProperty("crypto2"));
        Assert.assertEquals(mine.getData().get_3().getSymbol(),BaseClass.prop.getProperty("crypto3"));
        Assert.assertEquals(mine.getData().get_4().getSymbol(),BaseClass.prop.getProperty("crypto4"));
        Assert.assertEquals(mine.getData().get_5().getSymbol(),BaseClass.prop.getProperty("crypto5"));
        Assert.assertEquals(mine.getData().get_6().getSymbol(),BaseClass.prop.getProperty("crypto6"));
        Assert.assertEquals(mine.getData().get_7().getSymbol(),BaseClass.prop.getProperty("crypto7"));
        Assert.assertEquals(mine.getData().get_8().getSymbol(),BaseClass.prop.getProperty("crypto8"));
        Assert.assertEquals(mine.getData().get_9().getSymbol(),BaseClass.prop.getProperty("crypto9"));
        Assert.assertEquals(mine.getData().get_10().getSymbol(),BaseClass.prop.getProperty("crypto10"));
    }
}
