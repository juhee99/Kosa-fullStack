<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1568683636/noticon/hkuhbyocl2mx2keas7ng.png" height="15%" width="15%"> <br/>

# 2023-05-22 / ECMAScript6

🗓️ 날짜           2023/05 /22

☁️ 날씨            ☁️ 흐림 (16 °C) -> 밤에 비

</br>

## 01. 웹 렌더링 방식(SSR, CSR, SSG)

### 1.1 초기 웹 렌더링

- 초창기 모든 웹 페이지가 정적인 페이지 였다.
- 화면에 어떠한 변화를 주려고 화면을 전환하면 그 때 마다 서버로 부터 새로운 HTML을 전송 받아서 다시 렌더링하는 방식이다.

### 1.2 CSR

💡 클라이언트 사이드에서 전적으로 웹렌더링을 책임지는 방식이다.

- 서버에서 내용 없는 빈 HTML 껍데기를 보내면 클라이언트에서 동적으로 태그들과 스타일을생성하여 페이지를 채운다.
- `Single Page Applications`(SPAs) : 최초에 Single Page만 서버로부터 불러와 렌더링하고 그 이후에는 모든 것을 클라이언트 사이드에서 렌더링 하는 어필리케이션이다.
- `SEO`(Search Engine Optimization) 문제가 있다.
- 많은 양의 자바스크립트 코드가 실행되다 보니 성능적인 이슈도 생겨났다.

### 1.3 Static Site Generation(SSG)

- 모든 유저들에게 동일하게 보여주는 사이트일 경우, 한 번만 생성한 이후에 CDN으로 어딘가에 저장해두고 필요할 때 마다 로드하는 것
- 정적인 웹 페이지를 빌드한 후 산출물을 CDN으로 배포하는 것.

### 1.4 Jamstack

💡 jam은  JavaScript, API, Markup의 약자이다.

- jamstack은 서버를 사용하지 않고 정적인 페이지를 만들어 저렴한 비용으로 호스팅하는 방식
- 클라우드 서버를 활용하여 서버를 직접적으로 개발하지 않고 사용하는 방식

### 1.5 SPA(single-page application)

💡 단일 페이지 애플리케이션으로, 현재의 페이지를 동적으로 작성하여 사용자와 소통하는 동적인 애플리케이션이다.

- 프론트엔드와 백엔드 영역의 분리가 선행되어야 한다.
- Vue의 방식

## 02. Same Origin Policy (SOP)

💡 한 Origin에서 로드된 문서 또는 스크립트가 다른 Origin의 리소스와 상호 작용할 수 있는 방법을 제안하는 중요한 보안 매커니즘

<img src="https://github.com/juhee99/Kosa-fullStack/assets/55836020/7a2a1f81-4a2c-4a24-9bf7-a489326ad63e" />

> sop에 의한 오류 발생 예
>

- 클라이언트 요청이 리소스(서버)의 출처만 허용하는 정책
- contents를 보호 하기 위한 정책
- 브라우저가 보호 하고 있음

### 2.1 해결방법

- 서버 Controller  : *@CrossOrigin*(origins = "*", allowedHeaders = "*")
- 응답 헤더에 : Access-Control-Allow-Origin:*
- spring config 설정하기, WebMvcConfigure 인터페이스를 상속받아 구현

## 03. javaScript 문법

### 3.1 fetch

- http로  리소스를 비동기적으로 가져오는 인터페이스

```jsx
fetch(url,{
method : 'post'
headers: {
	'Content-Type' : 'application/json'
	}
})
.then(res => {})
```

### 3.2 async-await

- async는 function 앞에, 프로미스를 반환
- Promise 객체
    - resolve → 정상처리 되었을 때 / then
    - reject → 오류나 실패시 / catch문

```jsx
function sum(num1, num2) {
			return new Promise(function(resolve, reject) { 
				setTimeout(function() {
					var result = num1 + num2;
					console.log(num1 + " + " + num2 + " = ");
					resolve(result);
				}, 2000);
			});
		}

async function prcessAsync(){
	const res = await sum(10,20);
}

prcessAsunc();
```

## 04. Module

💡 자바스크립트 코드의 일부를 재사용하려는 경우 모듈을 사용한다.

- export - 모듈 내보내기
    - export 지시자를 변수나 함수 앞에 붙이면 외부 모듈에서 해당 변수나 함수에 접근할 수 있다.
    - export 는 여러개 가능하지만, export default는 한번만 가능
- import - 모듈 가져오기
    - import 지시자를 사용하면 외부 모듈의 기능을 현재 모듈로 가져올 수 있다.
    - import {component1,component2,…} from module_name
    - import 이름 from module_name : default 는 이름을 마음대로 할 수 있음


## 🤷‍♀️ **today’s feeling**

- cors 정책 반영해서 프로젝트에 적용해보기-> 보안을 위해 특정클라이언트 서버에서 오는 요청만 받게 적용
- async-await 와 promise 예시 더 찾아보기
- 나중에 fetch 말고 axios 배운다 함.
-
