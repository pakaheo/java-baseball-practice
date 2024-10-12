package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    private final int LENGTH = 3;

    private final String input;

    public Validator(String input) {
        this.input = input;
    }

    public void valid() {
        checkInputLength();
        checkDuplicateNumber();
        checkRightNumber();
    }

    private void checkInputLength() {
        if (input.length() != LENGTH) {
            throw new IllegalArgumentException("숫자는 세 자리여야 합니다.");
        }
    }

    private void checkDuplicateNumber() {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (!(set.size() == LENGTH)) {
            throw new IllegalArgumentException("중복 숫자는 입력할 수 없습니다");
        }
    }

    private void checkRightNumber() {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch(Exception e) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 입력할 수 없습니다");
        }
    }
}
