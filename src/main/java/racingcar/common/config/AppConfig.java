package racingcar.common.config;

import racingcar.controller.RacingGameController;
import racingcar.application.RacingGameExecutor;
import racingcar.application.RacingGameFacade;
import racingcar.view.ApplicationConsoleView;
import racingcar.view.ApplicationView;

public final class AppConfig {

    public RacingGameController getRacingGameController() {
        return new RacingGameController(getApplicationView(), getRacingGameFacade());
    }

    private RacingGameFacade getRacingGameFacade() {
        return new RacingGameFacade(getRacingGameExecutor());
    }

    private RacingGameExecutor getRacingGameExecutor() {
        return new RacingGameExecutor();
    }

    private ApplicationView getApplicationView() {
        return new ApplicationConsoleView();
    }
}
