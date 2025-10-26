package racingcar.common;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<String> parseCarNames(String carNames) {
        try {
            return Arrays.stream(carNames.split(","))
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
