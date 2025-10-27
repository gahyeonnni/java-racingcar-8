package racingcar;

import racingcar.controller.*;
import racingcar.race.*;
import racingcar.view.*;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OutputView outputView = new OutputView();
        CarNameParser carNameParser = new CarNameParser();
        MovePolicy randomMovePolicy = new RandomMovePolicy();
        RaceResult raceResult = new RaceResult();
        InputValidator inputValidator = new InputValidator();

        CarRace carRace = new CarRace(carNameParser, randomMovePolicy, outputView);

        RacingGame racingGame = new RacingGame(
                inputReader,
                outputView,
                carRace,
                raceResult,
                inputValidator
        );

        GameExecutor gameExecutor = new GameExecutor(racingGame);
        gameExecutor.run();
    }
}
