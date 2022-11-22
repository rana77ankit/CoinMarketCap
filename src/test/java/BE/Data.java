package BE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    public BTC bTC;
}
