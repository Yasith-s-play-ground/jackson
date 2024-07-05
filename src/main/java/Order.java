import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Order(Integer id,
                    String customerName,
                    BigDecimal total,
                    @JsonFormat(pattern = "yyyy-MM-dd")/* if this pattern is not applied we get date in milliseconds */
                    LocalDate date) { /* jackson doesn't convert anything in java.time package ( LocalDate ) */
}
