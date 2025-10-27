package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.Car;
import racingcar.race.RaceResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {

    @Test
    @DisplayName("가장 많이 전진한 자동차가 우승자다")
    void winnerIsCarWithMaxPosition() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.move();
        pobi.move();
        jun.move();

        RaceResult result = new RaceResult();
        List<String> winners = result.findWinners(List.of(pobi, woni, jun));

        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("우승자는 여러 명일 수도 있다")
    void multipleWinners() {
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");

        pobi.move();
        jun.move();

        RaceResult result = new RaceResult();
        List<String> winners = result.findWinners(List.of(pobi, jun));

        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}
