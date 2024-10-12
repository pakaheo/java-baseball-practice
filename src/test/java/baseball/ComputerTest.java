package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void 컴퓨터_생성() {
        assertThat(new Computer()).isNotNull();
    }

    @Test
    void 세_개의_서로_다른_숫자() {
        Computer computer = new Computer();

        List<Integer> numbers = computer.pickNumbers();
        Set<Integer> set = new HashSet<>(numbers);

        assertThat(numbers.size()).isEqualTo(set.size());
    }
}
