package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int LENGTH = 3;

    private List<Integer> answer;

    public List<Integer> submitAnswer(String input) {
        answer = new ArrayList<>();
        checkInputLength(input);

        for (String text : splitAnswer(input)) {
            makeAnswer(parseToInt(text));
        }

        return answer;
    }

    private void checkInputLength(String input) {
        if (input.length() != LENGTH) {
            throw new IllegalArgumentException("숫자는 세 자리여야 합니다.");
        }
    }

    private String[] splitAnswer(String input) {
        return input.split("");
    }

    private void makeAnswer(int number) {
        checkDuplicateNumber(number);
        answer.add(number);
    }

    private void checkDuplicateNumber(int number) {
        if (answer.contains(number)) {
            throw new IllegalArgumentException("중복 숫자는 입력할 수 없습니다");
        }
    }

    private int parseToInt(String text) {
        int number;
        try {
            number = Integer.parseInt(text);
        } catch(Exception e) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 입력할 수 없습니다");
        }
        return number;
    }
}
