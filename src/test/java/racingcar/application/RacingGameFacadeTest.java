package racingcar.application;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.dto.response.RaceResult;
import racingcar.domain.Race;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

class RacingGameExecutorTest extends NsTest {

    @Test
    @DisplayName("난수 시퀀스를 고정했을 때 라운드 수집 결과가 기대와 일치")
    void run_collects_rounds() {
        Race race = Race.create(List.of("pobi","woni"), 2);
        RacingGameExecutor executor = new RacingGameExecutor();

        assertRandomNumberInRangeTest(
                () -> {
                    RaceResult result = executor.run(race);
                    assertThat(result.getRoundResults()).hasSize(2);
                    assertThat(result.getWinners()).containsExactly("pobi");
                },
                4, 3, 9, 9
        );
    }

    @Override
    public void runMain() {}
}