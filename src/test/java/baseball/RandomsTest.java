package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomsTest {
    @Test
    void pickNumberInRange_테스트() {
        assertThat(Randoms.pickNumberInRange(1, 9)).isStrictlyBetween(1, 9);
    }
}
