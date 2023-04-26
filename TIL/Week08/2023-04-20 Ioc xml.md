<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="20%" width="20%"> <br/>

# 2023-04-20 / Ioc

🗓️ 날짜           2023/04/14

☁️ 날씨           🌥️  흐림  (14°C)


## 01. 제어의 역전(IoC)

💡 객체의 생성과 소멸을 개발자가 직접 제어 하는것이 아닌 객체의 생명주기 관리를 ‘스프링 컨테이너’에 위임하여 `객체의 관리를 컨테이너에게 맡겨 제어권이 넘어간 것`을 제어의 역전 이라고 한다.

- 제어의 역전을 통해 의존성주입(DI), 관점지향프로그래밍(AOP)등이 가능해 진다.
- 프로그램의 확장성이나 재사용성을 높여준다.

## 02. Spring IoC 컨테이너

💡 프로그램에서 필요한 객체의 생성을 Spring FW에서 하고 `객체를 필요로 하는 곳에 주입`하는 것 그리고 `객체를 찾을 때 제공`하는 것 모두 Spring Fw가 대신 처리 한다. Spring FW에 의해 관리 되는 객체를 “bean” 이라고 부르면 이 일을 담당하는 Spring FW의 구성요소를 IoC 컨테이너 또는 스프링 컨테이너라고 한다.

<img src="https://user-images.githubusercontent.com/55836020/233277329-73960dcc-60b6-4267-a477-302526f1a87c.png" width="60%"/>

### Spring IoC 컨테이너 초기화

- ApplicationContext context = new ClassPathXmlApplicationContext(”빈 설정 파일”);
    - ApplicationContext :  spring container의 역할
    - 빈 설정 파일 : xml 형태로 빈을 만드는 파일
- 타입명 bean = (타입명)context.getBean(”빈 이름”);
- 타입명 bean = context.getBean(”빈 이름”, 클래스 타입의 객체”);
    - UserService u2=factory.getBean("userService", UserService.class);
    - 확장자 까지 붙여줘야 함.

## 03. DI 종류

💡 DI(Dependency Injection) 는 의존 관계를 외부에서 결정 해 주는 것

1. Construction Injection : 생성자를 통해서 객체 바인딩
2. Setter Injection : Setter 메서드를 이용해서 객체 바인딩
3. method injection : 어노테이션을 정의한 메서드를 이용해서 객체 바인딩
4. filed Injection : 어노테이션을 정의한 메서

## 04. IoC 설정

### XML 설정

- 설정 정보를 변경할 때는 XML만 변경하면 된다.
- **<bean> 태그**
    - Spring IoC컨테이너가 관라할 Bean객체 설정
    - id : 주입 받을 곳에서 호출할 이름
    - class : 주입할 객체의 클래스 명
    - factory-method : 객체 생성시 사용될 factory 메서드
    - scope : Bean 객체의 유효 범위 설정, 기본: singleton
        - 기본은 싱글톤 타입으로 객체를 필요할 때 마다 생성할려면 prototype 으로 해야한다. → prototyp/sigleton(default) scope="prototype”
- **<constructor-arg> 태그**
    - <bean>태그 하위 태그로 bean객체 또는 값을 생성자를 통해 주입하도록 설정
    - <ref bean =”bean name” /> 객체를 주입 시
    - <value>값</value>  파라미터 값
    - 속성 이용 ref=”bean 이름” , value=”값”
        - ref : setter을 호출,
    - 
- <property> 태그
    - <bean>의 하위태그로 다른 bean 객체 또는 setter 메서드를 통해 주입하도록 설정
    - <ref bean=”bean name” /> 객체를 주입 시
    - <value>값</value> 파라미터 값 ,type 속성 → 패키지명 까지 명시
    - 속성 이용 ref=”bean 이름” , value=”값”

### xml 예

1️⃣ **예제1**

```xml
	<!--선언적인 프로그래밍-코딩이 아닌 정해진 규겨으로 문서를 작성하여 기능(구현)을 대신하는 것-->
	<!--같은 클래스에대해 빈 객체 2개 생성-->
	<bean id="messageBean1" class="sample1.MessageBeanImpl" >
		<!--생성자 주입 value는 파라 미터로 들어감-->
		<constructor-arg>  
			<value>strawberry</value>
		</constructor-arg>	
		<property name="cost">
			<value>3000</value>
		</property>
	</bean>	
	
	<bean id="messageBean2" class="sample1.MessageBeanImpl" >
		<constructor-arg>
			<value>peach</value>
		</constructor-arg>
		<!--value는 속성으로 작성가능 -->
		<property name="cost"  value="2000" />	 
	</bean>	
</beans>
```

2️⃣ **예제 2 - 단축형(Setter Injection)**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean id="f1" class="sample5.DateVo">
	<property name="name" value="Duke"/>
	<property name="birth" value="1996-01-01"/>	
</bean>

<bean id="f2" class="sample5.DateVo" 
	p:name="Dooly"  p:birth="1983-04-22"/>	
</beans>
```

> 1.  <beans>에 xmlns:p="http://www.springframework.org/schema/p" 추가
> 
> 1. p: key =value 형식

3️⃣ **예제 3 - 단축형(Constructor Injection)**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:c="http://www.springframework.org/schema/c"
	   xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<!-- How to set properties using XML namespace -->
<bean id="developer" class="sample7.Developer"
        					c:_0="dooly"  c:_1="1500000" p:dept="Development 1 Team" />
<bean id="engineer" class="sample7.Engineer"
        					c:name="duke"  c:salary="2500000" p:dept="Technology 1 Team" />
	<!--c:아규먼트명="값" 생성자 아규먼트를 전달하겠다.-->
  <!-- c:_0 아규먼트 index로 접근하여 아규먼트를 전달-->
</beans>
```
## Exercise01 / xml injection

<details>
<summary> 📜xml injection 실습 펼쳐보기</summary>
<div markdown="1">



1️⃣ **[실습 1]** - 기본형

1. 다음에 제시된 인터페이스를 객체로 다루는 스프링 IoC 프로그램을 만들어 볼 것이다.
우선은 다음 코드로 인터페이스를 생성한다.
    
    public interface Greeting {
    public void greet();
    }
    
2. Greeting 을 구현하는 자식 클래스를 4개 생성한다.
MorningGreetingImpl --> "상쾌한 아침입니다." 를 출력 (아침 인사)
AfternoonGreetingImpl --> "즐거운 오후되세요." 를 출력 (점심 인사)
EveningGreetingImpl --> "편안한 저녁되세요." 를 출력 (저녁 인사)
NightGreetingImpl --> "안녕히 주무세요." 를 출력 (밤 인사)
3. resources 폴더에서 sample1.xml 을 복사하여 exam1.xml 이라는 빈 설정 파일을 만든다.
4. 빈 설정 파일에 위의 구현클래스들을 빈으로 등록하는 4개의 <bean> 태그를 작성한다.
5. LocalDateTime(또는 LocalTime)도 빈으로 등록하기 위해 <bean> 태그를 작성한다.
6. 메인 클래스(GreetingTest)
LocalDateTime(또는 LocalTime)의 객체를 찾아와서
아침 6시 ~ 낮 12시 이전이면 아침 인사를 출력하는 빈을 찾아와서 "상쾌한 아침입니다." 를 출력
낮 12시 ~ 오후 5시 이전이면 점심 인사를 출력하는 빈을 찾아와서 "즐거운 오후되세요." 를 출력
오후 5시 ~ 오후 10시 이전이면 저녁 인사를 출력하는 빈을 찾아와서 "편안한 저녁되세요." 를 출력
그 외의 시간이면 : 밤 인사를 출력하는 빈을 찾아와서 "안녕히 주무세요." 를 출력

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="morning" class="exam1.MorningGreetingImpl"/>
	<bean id="after" class="exam1.AfternoonGreetingImpl" />
	<bean id="evening" class="exam1.EveningGreetingImpl" />
	<bean id="night" class="exam1.NightGreetinglImpl"/>

	<bean id="nowTime" class="java.time.LocalTime" factory-method="now" />
</beans>
```

```java
public class GreetingTest {
    public static void main(String args[]) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("exam1.xml");
        LocalTime nowTime = (LocalTime) factory.getBean("nowTime");
        Greeting greeting = null;
        int hour = nowTime.getHour();
        if (hour >= 6 && hour < 12) {
            greeting = (Greeting) factory.getBean("morning");
        } else if (hour < 17) {
            greeting = (Greeting) factory.getBean("after");
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

```java
public interface Greeting {
    public void greet();
}
// afternoon,evening,morning,night 생략
```

2️⃣ **[실습2]** - 단축형

1. 다음에 제시된 사양에 맞춰서 Homework 클래스를 생성한다.
    - String homeworkName 멤버 변수(private)를 선언한다.
    - String homeworkName 을 아규먼트로 받는 생성자를 만든다.
    전달 받은 것으로 멤버 변수를 초기화 한다.
    - homeworkName 의 getter 와 setter를 만든다.
2. 다음에 제시된 사양에 맞춰서 Student 클래스를 생성한다.
    - String name 멤버 변수(private)를 선언한다.
    - Homework myHomework 멤버 변수(private)를 선언한다.
    - 아규먼트를 받지 않는 생성자를 만든다.
    - name과 myHomework 의 getter 와 setter를 만든다.
3. 빈 설정 파일(스프링 디스크립터 파일)에 Homework 클래스의 빈 3개를 생성하는 <bean>태그를 작성한다.
    - Constructor Injection
    이름 설정값
    빈1 : h1 국어
    빈2 : h2 영어
    빈3 : h3 수학
    
    빈 설정 파일에 Student 클래스의 빈 3개를 생성하는 <bean>태그를 작성한다.
    
    - Setter Injection
    이름 설정값
    빈1 : st1 - 둘리, 국어에 대한 Homework 객체
    빈2 : st2 - 또치, 수학에 대한 Homework 객체
    빈3 : st3 - 도우너, 영어에 대한 Homework 객체
    
    빈 설정 파일은 제공된 파일을 resources 폴더에 저장하고 각 요구사항에 알맞게 <bean> 태그를 작성하고 테스트한다.
    bean1.xml - 기본형
    bean2.xml - 단축형
    
4. 메인 클래스(StudyApp)
    
    스프링 IoC 컨테이너에서 st1, st2, st3 이름의 빈 객체들을 찾아와서(DL)하여 다음과
    같이 메시지를 출력한다.
    
    둘리는 국어를 학습합니다.
    또치는 수학을 학습합니다.
    도우너는 영어를 학습합니다.
    
    ```xml
    <!-- bean1-->
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    	<!--HOMEWORK Constructor Injection -->
    	<bean id="h1" class="exam2.Homework">
    		<constructor-arg value="국어"/>
    	</bean>
    	<bean id="h2" class="exam2.Homework">
    		<constructor-arg value="영어"/>
    	</bean>
    	<bean id="h3" class="exam2.Homework">
    		<constructor-arg value="수학"/>
    	</bean>
    
    	<!-- Studnet Setter injection-->
    	<bean id="st1" class="exam2.Student">
    		<property name="name" value="또치" />
    		<property name="myHomework" ref="h1" />
    	</bean>
    	<bean id="st2" class="exam2.Student">
    		<property name="name" value="도우너" />
    		<property name="myHomework" ref="h2" />
    	</bean>
    	<bean id="st3" class="exam2.Student">
    		<property name="name" value="둘리" />
    		<property name="myHomework" ref="h3" />
    	</bean>
    </beans>
    
    <!-- bean2-->
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xmlns:c="http://www.springframework.org/schema/c"
    	xmlns:p="http://www.springframework.org/schema/p"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    	<bean id = "h1" class="exam2.Homework" c:homeworkName="국어" />
    	<bean id="h2" class="exam2.Homework" c:homeworkName="영어" />
    	<bean id="h3" class="exam2.Homework" c:homeworkName="수학" />
    
    	<bean id="st1" class="exam2.Student" p:name="둘리" p:myHomework-ref="h1" />
    	<bean id="st2" class="exam2.Student" p:name="또치" p:myHomework-ref="h2" />
    	<bean id="st3" class="exam2.Student" p:name="도우너" p:myHomework-ref="h3" />
    
    </beans>
    ```
    

```java
public class Student {
    private String name;
    private Homework myHomework;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMyHomework(Homework myHomework) {
        this.myHomework = myHomework;
    }

    public Homework getMyHomework() {
        return myHomework;
    }
}

// HomeWork
public class Homework {
    private String homeworkName;

    public Homework(String homeworkName){
        this.homeworkName = homeworkName;
    }
    public void setHomeworkName(String homeworkName){
        this.homeworkName = homeworkName;
    }

    public String getHomeworkName(){
        return this.homeworkName;
    }
}

//main
public class StudyApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Student [] st = new Student[3];

        for (int i = 0 ; i<st.length ;i++){
            st[i] = (Student)context.getBean("st"+(i+1));
        }
        for (Student s: st) {
            System.out.println(s.getName()+"는 "+s.getMyHomework().getHomeworkName()+"를 학습합니다.");
        }

        ((ClassPathXmlApplicationContext)context).close();
    }
}
```

</div>
</details>


## 🤷‍♀️ today’s feeling
- 추상적이던 xml 문서 형식을 오늘 처음 사용해 봄으로써 개념이 잡혔다.
- 어노테이션 주입만 알고 있었는데 xml 문서로 bean객체를 등록 하는 방법을 알게 됨 -> 어노테이션의 편리성👍
- mybatis도 xml 문서로 작성되었는데 mabatis사용법 예습해보기
