package racingcar.view;

import racingcar.race.Car;
import java.util.List;

public class OutputView {
    public void print(GameMessage message) {
        System.out.println(message.getMessage());
    }

    public void printRoundResult(List<Car> cars) {
        cars.forEach(car ->
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()))
        );
        System.out.println();
    }

    public void printFinalWinners(List<String> winners) {
        String joined = String.join(", ", winners);
        System.out.println(GameMessage.FINAL_WINNER.getMessage() + joined);
    }
}
