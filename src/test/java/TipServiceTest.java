import org.example.TipService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipServiceTest {

    @ParameterizedTest(name = "итерация #{index}: Сумма покупки {0}")
    @ValueSource(doubles = {1, 100.01, 500, 999, 999,99})
    @DisplayName("Чаевые 10%")
        public void TipsTenPercent(double sum) {
            BigDecimal amount = new BigDecimal(sum);
            assertEquals(amount.multiply(BigDecimal.valueOf(1.1)), new TipService().roundTips(amount));
    }

    @ParameterizedTest(name = "итерация #{index}: Сумма покупки {0}")
    @ValueSource(doubles = {1000, 1000.01, 1001, 5000})
    @DisplayName("Чаевые 5%")
        public void TipsFivePercent(double sum) {
            BigDecimal amount = new BigDecimal(sum);
            assertEquals(amount.multiply(BigDecimal.valueOf(1.05)), new TipService().roundTips(amount));
    }

    @Test
    @DisplayName("Сумма покупки равна 0")
        public void ZeroTest() {
            assertEquals(BigDecimal.ZERO.multiply(BigDecimal.valueOf(1.1)), new TipService().roundTips(BigDecimal.ZERO));
    }

    @Test
    @DisplayName("Сумма покупки отрицательное число")
        public void NegativeTest() {
            BigDecimal amount = new BigDecimal("-1");
            assertEquals(amount.multiply(BigDecimal.valueOf(1.1)), new TipService().roundTips(amount));
    }


}

