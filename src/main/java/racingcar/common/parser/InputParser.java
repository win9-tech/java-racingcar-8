package racingcar.common.parser;

import java.util.Arrays;
import java.util.List;

import static racingcar.common.constant.GameRules.NAME_DELIMITER;
import static racingcar.common.constant.ErrorMessage.*;

public class InputParser {

    public static List<String> parseCarNames(String carNames) {
        try {
            return Arrays.stream(carNames.split(NAME_DELIMITER))
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int parseTryCount(String rawInput) {
        try {
            int count = Integer.parseInt(rawInput.trim());
            if (count <= 0) throw new IllegalArgumentException(TRY_COUNT_POSITIVE);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NUMERIC);
        }
    }
}
