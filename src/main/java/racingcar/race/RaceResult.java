package racingcar.race;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    public List<String> findWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return getWinnerNames(cars, maxPosition);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> getWinnerNames(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
