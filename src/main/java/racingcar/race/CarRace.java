package racingcar.race;

import racingcar.controller.GameStartCommand;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {
    private final CarNameParser carNameParser;
    private final MovePolicy randomMovePolicy;
    private final OutputView outputView;

    public CarRace(CarNameParser carNameParser, MovePolicy randomMovePolicy, OutputView outputView) {
        this.carNameParser = carNameParser;
        this.randomMovePolicy = randomMovePolicy;
        this.outputView = outputView;
    }

    public List<Car> run(GameStartCommand input) {
        String[] nameList = carNameParser.getCarName(input.names());
        int roundCount = Integer.parseInt(input.count());

        List<Car> cars = List.of(nameList).stream()
                .map(Car::new)
                .collect(Collectors.toList());

        IntStream.range(0, roundCount).forEach(i -> {
            List<Integer> randoms = randomMovePolicy.generateForRound(cars.size());
            moveCars(cars, randoms);
            outputView.printRoundResult(cars);
        });

        return cars;
    }

    private void moveCars(List<Car> cars, List<Integer> randoms) {
        IntStream.range(0, cars.size())
                .filter(i -> randomMovePolicy.canMove(randoms.get(i)))
                .forEach(i -> cars.get(i).move());
    }
}
