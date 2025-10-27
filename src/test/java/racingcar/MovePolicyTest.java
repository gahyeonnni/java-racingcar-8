package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.RandomMovePolicy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovePolicyTest {

    private final RandomMovePolicy movePolicy = new RandomMovePolicy();

    @Test
    @DisplayName("generateForRound는 0~9 사이의 값을 생성한다")
    void generateRandomNumbersWithinRange() {
        List<Integer> numbers = movePolicy.generateForRound(10);
        assertThat(numbers).hasSize(10);
        assertThat(numbers).allMatch(num -> num >= 0 && num <= 9);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진 가능")
    void canMoveWhenValueIsFourOrMore() {
        assertThat(movePolicy.canMove(4)).isTrue();
        assertThat(movePolicy.canMove(9)).isTrue();
    }

    @Test
    @DisplayName("랜덤 값이 3 이하이면 정지")
    void cannotMoveWhenValueIsLessThanFour() {
        assertThat(movePolicy.canMove(3)).isFalse();
        assertThat(movePolicy.canMove(0)).isFalse();
    }
}
