package baseball;

import camp.nextstep.edu.missionutils.Console;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGame {

    public static void playBaseball() {
        Computer computer = new Computer();
        User user = new User();
        Judge judge = new Judge();
        String result;

        List<Integer> computerPick =  computer.pickNumbers();
        List<Integer> userAnswer;

        do {
            InputView.printStartMessage();
            result = "";
            while (!Objects.equals(result, "3스트라이크")) {
                InputView.printInputNumberMessage();
                userAnswer = user.submitAnswer(Console.readLine());
                result = judge.decide(computerPick, userAnswer);
                ResultView.printJudgeMessage(result);
            }
            ResultView.printEndMessage();
            ResultView.printOutOrRestartMessage();
        } while (!Objects.equals(Console.readLine(), "2"));
    }

}
