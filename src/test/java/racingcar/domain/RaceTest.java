package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.dto.response.CarStatus;
import racingcar.application.dto.response.RoundResult;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    @Test
    @DisplayName("한 라운드 진행 시 상태가 기대대로 변한다")
    void playRound_once() {
        Race race = Race.create(List.of("a","b"), 3);
        RoundResult r1 = race.proceedRound(List.of(4, 3));
        assertThat(r1.getCarStatuses()).extracting(CarStatus::position)
                .containsExactly(1, 0);

        RoundResult r2 = race.proceedRound(List.of(5, 8));
        assertThat(r2.getCarStatuses()).extracting(CarStatus::position)
                .containsExactly(2, 1);
    }

    @Test
    @DisplayName("총 라운드 소진 시 isFinished가 true")
    void finished() {
        Race race = Race.create(List.of("a"), 2);
        assertThat(race.isFinished()).isFalse();
        race.proceedRound(List.of(4));
        assertThat(race.isFinished()).isFalse();
        race.proceedRound(List.of(4));
        assertThat(race.isFinished()).isTrue();
    }

    @Test
    @DisplayName("최종 우승자 계산")
    void winners() {
        Race race = Race.create(List.of("a","b","c"), 1);
        race.proceedRound(List.of(4, 3, 9));
        assertThat(race.determineWinners())
                .containsExactlyInAnyOrder("a","c");
    }
}
