<img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913282/noticon/xyzfawahazvkwiyje7it.png" height="15%" width="15%"> <br/>

# 2023-06-14 / Docker Bagic

🗓️ 날짜           2023/06/14

☁️ 날씨            ☀️ 맑음 (20 °C)

## 도커 명령어

💡 docker  상위명령  하위명령  [옵션]  대상  [인자]

| 상위 커맨드 | 하위 커맨드 | 옵션 | 내용 |
| --- | --- | --- | --- |
| **container** | start | -a -i | 컨테이너를 실행 |
|  | stop | -t | 컨테이너를 정지 |
|  | create | —name -e -p -v | 도커 이미지로부터 컨테이너를 생성 |
|  | run | -d -e -i -t -p -v | create + start + pull 명령어를 합친 것 |
|  | exec |  | 실행중인 컨테이너 속에서 프로그램 실행 |
|  | cp | -a | 도커 컨테이너와 도커 호스트 간에 파일을 복사 |
|  | commit |  | 도커 컨테이너를 이미지로 변환 |
| **image** | pull |  |  |
|  | search |  |  |
| **volum** | create | —name | 볼륨을 생성 |
|  | inspect |  | 볼륨의 상세 정보를 출력 |
| **network** | create |  | 도커 네트워크를 생성 |
|  | connect |  | 도커 네트워크에 연결 |

## 2. 도커 생명 주기

- `docker [container] run 옵션 이미지 [인자]`
- 도커 생성 및 실행 기능, 필요시 이미지 다운로드 기능도 수행
- docker pull + docker create + docker start = docker run
- 동작 중인 컨테이너는 삭제 불가능
    - docker stop → docker rm
    

### 2.1 컨테이너 생성 및 실행

- docker run 옵션 이미지 [인자]

| 옵션 형식 | 내용 |
| --- | --- |
| —name 컨테이너 이름 |  컨테이너 이름을 지정 |
| -p 호스트_포트번호 : 컨테이너_포트번호 | 포트 번호를 지정함 |
| -v 호스트_디스크 : 컨테이너_디렉토리 | 볼륨을 마운트함 |
| -e 환경변수_이름 = 값 | 환경변수를 설정함 |
| -d | 백그라운드로 실행함 |
| -i  | 컨테이너에 터미널을 연결함 |
| -t | 특수 키를 사용 가능하도록 함 |

## ㄴ컨테이너의 통신

💡 

- 호스트 포트번호와 컨테이너의 포트번호를 바인딩 시킨다.
- 컨테이너 외부에서 컨테이너와 통신하기 위해서는 바인딩이 필요하다.

### 포트 설정

- -p 호스트포트번호 : 컨테이너포트번호
- ex) -p 8080:80
- 호스트 포트 번호는 중복될 수 없다.
- 컨테이너 포트 번호는 중복될 수 있다.

## 컨테이너 복사

호스트에서 컨테이너로 복사 ↔ 컨테이너에서 호스트로 복사

- 호스트 → 컨테이너
    - docker cp 호스트_경로 컨테이너_이름: 컨테이너 경로
- 컨테이너 → 호스트
    - docker cp 컨테이너_이름:컨테이너_경로 호스트_경로

## 도커 컨테이너 접근

- docker exec -it 컨테이너 bash
- 리눅스 명령어로 컨테이너 접근할 수 있다.
- pwd : 경로 출력
- ls : 파일 목록 출력
- cat 파일명 : 파일 내용 출력
- /home : 유저 정보를 담고 있는 폴더
- /bin : 명령어들이 담겨 있는 폴더
- /etc :  시스템 폴더
- sed :  editor
- ctrl+d : 끝!
- cat >> 파일명 : append

## 도커 컨테이너의 저장소

- Docker 컨테이너에 쓰여진 데이터는 기본적으로 컨테이너가 삭제될 때 함께 사라지게 된다.
- 데이터를 영속적으로 저장을 해야 하는 경우,
- 여러 개의 Docker 컨테이너가 하나의 저장 공간을 공유해서 데이터를 읽거나 써야 하는 경우가 있다.
- 컨테이너의 주기와 관계없이 데이터를 영속적으로 저장할 수 있도록 Docker는 두가지 옵션을 제공하는데 Docker 볼륨(volume) , 두번째는 바인드 마운트(bind mount)이다.

### Volum(볼륨)

💡 도커 엔진이 관리하는 영역 내에 만들어진 볼륨을 컨테이너에 디스크 형태로 마운트하여 사용

- 직접 조작이 어려우므르 주로 ‘임시 목적’ 또는 ‘자주 쓰지는 않지면 지우면 안되는 파일을 저장’하는 목적으로 사용
- 도커 엔진에 의해 관리
- 도커 제작사에 추천하는 방식

### Volum 사용방법

- docker volumn create 볼륨이름
- docker volumn rm 볼륨이름
- docker run … `-v 볼륨_이름:컨테이너_마운트_경로`
    - docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD -v /home/docker/data

## 컨테이너로 이미지 만들기

1. commit 명령으로 컨테이너를 이미지로 변환하기
    - docker commit 컨테이너이름 새로운이미지이름
    - docker push 이미지 이름

## 기타

- mysql time 설정 : SET time_zone=’Asia/Seoul’;