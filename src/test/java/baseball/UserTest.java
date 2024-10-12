package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Test
    void 중복_숫자_입력_예외() {
        User user = new User();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> user.submitAnswer("223"))
                .withMessageMatching("중복 숫자는 입력할 수 없습니다");
    }

    @Test
    void 숫자_아닌_문자_입력_예외() {
        User user = new User();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> user.submitAnswer("가나다"))
                .withMessageMatching("숫자가 아닌 문자는 입력할 수 없습니다");
    }

    @Test
    void 세_자리_숫자_아닌_입력() {
        User user = new User();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> user.submitAnswer("12"))
                .withMessageMatching("숫자는 세 자리여야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> user.submitAnswer("1234"))
                .withMessageMatching("숫자는 세 자리여야 합니다.");
    }
}
