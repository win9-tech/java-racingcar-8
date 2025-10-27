package racingcar.application;

import racingcar.application.dto.request.RacingGameRequest;
import racingcar.application.dto.response.RaceResult;
import racingcar.domain.Race;

public class RacingGameFacade {

    private final RacingGameExecutor racingGameExecutor;

    public RacingGameFacade(RacingGameExecutor racingGameExecutor) {
        this.racingGameExecutor = racingGameExecutor;
    }

    public RaceResult playGame(RacingGameRequest request) {
        Race race = Race.create(request.carNames(), request.tryCount());
        return racingGameExecutor.run(race);
    }
}
