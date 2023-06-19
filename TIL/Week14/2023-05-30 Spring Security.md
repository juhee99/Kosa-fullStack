<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1686935854/noticon/r7w1ipwmdmhlfzqfw69h.png" height="15%" width="15%"> <br/>

# 2023-05-30 / Spring Security

🗓️ 날짜           2023/05/30

☁️ 날씨            ☀️ 맑음 (22 °C)

## 인증과 인가

1. **Authentication(인증)** 
    - 특정 대상이 ‘누구’인지 확인하는 절차
    - 해당 사용자가 본인이 맞는지 확인하는 절차
2. **Authorization(권한부여,인가)**
    - 인증된 주체가 특정한 곳에 접근 권한을 확인하고 허용하는 과정이다.
    - role에 따른 권한 부여

## spring Security

💡 Spring 기반의 어플리케이션 보안(인증과 권한,인가 등)을 담당하는 스프링 하위 프레임워크이다.

- Security는 인증과 권한에 대한 부분을 Filter의 흐름에 따라 처리 하고 있다.
- spring security는 여러가지 필터로 이루어져 있고 필터들이 순서대로 동작한다. 이러한 구조를 Filter Chain이라고 한다.
- Filter는 Dispatcher Servlet전에 수행된다.

![Untitled (9)](https://github.com/juhee99/Kosa-fullStack/assets/55836020/d45f84da-6430-4c9b-a2f9-69572ee50788)

- Spring Security에서는 인증과 인가를 위해 Credential 기반의 인증 방식을 사용한다,
    - Principal(접근 주체) : 보호 받는 Resource에 접근하는 대상
    - Credential(비밀번호) : Resource에 접근하는 대상의 비밀번호

## SecurityConfig

💡2.7이후 부터 WebSecurityConfigurerAdapter가 Deprecated 되어 SecurityFilterChain를 Bean으로 등록해서 사용한다.

- authorizeRequest() : 보안 절차를 거쳐야 한다.
- anyRequest() : 누구든 접속 가능하다.
- authenticated() : 인증을 받아야 함
- formLogin()  : 폼 로그인 , 스프링이 제공하는 로그인 폼

```java
public class SecurityConfig {
	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.formLogin()
			 .login("/login")                            //사용자가 정의한 로그인 페이지
			 .defaultSuccessUrl("/home")                 // 로그인 성공 후 이동하는 페이지 
			 .failureUrl("/login")                       // 로그인 실패 후 이동하는 페이지
			 .usernameParameter("username")              // 폼 태그에 사용되는 아이디 파라미터명
			 .passwordParameter("password")              // 폼 태그에 사용되는 비밀번호파라미터
			 .loginProcessingUrl("/login")               // 폼 태그에 사용되는 url
			 .successHandler(loginSuccessHandler())      // 로그인 성공 후 실행되는 handler
			 .failereHandler(loginFailureHander())       // 로그인 실패 후 실행되는 handler

	 return http.build();
}
```

## Login Form 인증 절차

![Untitled (10)](https://github.com/juhee99/Kosa-fullStack/assets/55836020/0bfbf80b-d493-40a1-8be2-80d09fd1c778)

1. http Request가 서버로 넘어온다
2. AuthenticationFilter가 요청을 낚아챈다 → Request의 Username, password를 이용하여 UsernamePasswordAuthentication Token을 생성한다.
3. 토큰을 AuthenticationManger가 받는다 
4. AuthenticationManger 는 토큰 AuthenticationProvider에게 토큰을 넘긴다.
5. AuthenticationProvider는 UserDetailsService로 토큰의 사용자 아이디(username)을 전달하여 DB에 존재하는지 확인한다.
6. UserDetailsService는 DB의 회원정보를 UserDetails 라는 객체로 반환한다
7. AuthenticationProvider는 반환받은 UserDetails 객체와 실제 사용자의 입력정보를 비교한
다.
8. 비교가 완료되면 사용자 정보를 가진 Authentication 객체를 SecurityContextHolder에
담은 이후 AuthenticationSuccessHandle를 실행한다.(실패시 AuthenticationFailureHandler를 실행한다.)

> UserDetailsService 만 구현하면 된다.
> 

## Token 인증 방식

1. 클라이언트가 서버에 접속을 하면 서버에서 해당 클라이언트에게 인증되었다는 의미로 ‘토큰’을 부여한다. 

1. 이 토큰은 유일하며 토큰을 발급받은 클라이언트는 또 다시 서버에 요청을 보낼 때 요청 헤더에 토큰을 심어서 보낸다. 
2. 그러면 서버에서는 클라이언트로부터 받은 토큰을 서버에서 제공한 토큰과의 일치 여부를 체크하여 인증 과정을 처리하게 된다.

- 토큰은 세션과 달리 서버가 아닌 클라이언트에 저장 되기 때문에 메모리나 스토리지 등을 통해 세션 관리 했던 서버의 부담을 덜 수 있다.
- DB연동 조회를 최초 한번만 하기 때문에 네트워크 부하를 줄일 수 있다.
- 인증요청이 많은 클라이언트가 적합
- 토큰 탈취의 위험이 있기 때문에 사용 기한 제한을 설정(자주 바꾸는 방법)

## JWT(JSON Web Token)

💡 JWT(JSON Web Token)란 인증에 필요한 정보들을 암호화 시킨 JSON 토큰을 의미한다.

- JWT토큰을 HTTP헤더에 실어 서버가 클라이언트를 식별하는 방식이다.
- JWT는 JSON 데이터를 Base64 URL-safe Encode를 통해 인코딩하여 직렬화 한것

### JWT 구성

**xxxxxx.yyyyyy.zzzzz  ⇒ 헤더.내용.서명**

- 헤더(Header) : jwt에서 사용할 타입, 해시 알고리즘의 종류
- 내용(Payload) : 서버에게 보낼 사용자 정보
- 서명(Signature) : header, Payload를  Base64 URL-safe Encode를 한 후 이후 Header에 명시된 해시함수를 적용하고, **개인키(private key)**로 서명한 전자서명

![Untitled (11)](https://github.com/juhee99/Kosa-fullStack/assets/55836020/6a93b2a2-4423-44a9-852c-47b33aef8869)