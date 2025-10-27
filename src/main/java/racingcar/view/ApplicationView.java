package racingcar.view;

import racingcar.application.dto.response.RoundResult;

public interface ApplicationView {

    String readCarNames();

    String readTryCount();

    void printRoundResult(RoundResult roundResult);

    void printFinalResult();
}
