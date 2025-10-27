package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.dto.response.RoundResult;

public class ApplicationConsoleView implements ApplicationView {


    @Override
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    @Override
    public void printRoundResult(RoundResult result) {
        System.out.println("실행 결과");
        result.getCarStatuses().forEach(status ->
                System.out.println(status.name() + " : " + "-".repeat(status.position()))
        );
        System.out.println();
    }

    @Override
    public void printFinalResult() {

    }
}
