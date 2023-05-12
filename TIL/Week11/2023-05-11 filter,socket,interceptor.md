<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566778017/noticon/ytjm1rralodyhvuggrpu.png" height="15%" width="15%"> <br/>


🗓️ 날짜            2023/05/11

☁️ 날씨           ☀️ 맑음 (15°C)


## 01. Spring Scheduling

💡 특정 시간에 반복적으로 처리되는 코드를 스케쥴링 할 수 있다. 이 때 반복적으로 수행 되는 코드를 Task 라고 한다.

### 1.1 환경 설정

- build.gradle
    - implementation 'org.springframework.boot:spring-boot-starter-quartz’
    - testImplementation 'org.springframework.boot:spring-boot-starter-test’
- XXXApplication 클래스
    - @EnableScheduling

### 1.2 Task 기능 메서드

💡 설정 주기에 맞춰서 호출되는 Task 메서드 앞에 @Scheduled 어노테이션을  추가해야한다.

**[속성]**

- cron: CronTab에서의 설정과 같이 cron = “ 초 분 시 일  월 요일”
- fixedDelay : 이전에 실행된 Task의 종료시간으로 부터 정의된 시간만큼 지난 후 Task를 실행
- fixedRate : 이전에 실행된 Task의 시작시간으로 부터 정의된 시간만큼 지난 후 Task를 실행한다.
    
## 2.1 필터

💡 Spring은 공통적인 여러 작업을 대신 처리하며 개발 시 중복된 코드를 제거할 수 있도록 기능을 제공 →filter,interceptor

### 2.2 Filter

💡 필터는 DispatcherServlet에 요청이 전달되기 전/후에 url 패턴에 맞는 모든 요처엥 대해 부가작업을 처리할 수 있는 기능을 제공

<img src="ttps://github.com/juhee99/Msa-Dkteckin-fullstack/assets/55836020/6e098be3-19d1-4696-898c-f9829f1ff116" width="80%"/>

**[ filter method ]**

- 필터를 추가하기 위해 Filter 인터페이스를 상속 받아야 한다.

```java
@Component
@Slf4j
@Order(1)
public class TestFilter2 implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                        throws IOException, ServletException{
        log.info("[필터2] 요청 자원 수행 전");
        chain.doFilter(request, response);
        log.info("[필터2] 요청 자원 수행 후");
    }
}
```

## 03. Interceptor

💡 인터셉터는 Spring이 제공하는 기술로써, DispatcherServlet이 컨트롤러 호출되기 전과 후에 요청과 응답을 참조하거나 가공하는 기능을 제공

- spring의 자원을 사용할 경우 interceptor을 사용

<img src="https://github.com/juhee99/Msa-Dkteckin-fullstack/assets/55836020/1e68a873-fd28-497c-865f-a998db5beb10" width="70%/>

> 웹 컨테이너에서 동작하는 필터와 달리 인터셉터는 스프링 컨텍스트에서 동작
> 
- void init(FilterConfig filterConfig)
    - init메서드는 필터 객체 초기화하고 서비스에 추가하기 위한 메서드
    - 한번만 실행
- void doFilter(ServletRequest request, ServletResponse response,
FilterChain chain) throws IOException, ServletException {}
    - 모든 http요청이 dispatcherServlet으로 전달되기 전에 웹 컨테이너에 의해 실행
    - chain.doFilter(req,res) 전/후에 필요한 처리 과정
- void destroy() {}

### 3.1 **[ interceptor method ]**

- org.springframework.web.servlet의 HandlerInterceptor 인터페이스를 구현 해야 한다.
- boolean preHandle(HttpServletRequest request,
HttpServletResponse response, Object handler)
    - 컨트롤러가 호출되기 전에 실행, `컨트롤러 이전`에 처리해야 하는 전처리 작업이나 요청 정보를 가공하거나 추가하는 경우 사용
- postHandle(HttpServletRequest request, HttpServletResponse response,
Object handler, @Nullable ModelAndView modelAndView)
    - 컨트롤러 호출 된 후에 실행
    - ModelAndView의 부가적인 작업을 해야할 때
    - controller작업 중 error 발생하면 실행되지 않음
- void afterCompletion(HttpServletRequest request, HttpServletResponse
response, Object handler, @Nullable Exception ex)
    - 모든 뷰에서 최종 결과를 생성하는 일을 포함해 모든 작업이 완료된 후에 실행된다.
    - error 발생하더라도 실행

### 3.2 인터셉터의 등록

- config 클래스를 만든다
- @Configuration 추가

#### config 예제
```java
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/hello"); // controller의 Path 설정

        /*
        registry.addInterceptor(인터셉터객체)
                .addPathPatterns("/*") -  모든 Path 적용
                .addPathPatterns("/sample") - /sample Path 에 대해서만 적용
                .excludePathPatterns("/sample"); - /sample Path 에 대해서만 제외
        */
    }
}
```

## 오류 처리

### @ExceptionHandler

💡 스프링 컨트롤러에서 정의한 메소드에서 기술한 예외가 발생되면 자동으로 받아낼 수 있다.

```java
@ExceptionHandler(FriendNotFoundException.class)
 public String handleNotFoundException() throws IOException {
 System.out.println("FriendNotFoundException 발생시 처리하는 핸들러가 오류 처리합니다.");
 return "noFriend";
 }
```

- (exception type)  exception 이 발생하면 메서들을 호출하여 오류를 처리
- 직접 구현한 메소드로 오류를 처리하는 방법이다.

### @ControllerAdvice

💡 클래스 위에 @ControllerAdvice를 붙이고 어떤 예외를 잡아낼 것인지 내부 메소드를 선언하여 @ExceptionHandler와 같이 기술한다.

- 전역적인 예외 처리

> ExceptionHandler 과 ControllerAdvice 가 발생했을 때 지역적 방법이 우선순위가 높다.
>


## 04. 웹 소켓(WebSocket) 프로그래밍

💡HTTP 환경에서 클라이언트와 서버 사이에 하나의 TCP 연결을 통해 실시간으로 `양방향 통신`을 하는 프로토콜이다.

- 실시간 알림, 실시간 채팅

![](https://github.com/juhee99/Msa-Dkteckin-fullstack/assets/55836020/3abdee92-748e-4d26-b10e-b69e32360e58)

- http는 stateless(비연결성)로 req,res가 한 쌍
- socket은 양 방향

### 웹 소켓 통신 방식

- 웹 소켓은 전 이중 통신이므로, 연속적인 데이터 전송의 신뢰성을 보장하기 위해 Handshake 과정을 진행한다.
- http 프로토콜을 web socket으로 전환 :  Http upgrade → 양방향 통신 → close

### 웹 소켓 클라이언트 구현 -자바스크립트+HTML5 API

1. 서버 연결
    - html5 제공하는 WebSocket 객체를 통해 서버 연결을 수행한다.
    - 일반 통신은 ws, 보안 통신은 wss 프로토콜을 이용한다
    - let ws = new WebSocket(”웹 소켓 url 문자열”)
    - 웹 소켓 URL 문자열 : ws://서버주소/웹 소켓 서버 프로그래밍의 매핑명
2. 데이터 수신
    - 서버에서 전송되는 데이터를 받으면 message 이벤트를 구현
    - ws.onmessage = function(e) {e.data로 추출하여 메시지 처리}
    - @ServerEndpoint 어노테이션 선언되어있는 클래스는 웹 소켓에 관한 환경 설정 파일 이다.
    
    ### @ServerEndpoint  클래스
    
    ```java
    @Service
    @ServerEndpoint(value="/chatt")
    public class WebSocketChatt {
    private static Set<Session> clientSet = 
    Collections.synchronizedSet(new HashSet<Session>());
    @OnOpen
    public void onOpen(Session s) {
    	if(!clients.contains(s)) {
    	clientSet.add(s);
    	System.out.println("[세션 오픈] " + s);
    	}else {
    	System.out.println("이미 연결된 세션임!!!");
    	}
    }
    @OnMessage
    public void onMessage(String msg, Session session) throws Exception{
    	System.out.println("[수신 메시지] " + msg);
    	for(Session s : clientSet) {
    	System.out.println("[송신 메시지] " + msg);
    	s.getBasicRemote().sendText(msg);
    	}
    }
    @OnClose
    	public void onClose(Session s) {
    	System.out.println("[세션 종료] " + s);
    	clientSet.remove(s);
    	}
    }
    ```


## 👩 today’s feeling + 기억할 점❗

- 2차 프로젝트때 socket 사용해봐도 좋을거 같다
- 미니 프젝 오류 처리해보기
- scheduling은 하루마다 날짜 갱신할 로직을 처리할때 유용할거 같다
