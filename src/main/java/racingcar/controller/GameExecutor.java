package racingcar.controller;

public class GameExecutor {
    private final RacingGame racingGame;

    public GameExecutor(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void run() {
        racingGame.start();
    }
}
