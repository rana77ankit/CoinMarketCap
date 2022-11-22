package BE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BTC {
    public int id;
    public String name;
    public String symbol;
    public String slug;
    public int num_market_pairs;
    public Date date_added;
    public List<String> tags;
    public int max_supply;
    public int circulating_supply;
    public int total_supply;
    public int is_active;
    public String platform;
    public int cmc_rank;
    public int is_fiat;
    public String self_reported_circulating_supply;
    public String self_reported_market_cap;
    public String tvl_ratio;
    public Date last_updated;
    public Quote quote;
}
