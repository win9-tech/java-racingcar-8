package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ApplicationConsoleView implements ApplicationView {


    @Override
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String readTryCount() {
    }

    @Override
    public void printRoundResult() {

    }

    @Override
    public void printFinalResult() {

    }
}
