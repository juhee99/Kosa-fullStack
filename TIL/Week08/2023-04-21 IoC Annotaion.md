<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>

# 2023-04-21 / IoC annotaion

🗓️ 날짜           2023/04/21

☁️ 날씨           ☁️ 대체로 흐림  (14°C)

## 01. IoC ANNOTATION 설정

💡 Annotaiton으로 bean 설정을 대신한다.

- 어노테이션이 적용되려면 다음과 같은 태그들을 설정파일에 정의되어 있어야 한다.
    - <context:annotation-config>- @Autowired만 사용시
    - `<context:component-scan base-package=”xxx” />` - 모든 어노테이션

### 1.1 @Component

- 클래스에 선언하며 해당 클래스를 bean 객체로 등록한다.
- bean의 이름은 해당 클래스명(첫 글자는 소문자로 변경됨)이 사용된다.
- 범위는 디폴트로 singleton이며 @Scope를 사용하여 지정할 수 있다.

### 1.2 @Autowired

- Spring에서 의존관계를 자동으로 설정할 때 사용된다.
- 생성자 ,필드 , 메서드 세 곳에 적용이 가능하며, 타입을 이용한 프로퍼티 자동 설정기능을 제공한다. (byType)
- 해당 타입의 빈 객체가 없으면 예외를 발생시킨다.
- 일반 메서드에도 적용 가능하다.
- 같은 타입의 빈이 2개 이상 존재하면 예외가 발생하는데, @Qualfier를 사용하면 동일한 타입의 빈 중 특정 빈을 사용하도록 하여 문제 해결
    - 빈의 타입이 아닌 이름으로 주입하려는 경우 사용
- 설정이 필수가 아닐 경우 @Autowired(required=false)로 설정
- Component(””) 를 생략하고 Autowired 설정 불가능→Component(””) 필수
- 자바 내장 객체는 Autowired 불가능 하기 때문에 직접 xml에서 설정해야한다.

## 02. Spring Boot

💡 스프링 부트는 스프링으로 애플리케이션을 만들 때 필요한 `초기 설정`을 간편하게 처리해주는 별도의 프레임워크이다.

- 스프링은 기능이 많은 만큼 설정이 복잡하고 모듈의 버전 문제가 발생한다. → 이 문제를 해결해 준 것이 스프링 부트이다.
- spring Boot는   Embedded Http Servers(Tomcat,Jetty) 을 내장하고 있어 was를 따로 설치할 필요가 없다.
    - jar파일로 빌드 가능하여 가상화 환경에 빠르게 배포할 수 있다.

> war(web archive) : 하나의 웹 애플리케이션(웹 프로젝트)을 배포할 때 생성하는 파일 포맷 , WAS 에 war 파일로 배치(배포)
> 
> 
> jar (java archive) : java 파일로 모든 환경에서 사용 가능하며 JDK에서 압축을 해제 하지 않고도 접근해서 사용할 수 있도록 지원한다
> 

## 03. Spring project 만들기

📂 [SpringBootProject생성.pdf](https://github.com/juhee99/Msa-Dkteckin-fullstack/files/11307352/SpringBootProject.pdf)

1. [spring initializr](https://start.spring.io/)
2. project : Gradle-Groovy , Language : java, Spring Boot : 2.7.11 ver, java :11

![spring start](https://user-images.githubusercontent.com/55836020/233916134-8288b3a1-cae5-4284-8d92-969c90180e29.png)

3. Dependencies
    - Spring Boot Dev Tools
    - Lombok
    - Spring Configuration Processor
    - Spring Web
    - Thymeleaf
    - MyBatis Framework
    - MySQL Driver

## Exercise01 /  IoC annotaion

<details>
<summary>📜IoC annotaion 실습 펼쳐보기</summary>
<div markdown="1">

1️⃣ **[실습 1]**

(1) springiocedu이라는 프로젝트에서 exam3 이라는 패키지를 만든다.
(2) exam1 패키지의 모든 파일을 exam3 패키지 폴더에 복사하여 변경하여 구현한다.
(3) sampleanno1.xml 을 복사하여 exam3.xml 을 만든다.

어떤 객체는 <bean> 태그로 등록해야 하고
또 어떤 객체는 annotation 으로 가능할지 잘 판단하여 변경하여 구현해 본다.

```java
@Component("afternoon")
public class AfternoonGreetingImpl implements Greeting {
    public AfternoonGreetingImpl() {
    }
    @Override
    public void greet() {
        System.out.println("즐거운 오후되세요.");
    }
}

@Component("night")
public class NightGreetinglImpl implements Greeting {

    public NightGreetinglImpl() {
    }
    @Override
    public void greet() {
        System.out.println("안녕히 주무세요");
    }
}
@Component("morning")
public class MorningGreetingImpl implements Greeting {

    public MorningGreetingImpl() {

    }

    @Override
    public void greet() {
        System.out.println("상쾌한 아침입니다.");
    }
}
//main

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	   xmlns:context="http://www.springframework.org/schema/context"
	   xmlns:p="http://www.springframework.org/schema/p"
	   xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- exam3 패키지의 모든 어노테이션을 읽는다.-->
	<context:component-scan base-package="exam3"/>

	<bean id="nowTime" class="java.time.LocalTime" factory-method="now" />

</beans>
```

- Main

```java
public class GreetingTest {
    public static void main(String args[]) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("exam3.xml");
        LocalTime nowTime = (LocalTime) factory.getBean("nowTime");
        Greeting greeting = null;
        int hour = nowTime.getHour();
        if (hour >= 6 && hour < 12) {
            greeting = (Greeting) factory.getBean("morning");
        } else if (hour < 17) {
            greeting = (Greeting) factory.getBean("afternoon");
        } else if (hour < 22) {
            greeting = (Greeting) factory.getBean("evening");
        } else {
            greeting = (Greeting) factory.getBean("night");
        }

        greeting.greet();
        ((ClassPathXmlApplicationContext)factory).close();
    }
}
```

</div>
</details>


## 🤷‍♀️ **today’s feeling**

- Scope 개념 다시 확인하기
- 객체의 포함관계와 상속 관계 구분하기
