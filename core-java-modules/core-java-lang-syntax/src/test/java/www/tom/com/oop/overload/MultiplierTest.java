package www.tom.com.oop.overload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class MultiplierTest {
    Multiplier multiplier=null;
    @BeforeEach
    void setUp() {
          multiplier = new Multiplier();

    }

    @Test
    public void whenCalledMultiplyAndNoMatching_thenTypePromotion() {
        assertThat(multiplier.multiply(10, 10)).isEqualTo(100.0);
    }
    @Test
    public void whenCalledMultiplyAndMatching_thenNoTypePromotion() {
        assertThat(multiplier.multiply(10, 10, 10)).isEqualTo(1000);
    }
}