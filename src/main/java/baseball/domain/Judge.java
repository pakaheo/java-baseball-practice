package baseball.domain;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Judge {

    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";

    public String decide(List<Integer> computerPick, List<Integer> userAnswer) {
        int strike = countStrike(computerPick, userAnswer);
        int ball = countBall(computerPick, userAnswer);

        return getResultMessage(strike, ball);
    }

    private int countStrike(List<Integer> computerPick, List<Integer> userAnswer) {
        return (int) IntStream.range(0, computerPick.size())
                        .filter(i -> isStrike(computerPick.get(i), userAnswer.get(i)))
                        .count();
    }

    private int countBall(List<Integer> computerPick, List<Integer> userAnswer) {
        return (int) IntStream.range(0, computerPick.size())
                .filter(i -> isBall(computerPick, computerPick.get(i), userAnswer.get(i)))
                .count();
        // com : 589 user : 597
    }

    private boolean isStrike(int computer, int user) {
        return Objects.equals(computer, user);
    }

    private boolean isBall(List<Integer> computerPick, int computer, int user) {
        return !isStrike(computer, user) && computerPick.contains(user);
    }

    private String getResultMessage(int strike, int ball) {
        if (strike + ball == 0) {
            return NOTHING;
        }
        if (strike > 0 && ball == 0) {
            return strike + STRIKE;
        }
        if (strike == 0 && ball > 0) {
            return ball + BALL;
        }
        return ball + BALL + " " + strike + STRIKE;
    }
}
