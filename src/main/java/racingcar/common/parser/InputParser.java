package racingcar.common.parser;

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

    public static int parseTryCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
