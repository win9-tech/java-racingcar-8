# java-racingcar-precourse

## 기능 요구사항


---
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.



## 입출력 요구 사항

### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
pobi,woni,jun
```

- 시도할 횟수
```
5
```

### 출력
- 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```


- 단독 우승자 안내 문구
```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구
```
최종 우승자 : pobi, jun
```


실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

---

## 구현 기능

1. 자동차 이름 입력 기능
2. 시도 횟수 입력 기능
3. 쉼표 기준 자동차 구분 기능
4. 자동차 상태 저장 기능
5. 자동차 전진/정지 기능
6. 우승자 선정 기능 
7. 라운드별 자동차 상태 출력 기능
8. 우승자 출력 기능

## 예외처리

1. 자동차 이름 자릿수(5) 초과 예외
2. 이동 횟수 입력 형식 예외 (문자, 특수문자, 공백)
3. 자동차 이름 중복 예외

---

## 패키지 구조

```
src
└── main
└── java
└── racingcar
├── application
│   ├── dto
│   │   ├── request
│   │   │   └── RacingGameRequest.java       # 게임 실행 요청 DTO
│   │   └── response
│   │       ├── CarStatus.java               # 각 자동차의 이름/위치 상태 DTO
│   │       ├── RaceResult.java              # 전체 경기 결과 DTO
│   │       └── RoundResult.java             # 라운드별 결과 DTO
│   ├── RacingGameExecutor.java              # 실제 경기 라운드 진행 로직
│   └── RacingGameFacade.java                # 파사드: 게임 전체 흐름 관리 (검증 → 실행)
│
├── common
│   ├── config                               # (환경 설정 관련 클래스)
│   └── parser
│       └── InputParser.java                 # 사용자 입력 파싱 및 기본 검증
│
├── controller
│   └── RacingGameController.java            # 입력 → 실행 → 출력 제어
│
├── domain
│   ├── Car.java                             # 자동차 객체
│   ├── Cars.java                            # 일급 컬렉션, 자동차 집합 관리
│   └── Race.java                            # 전체 경기 상태 및 진행 관리
│
├── view
│   ├── ApplicationConsoleView.java          # 콘솔 입출력 구현체
│   └── ApplicationView.java                 # 뷰 인터페이스
│
└── Application.java                         # 프로그램 진입점
```