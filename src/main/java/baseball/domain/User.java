package baseball.domain;

import baseball.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> answer;

    public List<Integer> submitAnswer(String input) {
        new Validator(input).valid();
        answer = new ArrayList<>();

        for (String text : splitAnswer(input)) {
            makeAnswer(parseToInt(text));
        }

        return answer;
    }

    private String[] splitAnswer(String input) {
        return input.split("");
    }

    private void makeAnswer(int number) {
        answer.add(number);
    }

    private int parseToInt(String text) {
        return Integer.parseInt(text);
    }
}
