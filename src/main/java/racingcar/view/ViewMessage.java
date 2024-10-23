package racingcar.view;

public enum ViewMessage {

    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT("시도할 횟수는 몇 회인가요?"),

    RESULT_HEADER("실행 결과"),
    FINAL_WINNER("최종 우승자 : ");


    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}