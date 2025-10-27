package racingcar.common.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("이름 파싱: 쉼표 기준 분리")
    void parseCarNames() {
        List<String> names = InputParser.parseCarNames("pobi,woni,jun");
        assertThat(names).containsExactly("pobi","woni","jun");
    }

    @Test
    @DisplayName("시도횟수 파싱: 정상")
    void parseTryCount_ok() {
        assertThat(InputParser.parseTryCount("5")).isEqualTo(5);
        assertThat(InputParser.parseTryCount(" 7 ")).isEqualTo(7);
    }

    @Test
    @DisplayName("시도횟수 파싱: 숫자 아님 → 예외")
    void parseTryCount_invalid() {
        assertThatThrownBy(() -> InputParser.parseTryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.parseTryCount("!@#"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.parseTryCount(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수 파싱: 0 이하 → 예외")
    void parseTryCount_nonPositive() {
        assertThatThrownBy(() -> InputParser.parseTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.parseTryCount("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}