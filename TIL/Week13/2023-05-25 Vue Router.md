<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1568683636/noticon/hkuhbyocl2mx2keas7ng.png" height="15%" width="15%"> <br/>


🗓️ 날짜            2023/05/25

☁️ 날씨            🌥️ 대체로 흐림(19 °C)


## 01. Router

💡 싱글 페이지 애플리케이션에서 컴포넌트를 옮기기 위해 클라이언트에서 미리 가지고 있던 페이지를 라우팅을 이용해서 화면을 갱신

- 클라이언트에서 url주소에 따라 페이지가 전환되는 것

### 1.1 CDN 방식

```html
<script src="https://unpkg.com/vue-router@4"></script>
```

### 1.2 Router 구현

1. 라우터 객체 생성
    - url과 컴포넌트 연결 - 라우터 정보 작성

```jsx
const router = VueRouter.createRouter({
      history: VueRouter.createWebHashHistory(),
      routes: [
        {
          path: "/one",
          component: Comp1,
        },
        {
          path: "/two",
          component: Comp2,
        },
        {
          path: "/three",
          component: Comp3,
        },
      ],
    });
```

1. App.vue
    - <router-link to=”경로> 태그
        - 컴파일 시 <a>태그로 변환

```jsx
<div id="app">
    <h1>{{abc}}</h1>
    <p>
      <router-link to="/one">라우터1</router-link>
      <hr>
      <router-link to="/two">라우터2</router-link>
      <hr>
      <router-link to="/three">라우터3</router-link>
    </p>
    <!-- 현재 라우트에 맞는 컴포넌트가 렌더링 -->
    <router-view></router-view>
  </div>
```

## 02. Vue cli 설치

1. **npm install -g @vue/cli**
2. vue create 프로젝트명
3. vue3 선택 - 기본 설정

<img src="https://github.com/juhee99/Kosa-fullStack/assets/55836020/c8e5ad75-c0d6-49be-80ff-62d1cd5eeedb" width="80%" />

## 03. Composition API

💡 v3에 추가된 기능, 컴포넌트 로직을 유연하고 간편하게 구현할수 있는 함수 기반의 API

- 이전에 했던 방식은 Option API 방식
- setup에서 설정한 메솓,변수 등 을  template에서 사용하기 위해서 객체로 리턴해야 함.

1️⃣ **[방법 1]**

```jsx
setup() {
    const date1 = Date().toString()
    return {
      date1,
    }
  }
```

2️⃣ **[방법 2]**

위 코드와 동일함

```jsx
<script setup>
   const date3 = Date().toString()
</script>
```

## 04. 반응형 데이터

💡 컴포넌트 또는 DOM에 접근하기 위해 사용하는 속성, 반응형 데이터를 생성할 수 있다.

- **기본형은 ref() , 객체형은 reactive()**
- script 영역에서 ref의 값을 변경하기 위해서는 value 라는 속성을 사용해야한다.
- template영역에서는 그냥 사용하면 됨
- 마운트된 요소에만 적용 가능하다.
- v-for 와 같이 사용하기 위해서는 key를 줘야한다.

```jsx
setup() {
		const counter = ref(0);
		const increment = () => counter.value++;
		onMounted(() => {
			console.log('애플리케이션이 마운트 되었습니다!');
		});
		return {
			counter,
			increment,
		};
	},

//template에 for 사용 예시
<li v-for="item in items" v-bind:key="item.name">
        {{ item.name }}: {{ item.price }} 원
</li>
```

### 4.1 Watch

- 지정된 데이터가 변화 될 때 마다 함수를 실행

```jsx
const price = ref(10000);
watch(price, (cur,prev) =>{
	//price = 대상 객체
	//cur = 현재 상태
  //prev =
	
},
{
	immediate : true // 처음 만들어 졌을 때도 즉시 수행
}
```

## 기타

- 책 p.72 : 라우터
- 책 p.55 :프로젝트 생성
- <style scoped> : scpoed 가 없으면 전역적으로 적용되지만 scoped 속성을 주면 컴포넌트의 지역적으로 적용된다.

## 🤷‍♀️ **today’s feeling**

- watch는 react의 useeffect 과 비슷
- ref나 reactive는 useState와 비슷
