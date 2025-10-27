# java-racingcar-precourse

## 🚗 자동차 경주

---
- 이번 과제를 구현하면서 확장성과 SRP에 대해 가장 많은 고민을 했습니다. 각 기능마다 최소 3가지 이상의 확장 시나리오를 가정하고, 그 확장이 생기더라도 기존 코드의 수정 없이 새로운 클래스 추가만으로 대응 가능하도록 설계했습니다.

```
racingcar
├── Application.java
├── controller
│ ├── GameExecutor.java
│ ├── RacingGame.java
│ └── GameStartCommand.java
│
├── race
│ ├── Car.java
│ ├── CarRace.java
│ ├── CarNameParser.java
│ ├── MovePolicy.java
│ ├── RandomMovePolicy.java
│ ├── InputValidator.java
│ └── RaceResult.java
│
├── view
│ ├── InputReader.java
│ ├── OutputView.java
│ └── GameMessage.java
│
└── errorMessage
└── ErrorMessage.java
```

  ### ✅ 기능 요구사항 체크리스트

---
- [x]  자동차 이름을 입력받는다
- [x]  이름은 5자 이하, 최대 9대까지만 허용된다
- [x]  시도 횟수를 입력받는다
- [x]  시도 횟수만큼 자동차 경주가 진행된다
- [x]  무작위 값(0~9) 중 4 이상일 때만 전진한다
- [x]  라운드별로 실행 결과를 출력한다
- [x]  가장 많이 전진한 자동차를 우승자로 표시한다
- [x]  공동 우승자가 존재할 수 있다
- [x]  잘못된 입력 시 IllegalArgumentException 발생 후 프로그램이 종료된다.

### ✅ 기능 요구사항 외 체크리스트

---

- [x]  자동차 이름이 특수문자거나 숫자여도 예외 처리하지 않음
- [x]  이름이 NULL 또는 공백이면 예외 발생
- [x]  시도 횟수가 NULL 또는 공백이면 예외 발생
- [x]  시도 횟수가 INT 범위를 초과한 경우 예외 발생
