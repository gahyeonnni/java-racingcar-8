package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameStartCommand;
import racingcar.errorMessage.ErrorMessage;
import racingcar.race.CarNameParser;
import racingcar.race.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    private final InputValidator validator = new InputValidator();
    private final CarNameParser parser = new CarNameParser();

    @Test
    @DisplayName("자동차 이름이 쉼표로 구분되지 않으면 예외 발생")
    void invalidDelimiter_throwsException() {
        assertThatThrownBy(() -> parser.getCarName("pobi|woni|jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_CORRECT_NAMES.message());
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 예외 발생")
    void nameTooLong_throwsException() {
        assertThatThrownBy(() -> parser.getCarName("pobi,woni123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_CORRECT_NAMES.message());
    }

    @Test
    @DisplayName("자동차 이름이 10개를 초과하면 예외 발생")
    void tooManyNames_throwsException() {
        assertThatThrownBy(() -> parser.getCarName("a,b,c,d,e,f,g,h,i,j,k"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_CORRECT_NAMES.message());
    }

    @Test
    @DisplayName("빈 이름 입력 시 예외 발생")
    void emptyName_throwsException() {
        assertThatThrownBy(() -> validator.validate(new GameStartCommand("", "5")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INPUT.message());
    }

    @Test
    @DisplayName("시도 횟수가 빈 문자열이면 예외 발생")
    void emptyCount_throwsException() {
        assertThatThrownBy(() -> validator.validate(new GameStartCommand("pobi,woni", "")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INPUT.message());
    }

    @Test
    @DisplayName("시도 횟수에 문자가 포함되면 예외 발생")
    void countNotNumeric_throwsException() {
        assertThatThrownBy(() -> validator.validate(new GameStartCommand("pobi,woni", "k")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_NUMERIC_COUNT.message());
    }

    @Test
    @DisplayName("시도 횟수가 0이하이면 예외 발생")
    void countNotPositive_throwsException() {
        assertThatThrownBy(() -> validator.validate(new GameStartCommand("pobi,woni", "0")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.COUNT_NOT_POSITIVE.message());
    }

    @Test
    @DisplayName("정상 입력은 통과된다")
    void validInput_passes() {
        validator.validate(new GameStartCommand("pobi,woni,jun", "3"));
    }
}
