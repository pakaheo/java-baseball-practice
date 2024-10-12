package baseball;

import baseball.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {

    @Test
    void 사용자_생성() {
        assertThat(new User()).isNotNull();
    }

    @Test
    void 서로_다른_세_개_숫자_입력() {
        User user = new User();
        List<Integer> input = user.submitAnswer("123");
        assertThat(input).containsExactly(1,2,3);
    }
}
