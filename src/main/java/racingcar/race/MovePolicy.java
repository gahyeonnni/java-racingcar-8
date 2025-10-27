package racingcar.race;

import java.util.List;

public interface MovePolicy {
    List<Integer> generateForRound(int count);
    boolean canMove(int randomValue);
}
