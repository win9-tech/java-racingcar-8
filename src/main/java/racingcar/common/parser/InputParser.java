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

    public static int parseTryCount(String rawInput) {
        try {
            int count = Integer.parseInt(rawInput.trim());
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }
}
