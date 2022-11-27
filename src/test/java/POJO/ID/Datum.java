package POJO.ID;

import java.util.Date;

public class Datum {

    public int id;
    public String name;
    public String symbol;
    public String slug;
    public int rank;
    public int displayTV;
    public int is_active;
    public Date first_historical_data;
    public Date last_historical_data;
    public Platform platform;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDisplayTV() {
        return displayTV;
    }

    public void setDisplayTV(int displayTV) {
        this.displayTV = displayTV;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public Date getFirst_historical_data() {
        return first_historical_data;
    }

    public void setFirst_historical_data(Date first_historical_data) {
        this.first_historical_data = first_historical_data;
    }

    public Date getLast_historical_data() {
        return last_historical_data;
    }

    public void setLast_historical_data(Date last_historical_data) {
        this.last_historical_data = last_historical_data;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

}
