package BE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchID {
    public Status status;
    public Data data;
}
