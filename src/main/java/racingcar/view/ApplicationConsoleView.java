package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.dto.response.CarStatus;
import racingcar.application.dto.response.RoundResult;

import java.util.List;

import static racingcar.common.constant.UiMessage.*;

public class ApplicationConsoleView implements ApplicationView {


    @Override
    public String readCarNames() {
        System.out.println(PROMPT_CAR_NAMES);
        return Console.readLine();
    }

    @Override
    public String readTryCount() {
        System.out.println(PROMPT_TRY_COUNT);
        return Console.readLine();
    }

    @Override
    public void printRoundResult(List<RoundResult> rounds) {
        System.out.println(HEADER_RESULT);

        for (RoundResult round : rounds) {
            for (CarStatus status : round.getCarStatuses()) {
                System.out.println(status.name() + " : " + "-".repeat(status.position()));
            }
            System.out.println();
        }
    }

    @Override
    public void printFinalResult(List<String> winners) {
        System.out.println(FINAL_WINNERS_PREFIX + String.join(", ", winners));
    }
}
