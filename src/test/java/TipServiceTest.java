import org.example.TipService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 500, 999})
        void shouldTenPercentTips(int sum) {
        BigDecimal amount = new BigDecimal(sum);
        assertEquals(amount.multiply(BigDecimal.valueOf(1.1)), new TipService().roundTips(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 1001, 5000})
    void shouldFivePercentTips(int sum) {
        BigDecimal amount = new BigDecimal(sum);
        assertEquals(amount.multiply(BigDecimal.valueOf(1.05)), new TipService().roundTips(amount));
    }

}

