package racingcar.application;


import camp.nextstep.edu.missionutils.Randoms;
import racingcar.application.dto.response.RaceResult;
import racingcar.application.dto.response.RoundResult;
import racingcar.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class RacingGameExecutor {

    public RacingGameExecutor() {}

    public RaceResult run(Race race) {
        List<RoundResult> rounds = new ArrayList<>();

        while (!race.isFinished()) {
            List<Integer> randoms = generateRandomValues(race.getCarCount());
            RoundResult result = race.proceedRound(randoms);
            rounds.add(result);
        }
        List<String> winners = race.determineWinners();
        return new RaceResult(rounds, winners);
    }

    private List<Integer> generateRandomValues(int carCount) {
        List<Integer> randomValues = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            randomValues.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomValues;
    }
}
