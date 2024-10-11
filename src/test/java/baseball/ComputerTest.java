package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    void 세_개의_서로_다른_숫자() {
        assertThat(Computer.pickNumbers()).hasSize(3);
    }
}
