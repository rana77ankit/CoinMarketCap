package POJO.convert;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {

    @JsonProperty("VES")
    public VES vES;

    public VES getvES() {
        return vES;
    }

    public void setvES(VES vES) {
        this.vES = vES;
    }

}
