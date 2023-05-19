<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>

# 2023-05-17 / Spring JPA

🗓️ 날짜           2023/05/17

☁️ 날씨            ☀️ 맑음 (21 °C)
</br>

## Spring Data JPA

💡 Spring Framework에서 JPA를 쳔리하게 사용할 수 있도록 지원하는 프로젝트로 CRUD 처리를 위한 공통 인터페이스를 제공

- Repository 개발 시 인터페이스만 작성해도 실행 시점에 Spring Data JPA가 구현 객체를 동적으로 생성해서 주입 → 인터페이스 만으로도 개발을 구현할 수 있음.
- Spring Data JPA를 사용하기 위해 **‘JpaRepository<T, ID>’** 인터페이스를 상속한 Repository 인터페이스를 정의

# JPA 메소드

| 쿼리 종류 | 이름 규칙 |
| --- | --- |
| 조회 | find..By, read..By, query..By, get..By |
| COUNT | count…By |
| EXISTS | exists…By |
| 삭제 | delete…By, remove…By |
| DISTINCT | findDistinct, findMemberDistinctBy |
| LIMIT | findFirst, findFirst, |

### JPA 인터페이스 메소드명 예

- findByName(String name);

- findByNameIgnoreCase(String name);

- findByNameOrDeptno(String name, *int* dno);

- findByHiredateAfter(java.sql.Date d);

- findBySalGreaterThanEqual(*int* inputsal);

- findByHiredateBefore(java.sql.Date d);

- findBySalLessThanEqual(*int* inputsal);

- findByNameOrderBySalDesc(String name);
- findByNameNull();

## Bean 등록

1. @Autowired 어노테이션 → 필드 인젝션
    
    ```java
    @Autowired
    private final TestRepository test;
    ```
    
2. 생성자로 주입 → 권장하는 방식
    
    ```java
    private final TestRepository test;
    
    public test(TestRepository test){
    	this.test = test;
    }
    ```
    
3. @RequiredArgsConstructor 어노테이션 → 생성자 주입을 대신
    - 반드시 final이어야 한다,
    
    ```java
    @Controller
    @RequiredArgsConstructor
    public class TestController{
    	private final TestRepository test;
    
    }
    ```
    

## Optinal

💡 NullPointException 을 방지하기 위해 null이 올 수 있는 값을 감싸는 wrapper 클래스이다.

- null이어도 NPE가 발생하지 않는다.
- 반드시 값이 있어야 하는 경우 of()메서드 사용 ⇒ NPE 발생
- isPresent() : null 여부 판단
- ifPresent() : 람다식으로 인자를 받아 값이 존재할 때 , 람다식 적용
- get() : value 값을 꺼내 온다. → null이면 NoSuchElementException 발생

## @Transactional

💡 update. insert, delete 될 때 트랜잭션이 보장 되도록 하는 메소드 이다.

- error 발생 : DB에 반영되지 않게 rollback 된다.
- 정상 처리 :  DB에 반영한다.
- select 할 때 빼고 사용해라,,!

## Spring Boot Application에 설정된 어노테이션

```java
@SpringBootApplication
@ComponentScan(basePackages={"com.example.demo","thymeleaf.exam", 
"springjpa.exam"})
@EnableJpaRepositories(basePackages = {"springjpa.exam.repository"}) 
@EntityScan(basePackages = {"springjpa.exam.entity"})
```

- @SpringBootApplication 어노테이션은 스프링 부트의 가장 기본적인 설정
- @ComponentScan 어노테이션은 스프링 3.1부터 도입된 어노테이션이며 스캔
- @EnableJpaRepositories 어노테이션은 JPA Repository들을 활성화하기 위한 어노테이션
- @EntityScan 어노테이션은 엔티티 클래스를 스캔할 곳을 지정하는데 사용

## Srping Boot Test

💡 표준 테스트 도구인 JUnit 5 지원하고 있다. 

### Test 어노테이션

- @SpringBootTest : 어플리케이션 전체에 대한 테스트
- @WebMvcTest : MVC 단위테스트 → 컨트롤러 전용 단위 테스트
- @DataJpaTest : JPA만 테스트 ⇒ repository만 테스트

- @Transctional 어노테이션은 테스트가 끝난 후 자동 트랜잭션 롤백하는 기능
- 롤백을 원하지 않으면 : @Rollback(false)
- @AutoConfigureTestDatabase(replace=Replace.NONE) : h2 데이터베이스로 설정되기를 원하지 않는다면
- 


## 🤷‍♀️ today’s feeling

- 동적 쿼리를 위해 → query dsl 따로 공부해보기
- 게시판 실습의 페이징 처리를 못했다. -> 공부 해보기
