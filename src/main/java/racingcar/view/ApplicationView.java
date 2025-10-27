package racingcar.view;

import racingcar.application.dto.response.RoundResult;

import java.util.List;


public interface ApplicationView {

    String readCarNames();

    String readTryCount();

    void printRoundResult(List<RoundResult> rounds);

    void printFinalResult(List<String> winners);
}
