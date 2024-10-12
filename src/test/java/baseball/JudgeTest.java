package baseball;

import baseball.domain.Judge;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {
    @Test
    void 심판_생성() {
        assertThat(new Judge()).isNotNull();
    }

    @Test
    void 스트라이크() {
        Judge judge = new Judge();

        List<Integer> computerPick = Arrays.asList(4, 2, 5);
        List<Integer> userAnswer = Arrays.asList(1, 2, 3);

        assertThat(judge.decide(computerPick, userAnswer)).isEqualTo("1스트라이크");
    }

    @Test
    void 볼() {
        Judge judge = new Judge();

        List<Integer> computerPick = Arrays.asList(4, 2, 5);
        List<Integer> userAnswer = Arrays.asList(3, 5, 2);

        assertThat(judge.decide(computerPick, userAnswer)).isEqualTo("2볼");
    }

    @Test
    void 스트라이크_볼() {
        Judge judge = new Judge();

        List<Integer> computerPick = Arrays.asList(4, 2, 5);
        List<Integer> userAnswer = Arrays.asList(4, 5, 6);

        assertThat(judge.decide(computerPick, userAnswer)).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 낫싱() {
        Judge judge = new Judge();

        List<Integer> computerPick = Arrays.asList(4, 2, 5);
        List<Integer> userAnswer = Arrays.asList(7, 8, 9);

        assertThat(judge.decide(computerPick, userAnswer)).isEqualTo("낫싱");
    }
}
