package racingcar.domain;

import static racingcar.common.constant.ErrorMessage.*;
import static racingcar.common.constant.GameRules.MOVE_THRESHOLD;
import static racingcar.common.constant.GameRules.NAME_MAX_LEN;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void attemptMove(int randomValue) {
        if(randomValue >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME);
        }
        if (name.trim().length() > NAME_MAX_LEN) {
            throw new IllegalArgumentException(NAME_LENGTH);
        }
    }
}
