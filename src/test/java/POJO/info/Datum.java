package POJO.info;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {

    @JsonProperty("ETH")
    public ETH eTH;

    public ETH geteTH() {
        return eTH;
    }

    public void seteTH(ETH eTH) {
        this.eTH = eTH;
    }
}