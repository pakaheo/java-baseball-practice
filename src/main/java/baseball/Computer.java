package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int SIZE = 3;
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 9;

    private static List<Integer> numbers;

    public static List<Integer> pickNumbers() {
        numbers = new ArrayList<>();
        while (numbers.size() < SIZE) {
            addIfNotContainsNumber(Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND));
        }
        return numbers;
    }

    private static void addIfNotContainsNumber(int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
