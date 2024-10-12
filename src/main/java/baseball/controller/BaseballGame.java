package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Judge;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;
import java.util.Objects;

public class BaseballGame {

    private static final String THREE_STRIKE = "3스트라이크";
    private static final String END_CONDITION = "2";

    private Computer computer;
    private final User user;
    private final Judge judge;

    public BaseballGame() {
        this.user = new User();
        this.judge = new Judge();
    }

    public void playBaseball() {
        do {
            InputView.printStartMessage();

            resetBaseballGame();
            findComputerPick();

            ResultView.printEndMessage();
            ResultView.printOutOrRestartMessage();
        } while (!isEndCondition());
    }

    private void resetBaseballGame() {
        computer = new Computer();
    }

    private void findComputerPick() {
        String result = "";

        while (!isThreeStrike(result)) {
            List<Integer> computerPick = computer.pickNumbers();
            InputView.printInputNumberMessage();
            result = judge.decide(computerPick, user.submitAnswer(Console.readLine()));
            ResultView.printJudgeMessage(result);
        }
    }

    private boolean isThreeStrike(String result) {
        return Objects.equals(result, THREE_STRIKE);
    }

    private boolean isEndCondition() {
        return Objects.equals(Console.readLine(), END_CONDITION);
    }

}
