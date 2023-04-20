<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>

# 2023-04-17 / JUnit5, Spring

🗓️ 날짜           2023/04/ 17

☁️ 날씨           🌞 맑음  (9°C)

</br>

## 01. JUnit

💡 java 언어를 위함 테스트 프레임 워크이며 클래세에 구현된 메서드가 주어진 기능을 제대로 수행하는지 `단위 테스트`를 처리 할 수 있다.

- DB연동을 할 때 단위 테스트 필요

### 1.1 JUnit5 기본 어노테이션

- @Test : 테스트 메서드를 나타내는 어노테이션(필수)
- @BeforeEach : 각 테스트 메서드 시작 전에 실행되는 메서드
- @AfterEach : 각 테스트 메서드 종료 후에 실행되는 메서드
- @BeforAll : 테스트 시작 전에 실행되는 메서드(static 메서드여야만 함)
- @AfterAll : 테스트 종료 후에 실행되는 메서드(static 메서드여야만 함)
- @Disable :  실행되지 않아야 하는 테스트 메서드

## 02. JUnit5 Assertions

💡 Assertion은 주장이라는 뜻으로 테스트가 원하는 결과를 제대로 리턴하는지, 에러 발생 여부 등 확인할 때 사용 하는 메서드이다. 테스트하고 싶은 인자 값을 넣었을 때 예상한 결과가 나오는지 테스트 해볼 경우 사용한다.

### Assertions 메서드

- fail : 무조건 실패
- asserTrue : 조건이 성공이면  True
- assertNull : 조건이 null 이면 True
- assertSame : 동일한 Object면 True
- assertThrows : 예상한 에러가 발생하면 True
- assertTimeout : 테스트 지정시간이 오래 걸리지 않으면 True ,얼만큼 걸리는지 알 수 있음 →지정한 시간보다 오래 걸려도 테스트가 끝날 때까지 대기
- assertTimeoutPreemptively : 테스트가 지정한 시간보다 오래 걸리지 않으면 True, 얼마큼 걸리는지 알수 x →지정한 시간보다 오래 걸린 경우 바로 테스트 종류

## 03. JUnit 5 Assumptions

💡 assumption은 한글로 추정이라는 뜻으로 메서드별 조건을 만족할 경우 진행시키고 아닌 경우 스킵하는 메서드이다. if문과 비슷한 용도로 사용한다,

### Assumptions 메서드

- assumeTrue : 테스트가 실패하면 에러 발생
- assumFalse : 테스트가 성공하면 에러 발생
- assumingThat(boolean, executable) : 첫번째 인자가 true이면 두번째 인자로 들어온 함수 실행
    - 첫번째 인자가 false이면 두번째 인자 함수 실행 x

## 04. Spring

💡 **스프링 프레임워크** 는 자바 기반의 애플리케이션 프레임워크로 엔터프라이즈급 애플리케이션을 개발하기 위한 다양한 기능을 제공한다. → 개발자가 비지니스 로직 구현에만 집중할 수 있게 한다.

### 스프링의 특징과 구조

- 제어의 역전(IoC)
- 의존성 주입(DI)

## 🤷‍♀️ **today’s feeling**

- miniProject1 DB설계 하기 - 수업 끝나고
- JUnit5 테스트시 given,when,then 규칙 지키기
- 예전 인프런 강의를 들었을 때 테스트 코드를 강조 하였는데 교수님은 테스트 주도 설계는 실패했다고 말씀하셨다. 그래도 최소한 DB 부분은 테스를 실행 해서 코드 안정성을 확보 하자..
