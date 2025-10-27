package racingcar.domain;

import racingcar.application.dto.response.CarStatus;
import racingcar.application.dto.response.RoundResult;

import java.util.List;

public class Race {

    private final Cars cars;
    private final int totalRounds;
    private int currentRound = 0;

    private Race(Cars cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    public static Race create(List<String> carNames, int tryCount) {
        List<Car> carList = carNames.stream()
                .map(String::trim)
                .map(Car::new)
                .toList();
        return new Race(new Cars(carList), tryCount);
    }

    public RoundResult proceedRound(List<Integer> attemptValues) {
        cars.attemptMoves(attemptValues);
        currentRound++;
        return new RoundResult(currentPositions());
    }

    public boolean isFinished() {
        return currentRound >= totalRounds;
    }

    public List<String> determineWinners() {
        int max = cars.maxPosition();
        return cars.namesAtPosition(max);
    }

    public int getCarCount() {
        return cars.getCarCount();
    }

    private List<CarStatus> currentPositions() {
        return cars.reportStatuses();
    }
}
