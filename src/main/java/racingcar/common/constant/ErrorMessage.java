package racingcar.common.constant;

public final class ErrorMessage {

    private ErrorMessage() {}

    public static final String EMPTY_CAR_NAMES = "자동차 이름을 한 개 이상 입력해야 합니다.";
    public static final String DUPLICATE_CAR_NAMES = "자동차 이름은 중복될 수 없습니다.";

    public static final String EMPTY_NAME = "자동차 이름은 비어 있을 수 없습니다.";
    public static final String NAME_LENGTH = "자동차 이름은 5자 이하여야 합니다.";

    public static final String TRY_COUNT_POSITIVE = "시도 횟수는 1 이상이어야 합니다.";
    public static final String TRY_COUNT_NUMERIC = "시도 횟수는 숫자로 입력해야 합니다.";
}
