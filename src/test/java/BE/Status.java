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
public class Status {
    public Date timestamp;
    public int error_code;
    public String error_message;
    public int elapsed;
    public int credit_count;
    public String notice;
}
