package racingcar.application;

import racingcar.application.dto.request.RacingGameRequest;
import racingcar.application.dto.response.RaceResult;
import racingcar.domain.Race;

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
            throw new IllegalArgumentException("요청이 비어 있습니다.");
        }

        List<String> names = request.carNames();
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 한 개 이상 입력해야 합니다.");
        }

        List<String> normalizedNames = names.stream()
                .map(String::trim)
                .toList();
        long distinctCount = normalizedNames.stream().distinct().count();
        if (distinctCount != normalizedNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
