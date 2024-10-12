package baseball;

import baseball.domain.User;
import baseball.util.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorTest {
    @Test
    void 중복_숫자_입력_예외() {
        Validator validator = new Validator("223");
        assertThatIllegalArgumentException()
                .isThrownBy(validator::valid)
                .withMessageMatching("중복 숫자는 입력할 수 없습니다");
    }

    @Test
    void 숫자_아닌_문자_입력_예외() {
        Validator validator = new Validator("가나다");
        assertThatIllegalArgumentException()
                .isThrownBy(validator::valid)
                .withMessageMatching("숫자가 아닌 문자는 입력할 수 없습니다");
    }

    @Test
    void 세_자리_숫자_아닌_입력() {
        Validator validator1 = new Validator("12");
        Validator validator2 = new Validator("1234");

        assertThatIllegalArgumentException()
                .isThrownBy(validator1::valid)
                .withMessageMatching("숫자는 세 자리여야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(validator2::valid)
                .withMessageMatching("숫자는 세 자리여야 합니다.");
    }
}
