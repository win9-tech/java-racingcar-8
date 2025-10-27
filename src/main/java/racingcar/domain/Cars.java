package racingcar.domain;

import racingcar.application.dto.response.CarStatus;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = List.copyOf(carList);
    }

    public void attemptMoves(List<Integer> attemptValues) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).attemptMove(attemptValues.get(i));
        }
    }

    public int maxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public List<String> namesAtPosition(int target) {
        return cars.stream().filter(car -> car.getPosition() == target)
                .map(Car::getName).toList();
    }

    public List<CarStatus> reportStatuses() {
        List<CarStatus> carStatuses = new ArrayList<>();
        for (Car car : cars) carStatuses.add(new CarStatus(car.getName(), car.getPosition()));
        return List.copyOf(carStatuses);
    }

    public int getCarCount() {
        return cars.size();
    }
}
