package racingcar.controller;

import racingcar.application.dto.request.RacingGameRequest;
import racingcar.application.dto.response.RaceResult;
import racingcar.common.parser.InputParser;
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
        List<String> carNames = readCarNames();
        int tryCount = readTryCount();
        RaceResult result = startRace(carNames, tryCount);
        printResult(result);
    }

    private List<String> readCarNames() {
        String rawCarNames = applicationView.readCarNames();
        return InputParser.parseCarNames(rawCarNames);
    }

    private int readTryCount() {
        String rawTryCount = applicationView.readTryCount();
        return InputParser.parseTryCount(rawTryCount);
    }

    private RaceResult startRace(List<String> carNames, int tryCount) {
        RacingGameRequest request = new RacingGameRequest(carNames, tryCount);
        return racingGameFacade.playGame(request);
    }

    private void printResult(RaceResult result) {
        applicationView.printRoundResult(result.getRoundResults());
        applicationView.printFinalResult(result.getWinners());
    }
}
