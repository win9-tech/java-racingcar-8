package racingcar.application.dto.response;

import java.util.List;

public class RaceResult {

    List<RoundResult> roundResults;
    List<String> winners;

    public RaceResult(List<RoundResult> roundResults, List<String> winners) {
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinners() {
        return winners;
    }
}
