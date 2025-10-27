package racingcar.errorMessage;

public enum ErrorMessage {
    ERROR_INPUT("유효하지 않은 입력입니다."),
    NON_CORRECT_NAMES("자동차 이름 형식이 올바르지 않습니다."),
    NON_NUMERIC_COUNT("시도 횟수는 숫자만 입력해야 합니다."),
    COUNT_OUT_OF_RANGE("시도 횟수가 int 범위를 초과했습니다."),
    COUNT_NOT_POSITIVE("시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}

