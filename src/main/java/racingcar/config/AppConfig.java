package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.application.RacingGameExecutor;
import racingcar.application.RacingGameFacade;
import racingcar.application.RacingGameSetUp;
import racingcar.view.ApplicationConsoleView;
import racingcar.view.ApplicationView;

public class AppConfig {

    public RacingGameController getRacingGameController() {
        return new RacingGameController(getApplicationView(), getRacingGameFacade());
    }

    private RacingGameFacade getRacingGameFacade() {
        return new RacingGameFacade(getRacingGameSetUp(), getRacingGameExecutor());
    }

    private RacingGameExecutor getRacingGameExecutor() {
        return new RacingGameExecutor();
    }

    private RacingGameSetUp getRacingGameSetUp() {
        return new RacingGameSetUp();
    }

    private ApplicationView getApplicationView() {
        return new ApplicationConsoleView();
    }
}
