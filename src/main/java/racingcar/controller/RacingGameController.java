package racingcar.controller;

import racingcar.application.RacingGameFacade;
import racingcar.view.ApplicationView;


public class RacingGameController {

    private final ApplicationView applicationView;
    private final RacingGameFacade racingGameFacade;

    public RacingGameController(ApplicationView applicationView, RacingGameFacade racingGameFacade) {
        this.applicationView = applicationView;
        this.racingGameFacade = racingGameFacade;
    }

    public void run() {
        String rawCarNames = applicationView.readCarNames();
    }
}
