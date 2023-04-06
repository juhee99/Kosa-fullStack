<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1567008394/noticon/ohybolu4ensol1gzqas1.png" height="15%" width="15%"> <br/>

# 2023-04-04 / JS function, Array

🗓️ 날짜           2023/04/03 

☁️ 날씨           ☁️ 대체로 흐림 (17°C)


## 01. javaScript 함수 정의

- 함수란 하나의 로직을 재실행 할 수 있도록 하는것 → 코드의 재사용성을 높여줌
- argument로 함수 전달이 가능하다.
- 가변형 인자(argument)를 지원한다.
- 자바스크립트는 함수와 전역 변수를 먼저 스캔해서 맨 위로 올려서 처리
    - 익명 함수는 호출 전에 작성하고 처리해야 함. → 함수가 아니다. 로 에러

### 1.1 함수 정의 방법

- **선언적(명시적)** 함수 정의 방법
    - function myFunction(argument,..){ 수행할 코드 }
- **표현식(익명)** 함수 정의 방법
    - const myFunction = function(argument..) { 수행할 코드}

### 1.2 argument

- 인자(argument)의 개수와 함수 정의시 선언되어 있는 매개 변수의 개수를 일치하는지 체크하지 않는다.
- 매개변수에 인수를 전달하지 않으면 undefined
- 리턴 값이 없다면 undefind
- 가변 argument를 사용하려면 **`arguments`**(유사 배열)를 사용하면 된다.
    - arguments 는 map, forEach 사용 불가
- 가변 argument 사용하려면 매개변수를 …p 를 사용

### 1.3 함수 VS 메소드

- **함수** : 단독으로 호출이 가능한 것
- **메소드** : 객체를 통해 호출이 가능한 것

### 1.4 즉시 실행 함수 ()()

- outerFunction()(); → outerFunction의 함수 내 리턴하는 함수를 즉시 실행

## 02. JS 배열

### 2.1 Js의 배열의 특징

- 객체로 취급된다.
- 배열의 요소 개수를 가변적으로 처리할 수 있다.
- 배열에 저장할 수 있는 데이터의 타입에 제한이 없다.
- length 속성을 사용하여 요수의 개수를 추출

### 2.2 배열 생성

- 배열 리터럴 사용 : [1,2,3,4,5]
- 생성자 함수 호출 :  new Array()
    - new Array(’abc’,’world’) , new Array(5)

### 2.3 배열의 활용

- concat(array) : 지정 배열을 현재의 배열에 추가
- push(data) : 배열 끝에 요소를 추가
- slice(start, end) : start 부터 end-1번째 까지의 요소들을 추출하여 배열 객체 리턴
- pop() : 배열 끝의 요소를 취득하여 삭제
- shift() : 배열의 맨 앞 요소를 삭제
- unshift(data,…) :  배열의 맨 앞 부터 요소 추가
- reverse() : 역순으로 정렬
- sort() :  오름차순으로 정렬
- toString() : 요소,요소,…의 형식으로 문자열 리턴

## Exercise01 / JS

<details>
<summary> 📜JS 실습 펼쳐보기</summary>
<div markdown="1">

1️⃣ **[실습 1]**

소스명 : exercise3.html

(1) util.js 에 정의된 함수를 사용하여 구현한다.</br>
(2) 웹 페이지의 제목을 `<h1>` 태그와 함께 "자바스크립트 실습(3)" 이라고 파란색으로 출력한다.</br>
(3) window.prompt() 를 사용해서 사용자로 부터 숫자를 입력 받는다.</br>
(4) 입력된 숫자는 자바스크립트 콘솔창에 출력한다.</br>
(5) 1부터 이 숫자까지의 값을 더해서 브라우저의 도큐먼트 영역에 `<h2>` 태그와 함께 출력한다.</br>
"1부터 xx 까지의 합은 xxx 입니다."
(6) 입력된 데이터가 null 거나, "" 이면  "비어있는 입력" 이라는 메시지를
브라우저의 도큐먼트 영역에 `<h3>` 태그와 함께 출력한다.</br>
(7) 입력된 데이터가 숫자가 아니면</br>
브라우저의 도큐먼트 영역에 `<h3>` 태그와 함께 출력한다.</br>

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JS Exam3</title>
</head>
<body>
<script src="util.js"></script>
<script >
writeColor("자바스크립트 실습(3)","h1","blue");
const num=window.prompt("체크하려는 숫자를 입력하세요.");
console.log(num);
let sum = 0;
if(num == '' || num == null ){
	write("비어있는 입력","h3");
}else if(isNaN(num)){
	write(num,"h3");
}else {
	for(let i=1; i <=num; i++){
		sum+=i;
	}
	write("1부터"+num+"까지의 합은"+sum+" 입니다.","h2");
}

</script>
</body>
</html>
```

2️⃣ **[실습 2]**

소스명 : exercise4.html

(1) util.js 에 정의된 함수를 사용하여 구현한다.<br>
(2) 웹 페이지의 제목을 `<h1>` 태그와 함께 "자바스크립트 실습(4)" 이라고 원하는 칼라로 출력한다.<br>

(3) 다음 기능을 처리하는 함수 sum()를 구현해 본다.<br>
- 매개변수를 한 개 선언한다.
- 매개변수에 아무값도 전달되지 않으면 리턴값 없이 리턴한다.
- 1 부터 매개변수에 전달된 숫자값 까지 합을 구하여 리턴한다.

(4) 0부터 5사이의 난수를 하나 추출하여 아규먼트로 전달하면서 sum() 함수를 호출하는데
0이 추출된 경우에는 아규먼트 없이 호출한다.
호출한 다음
리턴값이 있으면 다음 형식으로 브라우저의 도큐먼트 영역에 `<h2>` 태그와 함께 출력하고

호출 결과값 : XX <br>
리턴값이 없으면 다음과 같이 브라우저의 도큐먼트 영역에 `<h3>` 태그와 함께 출력한다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JS Exam4</title>
</head>
<body>
	<script src="util.js"></script>
	<script>
		writeColor("자바스크립트 실습(4)", "h1", "red");

		function sum(num) {
			let sum = 0;
			if (num){
				for (let i = 1; i <= num; i++) {
					sum += i;
				}
				return sum;
			}
		}
		
		let ran;
		let result;
		
		for(let i=0; i<5;i++){
			result = null; // 초기화
			ran = Math.floor(Math.random()*5);
			result= (ran === 0) ? sum() : sum(ran);
			
			if(result){
				write("호출 결과값 : "+result,"h2");
			}else{
				write("결과값이 없어요!","h3");
				
			}
		}
	
	</script>
</body>
</html>
```

3️⃣ **[실습 3]**

소스명 : exercise5.html

(1) util.js 에 정의된 함수를 사용은 선택이다.

(2) 웹 페이지의 제목을 `<h1>` 태그와 함께 "자바스크립트 실습(5)" 이라고 출력한다.

(3) 다음에 제시된 함수들을 구현한다.(for each 문 사용)

- getMaxValue()
- getMinValue()
- getSum()
- getCountOddNum()
- getCountEvenNum()

(4) 다음 값들을 저장하여 배열을 생성한다.

10, 5, 7,21, 4, 8, 18

(5) 배열을 아규먼트로 전달하면서 getSum() 을 호출하고 리턴 결과를 `<h2>` 태그와 함께 출력한다.

  모든 원소의 합 : XX

(6) 최대값과 최소값, 짝수의 갯수 그리고 홀수의 갯수를 각각의 함수를 호출하여 리턴받아 순서없는
리스트 형식(<ul>)으로 출력한다.

- 최대값 : XX
- 최소값 : XX
- 짝수의 갯수 : XX
- 홀수의 갯수 : XX

(7) `<h1>` 태그의 텍스트는 파란색으로, `<h2>` 태그의 텍스트는 빨간색으로 출력한다.<br>
또한 순서없는 리스트의 블렛을 서클로 처리한다.
  
  ```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		function printH1(content) {
			document.write("<h1>" + content + "</h1");
		}
		function printH4(content) {
			document.write("<h4>" + content + "</h4>");
		}

		function apply(arr, fun) {
			console.log(!Array.isArray(arr) , typeof fun !== 'function');
			if (Array.isArray(arr) && typeof fun == 'function') {
				fun(arr); // 함수 호출
				return true;s
			} else {
				window.alert("아규 먼트 오류");
				return false;
			}
		}
		
		
		// 전역 코드 영역
		const datas = [];
		let input = null;
		console.log("찍힌다");

		while (true) {
			console.log("!!!");

			input = window.prompt("데이터를 입력하세요.");
			if (input == null)
				break;
			
			datas.push(input);
		}
		console.log(datas);
		const ran = Math.floor((Math.random() * 10) + 1);
		console.log(ran);

		let result = 0;
		switch (ran) {
		case 1, 4, 6:
			result = apply(datas, printH1);
			break;
		case 3, 4, 6:
			result = apply(datas, printH4);
			break;
		case 8, 9:
			result = apply("ㅋㅋ", printH1);
			break;
		default:
			result = apply(datas);
			break;
		}

		result ? window.alert("처리 성공") : window.alert("처리 실패");
	</script>

</body>
</html>
```

</div>
</details>




## Exercise02 / js function

<details>
<summary> 📜JS function 펼쳐보기</summary>
<div markdown="1">


1️⃣ **[실습 1]**

소스명 : exercise6.html
다음에서 제시된 기능들을 자바스크립트로 구현하시오.

(1) util.js 에 정의된 함수를 사용하여 구현한다.
(2) 매개변수로 년, 월, 일을 아규먼트로 받아 요일명(일요일~토요일)을 리턴하는 함수 getKorDay(y, m, d)를 만든다.
3개의 아규먼트중 한 개라도 Number 타입이 아니면 undefined 를 리턴한다.
(3) 전역 코드 영역에서는 프롬프트 창을 이용해서 년, 월, 일을 각각 입력받아 getKorDay()를 호출하고
리턴 결과가 undefined 타입이면 "결과 없음" 을 h1 태그와 빨간색으로 도큐먼트 영역에 출력한다.
아니면 도큐먼트 영역에 h1 태그와 파란색으로 다음과 같이 출력한다.

xxxx년 xx월 xx일은 X요일입니다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="util.js"></script>
<script>

function getKorDay(y, m, d) {
	if(typeof y == 'number' || typeof m == 'number' || typeof d == 'number' ) {
		return undefined;
	}
	const day =['일요일','월요일','화요일','수요일','목요일','금요일','토요일'];
	var date = new Date(y,m-1,d);
	return day[date.getDay()];	
}

const year = window.prompt("년도를 입력하세요.");
const month = window.prompt("몇 월을 입력하세요.");
const day = window.prompt("일을 입력하세요.")

const result = getKorDay(year,month,day);

result ? /* result == undefined, typeof result =="undefined" */
	writeColor(year+"년 "+month+"월 "+day+"일 "+result+"입니다.","h1","blue") : /* `${year}년 ${month}월 ${date}일은 ${result} 입니다` */
		writeColor("결과 없음","h1","red");   

</script>

</body>
</html>
```

2️⃣ **[실습 2] / arguments**

소스명 : exercise7.html
다음에서 제시된 기능들을 자바스크립트로 구현하시오.

(1). 다음 기능을 처리하는 함수 calc() 를 구현해 본다.

- 아규먼트의 개수에 제한이 없게 한다.
- 아규먼트가 하나도 전달되지 않으면 0 을 리턴한다.
- 전달된 아규먼트중 하나라도 숫자가 아니면 "숫자만 전달하세요" 라는 메시지를 리턴한다.
- 전달된 값을 모두 더하여 리턴한다.

(2) 전역 코드 영역에는 다음과 같이 다양하게 calc() 를 호출하고
결과를 <h3> 태그와 함께 도규먼트 영역에 출력한다.
calc(), calc(10, 20, '30'), calc(10, '가나다', 20), calc(1,2,3,4,5)

0
60
숫자만 전달하세요
15

(3) 모든 구현이 끝나면 exercise7.html 을 exercise7_1.html 로 복사하여 가변 아규먼트 처리를 ES6 로
변경한다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exercise7</title>
</head>
<body>
<script src="util.js"></script>
<script>
function calc(){
	if(arguments.length === 0) return 0;
	let sum = 0;
	for(let i in arguments){
		if(isNaN(arguments[i])) return "숫자만 리턴하세요.";
		sum+=Number(arguments[i]); //parseInt , parseFloat()
	}
	return sum;
}

write(calc(),"h3");
write(calc(10,20,'30'),"h3");
write(calc(10,'가나다',20),"h3");
write(calc(1,2,3,4,5),"h3");

</script>
</body>
</html>
```

3️⃣ **[실습 3]**

소스명 : exercise8.html
다음에서 제시된 기능들을 자바스크립트로 구현하시오.

(1) 다음 사양의 함수를 2개 구현한다.

printH1(content) : content에 전달된 내용을 <h1> 태그와 함께 도큐먼트 영역에 출력한다.
printH4(content) : content에 전달된 내용을 <h4> 태그와 함께 도큐먼트 영역에 출력한다.

(2) 다음 기능을 처리하는 함수 apply() 를 구현한다.

- 매개변수 2개
- 첫 번째 아규먼트로 배열을 두 번째 아규먼트로 함수를 전달받는다.
아규먼트로는 순서대로 배열과 함수를 전달 받아야 한다.
아규먼트가 전달되지 않거나 다른 종류의 아규먼트 종류가 전달되면 브라우저에서 제공하는 자바스크립트 콘솔 창에
"아규먼트 오류"라고 출력하고 false 를 리턴한다.
- 첫 번째 매개변수에 전달된 배열의 원소값들을 두 번째 매개변수에 전달된 함수를 호출하여

도큐먼트 영역에 출력하고(배열의 원소 갯수만큼 호출한다.) true를 리턴한다.

(3) 전역 코드 영역

- 비어있는 배열을 하나 만든다.
- window.prompt()를 사용하여 데이터를(숫자, 문자열 관계없다) 입력받고
입력된 데이터를 배열에 저장한다. 이 작업은 취소 버튼이 클릭 될 때까지 계속 진행한다.
- 입력이 끝나면 1~10 사이의 랜덤값을 추출하여
1, 4, 6 이면 생성된 배열과 printH1을
아규먼트로 전달하면서 apply()를 호출한다.
    
    3, 5, 7 이면 생성된 배열과 printH4를 아규먼트로 전달하면서 apply()를 호출한다.
    
    8, 9 이면  "ㅋㅋ"라는 문자열과 printH1을 아규먼트로 전달하면서 apply()를 호출한다.
    
    그 외의 모든 값이면 이면 생성된 배열만 아규먼트로 전달하면서 apply()를 호출한다.
    
    이 때 추출되는 난수는 자바스크립트 콘솔창에 출력한다.
    
- apply()의 호출 후에 리턴되는 값이 true 이면 "처리 성공" 이라는 메시지를 window.alert() 로 출력한다.
리턴되는 값이 false 이면 "처리 실패" 라는 메시지를 window.alert() 로 출력한다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		function printH1(content) {
			document.write("<h1>" + content + "</h1");
		}
		function printH4(content) {
			document.write("<h4>" + content + "</h4>");
		}

		function apply(arr, fun) {
			console.log(!Array.isArray(arr) , typeof fun !== 'function');
			if (Array.isArray(arr) && typeof fun == 'function') {
				fun(arr); // 함수 호출
				return true;s
			} else {
				window.alert("아규 먼트 오류");
				return false;
			}
		}
		
		
		// 전역 코드 영역
		const datas = [];
		let input = null;
		console.log("찍힌다");

		while (true) {
			console.log("!!!");

			input = window.prompt("데이터를 입력하세요.");
			if (input == null)
				break;
			
			datas.push(input);
		}
		console.log(datas);
		const ran = Math.floor((Math.random() * 10) + 1);
		console.log(ran);

		let result = 0;
		switch (ran) {
		case 1, 4, 6:
			result = apply(datas, printH1);
			break;
		case 3, 4, 6:
			result = apply(datas, printH4);
			break;
		case 8, 9:
			result = apply("ㅋㅋ", printH1);
			break;
		default:
			result = apply(datas);
			break;
		}

		result ? window.alert("처리 성공") : window.alert("처리 실패");
	</script>

</body>
</html>
```

</div>
</details>

## 👩 today’s feeling	
- Array 는 java 보다 훨씬 유연하고 내장 함수가 많아서 편리한 점이 많다.
- JS Array 는 가변적인 점이 편리하다.
- JS의 함수의 리턴값이 없으면 undefined 라는 것을 유념하자!
- 계속 let을 int라 적는다.. js 변수는 let, const ,var
