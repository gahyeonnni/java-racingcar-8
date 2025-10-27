package racingcar.controller;

import racingcar.race.*;
import racingcar.view.*;
import java.util.List;

public class RacingGame {
    private final InputReader inputReader;
    private final OutputView outputView;
    private final CarRace carRace;
    private final RaceResult raceResult;
    private final InputValidator validator;

    public RacingGame(InputReader inputReader, OutputView outputView,
                      CarRace carRace, RaceResult raceResult, InputValidator validator) {
        this.inputReader = inputReader;
        this.outputView = outputView;
        this.carRace = carRace;
        this.raceResult = raceResult;
        this.validator = validator;
    }

    public void start() {
        outputView.print(GameMessage.ASK_CAR_NAMES);
        String names = inputReader.read();

        outputView.print(GameMessage.ASK_COUNT);
        String count = inputReader.read();

        GameStartCommand command = new GameStartCommand(names, count);
        validator.validate(command);

        outputView.print(GameMessage.START);
        List<Car> cars = carRace.run(command);

        List<String> winners = raceResult.findWinners(cars);
        outputView.printFinalWinners(winners);
    }
}
