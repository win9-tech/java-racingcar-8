package racingcar;

import racingcar.common.config.AppConfig;
import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        RacingGameController controller = config.getRacingGameController();
        controller.run();
    }
}
