package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomMovePolicy implements MovePolicy {
    private static final int MOVING_FORWARD_CONDITION = 4;

    @Override
    public List<Integer> generateForRound(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> Randoms.pickNumberInRange(0, 9))
                .collect(Collectors.toList());
    }

    @Override
    public boolean canMove(int randomValue) {
        return randomValue >= MOVING_FORWARD_CONDITION;
    }
}
