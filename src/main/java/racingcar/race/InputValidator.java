package racingcar.race;

import racingcar.controller.GameStartCommand;
import racingcar.errorMessage.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern COUNT_PATTERN = Pattern.compile("\\d+");
    private static final int MAX_INT_LENGTH = String.valueOf(Integer.MAX_VALUE).length();

    public void validate(GameStartCommand input) {
        validateNullOrEmpty(input.names());
        validateNullOrEmpty(input.count());
        validateNumeric(input.count());
        validateCountRange(input.count());
    }

    private void validateNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT.message());
        }
    }

    private void validateNumeric(String count) {
        if (!COUNT_PATTERN.matcher(count).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_COUNT.message());
        }
    }

    private void validateCountRange(String count) {
        if (count.length() > MAX_INT_LENGTH ||
                (count.length() == MAX_INT_LENGTH && count.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0)) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_OUT_OF_RANGE.message());
        }
        int value = Integer.parseInt(count);
        if (value <= 0) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_NOT_POSITIVE.message());
        }
    }
}
