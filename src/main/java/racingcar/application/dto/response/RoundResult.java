package racingcar.application.dto.response;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

    private final List<CarStatus> carStatuses = new ArrayList<>();

    public RoundResult(List<CarStatus> carStatuses) {
        this.carStatuses.addAll(carStatuses);
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }
}
