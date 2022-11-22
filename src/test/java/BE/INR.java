package BE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class INR {
    public double price;
    public double volume_24h;
    public double volume_change_24h;
    public double percent_change_1h;
    public double percent_change_24h;
    public double percent_change_7d;
    public double percent_change_30d;
    public double percent_change_60d;
    public double percent_change_90d;
    public double market_cap;
    public double market_cap_dominance;
    public double fully_diluted_market_cap;
    public String tvl;
    public Date last_updated;
}
