<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1567008394/noticon/ohybolu4ensol1gzqas1.png" height="15%" width="15%"> <br/>


🗓️ 날짜            2023/04/06 

☁️ 날씨           🌧️ 흐림 (10°C)


## 01. JS의 이벤트 모델

💡 DOM 객체에 이벤트를 연결하는 다양한 방법

- 인라인 이벤트 모델 - 지역적
- 고전 이벤트 모델  - 전역적
- 표준 이벤트 모델  - 전역적

### 1.1 인라인 이벤트 모델

💡 이벤트 핸들러를 등록하고자 하는 대상의 HTML태그에 속성으로 정의하는 모델

- 인라인 이벤트는 이벤트를 해제할 방법이 없다.
- <태그명 on이벤트명=”처리코드”>
- <태그명 on이벤트명=”처리코드; return false”>
    - return false → 기본 이벤트 handler를 처리하지 않음

### 1.2 고전 이벤트 모델

💡 이벤트 핸들러를 등록하고자 하는 대상의 DOM 객체를 찾아서 이벤트 핸들러를 등록하는 모델이다.

- 태그의 DOM 객체를 찾는다.
- event를 하나만 등록 할 수 있다 → 마지막으로 등록된 이벤트
- DOM객체.on이벤트명 =  함수
- DOM객체.on이벤트명 = null
    - onXXX ⇒ 반드시 소문자여야 한다.
    - 함수 내 return false → 기본 이벤트 핸들러를 처리 하지 않음
    

### 1.3 표준 이벤트 모델

💡 이벤트 연결/해제 메서드들을 모든 DOM 객체들이 지원함 → 이벤트 핸들러를 등록하려는 DOM 객체에 대하여 이벤트 연결/해제 메서드를 사용한다.

- 태그의 DOM 객체를 찾는다.
- event를 여러개 등록 할 수 있다. → 등록된 순서대로 호출
- DOM객체.addEventListner(이벤트명,핸들러)
- DOM객체.removeEventListner(이벤트 명,핸들러) : 이벤트 제거

---

**[예제]**

```html
<h1 onclick = "f1(this)";> </h1> //1. 인라인이벤트 모델을 함수로 연결
<h1 id="t1">고전 이벤트 모델</h1>
<script>
function f1(t) {
		alert(t.textContent);
	}

const dom2 = document.querySelector('#t1');
function f2(e) {
		alert(e);
		alert(e.target.textContent);
		alert(this.textContent);        //2. 전역
	}
dom2.onclick = f2; // 고전 이벤트 모델
</script>
```

- 1 의 this → 이벤트가 발생한 본인을 parameter로 전달
- 2 this → 이벤트가 발생한 대상 객체
- e.target  —> 이벤트가 발생한 대상 객체

## event Bubbling , event Capture

<img src="https://user-images.githubusercontent.com/55836020/230358378-5247dda0-38f4-4474-82bf-274b9f53ffb4.png" width="50%"/>

### event bubbling

💡 이벤트가 발생했을 때 해당 이벤트가 더 상위의 화면 요소들로 전달되는 특성이다.

- body태그가 최상위 요소이다.
- 버블링 되었을 때 this. 는 e.currentTarget을 의미한다.
- e.stopPropagation(); → 버블링을 중지하는 메서드

### event Capture

💡  브라우저부터 이벤트가 발생한 요소까지 이벤트를 전달(전파)

- dom.addEventListener(’이벤트 명’ , 함수, { capture: true})
    - default 는 false → true면 버블링과 반대 방향으로 탐색

> e.target.nodeName → 이벤트가 발생된 대상 객체의 태그 이름
> 
> 
> e.currentTarget —>이벤트 핸들러를 위임받은 대상객체
> e.target → 이벤트 발생 객체 ⇒ 버블되더라도 변하지 않음
> 

## onload

💡 웹페이지(DOM 데이터)의 로딩이 끝나는 시점에 실행되는 함수 → 로딩 후 실행시킬 코드

- window.onload = function() {…} →script 내
- <body onload=”js 함수명” >
- window.onload와 <body onload=””>는 동시에 사용 할 수 없다. →body내 있는 onload만 실행된다.

## 호출 스케쥴링

💡일정 시간이 지난 후에 원하는 함수를 예약 실행(호출)할 수 있게 하는 것

- setTimeout(함수명, n) : 일정 시간이 지난 후 함수 실행 —> 단발성
- setInterval(함수명,n): 일정 시간 간격을 두고 함수를 실행하는 방법 → 반복
- setTimeout , setInterval 은 스케쥴링의 식별자를 리턴 한다.
- 스케쥴링 취소하기 :clearTimeout(스케쥴링 id);

## Exercise01 / event Model

<details>
<summary>📜eventModel 실습 펼쳐보기</summary>
<div markdown="1">

1️⃣ **[실습 1]**

<img src="https://user-images.githubusercontent.com/55836020/230358016-84da3ac3-8375-4f11-b971-4d711d2b48f7.png" width="80%"/>

1. **exercise11_1.html / 인라인 모델**

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이벤트 모델-인라인</h1>
	<hr>
	<button onclick="changeColor('red')">빨강색</button>
	<button onclick="changeColor('blue')">파랑색</button>
	<button onclick="changeColor('yellow')">노랑색</button>
	<hr>
	<h2></h2>

	<script>
		const nowDate = new Date();
		const date = document.getElementsByTagName("h2")[0];
		date.innerHTML += `오늘은 ${nowDate.getMonth()+1}월 ${nowDate.getDate()}일 입니다.`;

		const title = document.getElementsByTagName("h1")[0];
		function changeColor(color) {
			title.style.color = color;
		}
	</script>
</body>
</html>
```

1. exercise11_2.html

```html
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이벤트 모델-고전</h1>
	<hr>
	<button value = "red">빨강색</button>
	<button value="blue">파랑색</button>
	<button value="yellow">노랑색</button>
	<hr>
	<h2></h2>	
	
	
	<script>
	const nowDate = new Date();
	const date = document.getElementsByTagName("h2")[0];
	date.innerHTML += `오늘은 ${nowDate.getMonth()+1}월 ${nowDate.getDate()}일 입니다.`;

    const title = document.getElementsByTagName("h1")[0];	
	function changeColor() {
		title.style.color = this.value;
	}
	
	
	const bnts = document.getElementsByTagName("button");
	bnts[0].onclick = changeColor
	bnts[1].onclick = changeColor
	bnts[2].onclick = changeColor
	
	</script>
</body>
</html>
```

1. exercise11_3.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이벤트 모델-표준</h1>
	<hr>
	<button value="red">빨강색</button>
	<button value="blue">파랑색</button>
	<button value="yellow">노랑색</button>
	<hr>
	<h2></h2>

	<script>
		const nowDate = new Date();
		const date = document.getElementsByTagName("h2")[0];
		date.innerHTML += `오늘은 ${nowDate.getMonth()+1}월 ${nowDate.getDate()}일 입니다.`;

		const title = document.getElementsByTagName("h1")[0];
		function changeColor() {
			title.style.color = this.value;
		}

		const bnts = document.getElementsByTagName("button");
		bnts[0].addEventListener("click", changeColor);
		bnts[1].addEventListener("click", changeColor);
		bnts[2].addEventListener("click", changeColor);
	</script>
</body>
</html>
```

2️⃣ **[실습 2] -exercise12.html**

<img src="https://user-images.githubusercontent.com/55836020/230358044-c6ee8920-9554-4a59-a448-b3e7cad10dbd.png"/>

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
<style>
h1{
text-align: center;
color :#7286D3;

}
span{
padding :2%;
}
hr{
height: 2px;
background-image: linear-gradient(to left , #A75D5D, #F0997D, #FCF9BE);
border: 0;
}

button {
	border : 1px solid #E74646 ;
	border-radius : 15%;
	color : white;
	background-color : #E74646;
	text-align: center;
	margin : 1%;
	width: 8%;
}
div{
text-align: center;
color : #DF7857;
}
</style>
</head>
<body>
<h1 onclick="moveGugudan()">구구단</h1>
<hr>
<span>
</span>
<hr>
<div>

</div>
<script>
function moveGugudan() {
	location.href = 'https://ko.wikipedia.org/wiki/구구단'; 
}

const spanDom = document.querySelector("span");

for(let i=1 ; i<10 ; i++){
	spanDom.innerHTML += `<button onclick="calc(${i})">${i}단</button>`;
}

const dom = document.querySelector("div");

function calc(num) {
	if(dom.innerHTML)dom.innerHTML = "";

	for(let i=1; i<10 ; i++){
		dom.innerHTML += `<h3> ${num}*${i} = ${num*i} </h3>`
	}
	
}

</script>
</body>
</html>
```

</div>
</details>


## Exercise02 / event bubbling

<details>
<summary>event bubbling 실습 펼쳐보기</summary>
<div markdown="1">


- 표준 이벤트 모델,이벤트 처리 함수1개, 1개의 DOm객체에 이벤트 핸들러를 등록하여 해결한다.
- 버튼을 클릭하면 (맑음,흐림,비) 그에 맞는 사진이 나타난다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exercise13</title>
<style>
body {
	text-align: center;
}
h1{
 color : #A4BC92; 
 text-shadow : 1px 1px 2px #DDFFBB;
}
#btnContainer {
	border: 1px dashed #92B4EC;
	border-radius : 25px;
	width: 50%;
	height: 100px;
	margin: 0 auto;
}

button {
	display: inline-block;
    margin-top: 40px;
    background-color : #C0DBEA;
    border : 1px solid #FEFF86;
}

</style>
</head>
<body>
	<h1>이벤트 처리 실습</h1>
	<hr />
	<div id="btnContainer">
		<button value='sun'>맑음</button>
		<button value='cloud'>흐림</button>
		<button value='rain'>비</button>
	</div>
	<hr/>
	<div id="weatherContent"></div>
	<script>
	
	
	function showWeatherHandelr(e) {
		if(e.target.nodeName === 'BUTTON') { // div는 거를 수 있게 조건!
			const src = `../../images/${e.target.value}.png`;
			const dom = document.getElementById("weatherContent");
			dom.innerHTML = `<img src='${src}' width="50%" />`;
			}
	}
	
	const dom = document.getElementById("btnContainer");
	dom.addEventListener("click",showWeatherHandelr);
		
	</script>
</body>
</html>
```


</div>
</details>


## 👩 today’s feeling + 기억할 점❗

- 유지보수 할 때 고전 이벤트 보다는 **표준 이벤트** 처리에 유리하다..!  → 이벤트를 다중으로 등록이 가능하기 때문에
- 버블 이벤트 활용 : 상위 요소에서 하위 요소의 이벤트를 제어하는 방식 → 리스너를 하나만 만들어도 여러 이벤트 동작 가능하다..!
- 버블 이벤트는 html이 트리 구조 이기때문에 가능하다,,,!
- 변수명 신경쓰기!
