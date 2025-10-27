package racingcar.controller;

import racingcar.application.dto.request.RacingGameRequest;
import racingcar.application.dto.response.RaceResult;
import racingcar.application.dto.response.RoundResult;
import racingcar.common.InputParser;
import racingcar.application.RacingGameFacade;
import racingcar.view.ApplicationView;

import java.util.List;

public class RacingGameController {

    private final ApplicationView applicationView;
    private final RacingGameFacade racingGameFacade;

    public RacingGameController(ApplicationView applicationView, RacingGameFacade racingGameFacade) {
        this.applicationView = applicationView;
        this.racingGameFacade = racingGameFacade;
    }

    public void run() {
        String rawCarNames = applicationView.readCarNames();
        List<String> carNames = InputParser.parseCarNames(rawCarNames);

        String rawTryCount = applicationView.readTryCount();
        int tryCount = InputParser.parseTryCount(rawTryCount);

        RacingGameRequest request = new RacingGameRequest(carNames, tryCount);
        RaceResult raceResult = racingGameFacade.playGame(request);

        for (RoundResult round : raceResult.getRoundResults()) {
            applicationView.printRoundResult(round);
        }
    }
}
