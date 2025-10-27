package racingcar.race;

import racingcar.errorMessage.ErrorMessage;
import java.util.regex.Pattern;

public class CarNameParser {
    private static final Pattern NAME_PATTERN = Pattern.compile("^([^,]{1,5})(,[^,]{1,5})*$");

    public String[] getCarName(String input) {
        validateNameList(input);
        return input.split(",");
    }

    private void validateNameList(String nameList) {
        if (!NAME_PATTERN.matcher(nameList).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NON_CORRECT_NAMES.message());
        }
    }
}
