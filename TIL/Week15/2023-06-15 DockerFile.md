<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913282/noticon/xyzfawahazvkwiyje7it.png" height="15%" width="15%"> <br/>

# 2023-06-15 / DockerFile

🗓️ 날짜           2023/06/13

☁️ 날씨            ☀️ 맑음 (22 °C)

## Dockerfile 스크립트로 이미지 생성

💡 Dockerfile에 컨테이너에 넣을 이미지나 실행할 명령 등 기술하는 파일

- Docker 이미지가 어떤 단계를 거쳐 빌드되어야 하는지를 담고 있는 텍스트 파일
- Docker는 Dockerfile에 나열된 명령문을 차례대로 수행하여 이미지를 생성한다.
- `docker build -t 생성할이미지이름 Dockerfile경로`

### Dockerfile Script Ex

- 대문자로 작성하는 것을 권장하고 있음

```yaml
FROM openjdk:11-jdk                         // 토대가 되는 이미지 지정
ARG JAR_FILE=build/lib/*.jar                //argument를 줘서 argument가 있을 때 그 값으로 변경됨
COPY ${JAR_FILE} app.jar                    //host 내 파일
ENTRYPOINT ["java","-jar","/app.jar"]       //컨테이너를 실행할 명령어를 강제 지정
```

### nginx에 vue.js의 빌드 파일을 배포해서 컨테이너로 기동하는 예

```yaml
FROM node:11.1-alpine as develop-stage
WORKDIR /app
COPY package*.json ./
CMD ["npm","run","install"]
COPY . .                                          //npm run install한 결과를 
# build stage                                     // workdir에 복사
FROM develop-stage as build-stage
CMD ["npm","run","build"]
# production stage
FROM nginx:1.15.7-alpine as production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
EXPOSE 80                                         //80포트 번호
CMD ["nginx", "-g", "daemon off;"]                
```

## 02. Dockerfile 명령어

### 2.1 FROM 명령어

- FROM <이미지>
- FROM <이미지>:<태그>
- FROM 명령문은 base 이미지를 지정하기 위해 사용되는데 base 이미지는 Docker Hub와 같은 Docker repository에 올려놓은 공개 이미지인 경우가 많다.

### 2.2 WORKDIR

- WORKDIR <이동할 경로>
- 작업 디렉토리로 전환을 위해서 사용된다.
- WORKDIR명령문으로 작업 디렉터리를 전환하면 RUN,CMD,ENTRYPOIN,COPY,ADD 명령문은 해당 디렉터리를 기준으로 실행된다.

### 2.3 RUN

- RUN [”커맨드”, ”파라미터1”, ”파라미터”]
- RUN 전체 커맨드
- RUN 명령문은 쉘에서 커맨트를 실행하는 것처럼 이미지 빌드 과정에서 필요한 커맨드를 실행하기 위해 사용된다.

## 이미지/컨테이너 ↔ tar 파일

### 이미지

- 이미지를 호스트 컴퓨터의 파일시스템에 tar형식으로 저장
    - docker save -o 파일_이름.tar 이미지_이름
- 도커 엔진으로 가져올때
    - docker load -i 파일_이름.tar

### 파일

- 컨테이너를 파일로 저장
    - docker export [컨테이너 명 or 컨테이너ID] 파일_이름.tar
- 저장한 컨테이너를 도커 이미지로 읽어 드림
    - docker import [파일_이름.tar or URL] - [image name[:tag name]]

## 도커 이미지 저장소

💡 직접 만든 이미지를 도커 허브에 업로드할 수 있고, 비공개로 도커 허브와 같은 장소를 만들 수도 있음

- 도커 레지스트리 : 이미지 배포하는 장소
- 도커 허브 : 도커 제작사에서 운영하는 고식 도커 레지스트리

### 레지스트리(Registry)

- 도커 이미지를 관리하는 공간
- 도커 허브를 기본 레지스트리로 사용
- 레지스트리는 Docker HUB, Private Docker Hub, 회사 내부용 등으로 나뉨

### 리포지토리(Repository)

- 레지스트리 내에 도커 이미지가 저장되는 공간
- **이미지 이름이 리포지토리명으로 사용되기도 함**
- 깃허브의 리포지토리와 비슷한 역할

### 태그(Tag)

- 같은 이미지이지만 **버전**별로 내용이 다름
- 해당 이미지를 설명하는 버전 정보를 주로 입력
- 보통 latest 태그가 붙은 최신 버전을 사용

## Docker Compose

💡 여러개의 컨테이너를 시스템 관련 명령들을 하나의 파일에서 관리하는 실행 도구.

- 단일 서버에서 여러 개의 컨테이너를 하나의 서비스로 정의해 컨테이너의 묶음으로 관리할 수 있는 작업 환경을 제공하는 관리 도구
- YAML포맷의 정의 파일 - 설정 파일
- 각각의 도커 컨포넌트를 서비스라고 부른다.

![Untitled (14)](https://github.com/juhee99/Kosa-fullStack/assets/55836020/ad992abe-7993-4550-ac0e-cc27f6fe3382)

- up 명령 : 컨테이너를 생성 및 실행, 네트워크나 볼륨도 정의 가능
- down : 컨테이너와 네트워크 정지 및 삭제
- stop : 컨테이너와 네트워크를 삭제없이 종료만 진행

## 기타

- 자바 인터프리터 : 자바는 자바 프로그래밍 명이면서 자바를 실행시키는 명령어
