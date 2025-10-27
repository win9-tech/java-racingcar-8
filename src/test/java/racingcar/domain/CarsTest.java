package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.dto.response.CarStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("각 자동차에 인덱스별 시도값이 매핑되어 이동한다")
    void attemptMoves_mapping() {
        Cars cars = new Cars(List.of(new Car("a"), new Car("b"), new Car("c")));

        cars.attemptMoves(List.of(4, 3, 9));

        List<CarStatus> statuses = cars.reportStatuses();
        assertThat(statuses).extracting(CarStatus::name)
                .containsExactly("a", "b", "c");
        assertThat(statuses).extracting(CarStatus::position)
                .containsExactly(1, 0, 1);
    }

    @Test
    @DisplayName("최대 거리와 해당 위치의 자동차 이름들을 반환한다(단독/공동 우승 케이스 포함)")
    void namesAtMaxPosition() {
        Cars cars = new Cars(List.of(new Car("a"), new Car("b"), new Car("c")));

        cars.attemptMoves(List.of(9, 9, 1));
        int maxAfterFirst = cars.maxPosition();
        List<String> atMaxFirst = cars.namesAtPosition(maxAfterFirst);

        assertThat(maxAfterFirst).isEqualTo(1);
        assertThat(atMaxFirst).containsExactlyInAnyOrder("a", "b");

        cars.attemptMoves(List.of(0, 0, 9));
        int maxAfterSecond = cars.maxPosition();
        List<String> atMaxSecond = cars.namesAtPosition(maxAfterSecond);

        assertThat(maxAfterSecond).isEqualTo(1);
        assertThat(atMaxSecond).containsExactlyInAnyOrder("a", "b", "c");
    }
}