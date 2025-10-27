package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("이름이 공백/빈값이면 예외")
    void invalid_name_blank() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 6자 이상이면 예외")
    void invalid_name_length() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 1~5자는 허용")
    void valid_name_length() {
        assertThatCode(() -> new Car("pobi")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도값 4 이상이면 전진, 미만이면 정지")
    void move_rule() {
        Car car = new Car("pobi");
        car.attemptMove(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.attemptMove(4);
        car.attemptMove(9);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
