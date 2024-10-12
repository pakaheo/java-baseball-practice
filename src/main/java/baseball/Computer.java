package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int SIZE = 3;
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 9;

    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> pickNumbers() {
        while (numbers.size() < SIZE) {
            addNumber(Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND));
        }

        return numbers;
    }

    private void addNumber(int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

}
