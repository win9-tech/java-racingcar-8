package racingcar.application.dto.request;

import java.util.List;

public record RacingGameRequest(
        List<String> carNames,
        int tryCount
    ) {
}
