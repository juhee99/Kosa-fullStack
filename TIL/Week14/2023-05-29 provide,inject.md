<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1568683636/noticon/hkuhbyocl2mx2keas7ng.png" height="15%" width="15%"> <br/>

# 2023-05-29 / provide, inject

🗓️ 날짜           2023/05 /26

☁️ 날씨            ☔ 비 (21 **°C**)


## 01. provide 와 inject

💡 부모 컴포넌트는 모든 자식 컴포넌트에 대한 의존성 제공자 역할을 할 수 있다. 하위 트리의 모든 컴포넌트는 깊이에 관계없이 상위 체인의 컴포넌트에서 제공(provide)하는 의존성을 주입(inject)할 수 있다.

![provied](https://github.com/juhee99/Kosa-fullStack/assets/55836020/71955c57-c42a-4547-a087-c06791c99f7e)

1️⃣ Provide

```html
<script setup>
import ProvideInjectChild from './ProvideInjectChild';
import { provide, ref, reactive } from 'vue'

provide('pmess', '안녕?');
const count = ref(10); // 반응성 있는 데이터
provide('pnum', count);
const obj = reactive({ // 반응성 있는 데이터
  name: "유니코",
  age: 20
});
provide('pobj', obj);
</script>
```

2️⃣ Inject

```html
<script setup>
import { inject, provide } from 'vue'
import ProvideInjectGrandChild from './ProvideInjectGrandChild';

const message = inject('pmess');
const number = inject('pnum');
const obj = inject('pobj');
provide("pnum", number.value + 100);
</script>
```

## 02. VueX

💡 부모 자식 관계가 아니더라도 데이터를 공유할 수 있다. vuex객체는 데이터를 공유하고 처리

- state : 뷰 컴포넌트에서 사용되는 데이터
- getters : 뷰 컴포넌트의 computed()와 동일한 기능을 작성하는 부분, state 데이터를 읽기만 가능
- mutations :  뷰 컴포넌트의 methods()와 동일한 기능을 작성하는 부분,
    - state 값 변경 기능
- actions: 쌍방통행 함수(=methods)이 외의 함수를 작성하는 부분
    - mutations에 대한 외부적인 기능 → 외부에서 접근할 때 actions 사용
    - 비동기적 처리가능, state 데이터를 읽기만 가능
    - mutations에 작성되는 로직 외 대부분의 로직을 actions에 작성하는것을 권장
    - mutaitions에 직접 access하는 것보다 action에서 하는 것을 권장
    - 변경이 있을 때 commit 해야한다.

![Untitled (10)](https://github.com/juhee99/Kosa-fullStack/assets/55836020/8614950b-83ec-4938-b6f9-071dfe993be5)


### 예제

```jsx
import { createStore } from "vuex";

export default createStore({
  state: {
    counter: 10
  },
  getters: {
    time2(state) {
      return state.counter * 2;
    }
  },
  mutations: {
    setCounter(state, value) {
      state.counter = value;
    }
  },
  actions: { // 비동기 호출을 내장-> 먼저 리턴하고 5초 뒤 
    setLayzCounter(context) {
      setTimeout(() =>context.commit('setCounter', 1000), 5000)
    }
  }
  
});
```

```html
<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
        setup() {
                const store = useStore();
                console.log(store)
                const counter = computed(() => store.state.counter); // 직접 접근
                const test = computed(() => store.getters); // getter 호출
                const inc = () => store.commit("setCounter", counter.value + 1);
                const asyncinc = () => store.dispatch("setLayzCounter"); // dispatch()메소드를 통해 action 호출

                return { counter, inc, test, asyncinc };
        }
};
</script>
```

## 03. Pinia

💡 Vue.js용 스토어 라이브러리 밑 상태 관리 프레임워크이다.

- 선언적 구문을 사용하고 자체 상태 관리 API를 제공한다.

- Store : 전역 데이터가 저장되는 저장소
- State : 전역 데이터
- Getters : 저장소에서 데이터를 검색하는 방법
- Actions : 저장소에서 데이터를 수정하는 방법

```jsx
import { defineStore } from 'pinia'
//store 객체 만들기
export const useCounterStore = defineStore('counter', {
  state: () => {
    return { count: 0, name: '마석도' }
  },
  // could also be defined as
  // state: () => ({ count: 0 })
  getters: {
    getName: (state) => state.name+"!!",
  },
  actions: {
    increment() {
      this.count++
    },
  },
})
```

```jsx
import { useCounterStore } from '@/stores/counter'
const store1 = useCounterStore();
let num1 = store1.count; // num1 = 0
store1.increment();
let num2 = store1.count; // num2 = 1 
//num1,num2 반응성 x
```

- State 안에 있는 데이터는 반응형이다. → 구조 분해 할당을 하게 되면 반응성을 잃게 되는데 이때 storeTorefs를 사용한다.
    
    ```jsx
    const store2 = useFriendStore()
    const { name, age } = storeToRefs(store2)
    ```
    

## 04. Watch

- 첫번째 아규먼트의 변화를 감시

```jsx
// watch : num1 값의 변경이 감지되어야 실행이됨.
watch(num1, (after, previous) => {
    console.log(`[W]현재값 : ${after}`);
    console.log(`[W]이전값 : ${previous}`);
});
```

### 4.1 WatchEffect

💡 등록된 함수에서 다루는 반응형 변수의 값이 변경될 때 마다 실행

- 최초로 랜더링 될 때도 실행
- 중간에 stop 시킬 수 있다. → computed와 차이점

## 05. 기타

- vuex 설치 : npm install vuex --save
- pinia 설치 : npm install pinia --save
- vueX는 react의 useContext와 같은 역할
- WatchEffect 는 react 의 useEffect이랑 비슷
- 실제 사용할 때 vueX말고 pinia를 사용해라!
