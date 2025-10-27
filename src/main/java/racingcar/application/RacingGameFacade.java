package racingcar.application;

import racingcar.application.dto.request.RacingGameRequest;
import racingcar.application.dto.response.RaceResult;
import racingcar.domain.Race;

import static racingcar.common.constant.ErrorMessage.*;

import java.util.List;

public class RacingGameFacade {

    private final RacingGameExecutor racingGameExecutor;

    public RacingGameFacade(RacingGameExecutor racingGameExecutor) {
        this.racingGameExecutor = racingGameExecutor;
    }

    public RaceResult playGame(RacingGameRequest request) {
        validateRequest(request);
        Race race = Race.create(request.carNames(), request.tryCount());
        return racingGameExecutor.run(race);
    }

    private void validateRequest(RacingGameRequest request) {
        if (request == null) {
            throw new IllegalArgumentException();
        }

        List<String> names = request.carNames();
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAMES);
        }

        List<String> normalizedNames = names.stream()
                .map(String::trim)
                .toList();
        long distinctCount = normalizedNames.stream().distinct().count();
        if (distinctCount != normalizedNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES);
        }
    }
}
