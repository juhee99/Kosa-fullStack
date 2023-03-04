# 2023-03-03 / Git & GitHub

### 01. 버전 관리 시스템 (VCS - Version Control System)

- 파일 변경을 기록했다가 나중 특정 시점의 버전의 코드를 체크 아웃할 수 있는 시스템
- 버전 비교, 파일 이전 상태로 되돌림, 파일 수정 기록 , 프로젝트 전체 이전 상태로
- 개인 또는 팀 단위로 개발중인 소스 코드 관리나 메뉴얼 등의 디지털 문서 관리
- 로컬 버전 관리(LVCS)/중앙집중식 버전 관리(CVCS) / 분산 버전 관리(DVCS)

### 02. 중앙집중식 버전 관리(CVCS)

- 파일을 별도로 관리하는 서버를 둔다.
- 서버가 다운 되었을 때나 물리적 문제가 생겼을 때, 히스토리가 없어질 수 도 있음
- VisulalSvn

### 03. Git 이란?

- Git은 분산 버전 관리 시스템이다. (Distributed Version Control System -DVCS)
- 특정 시점에 대해 상태를 기록해 놓으면 이후라도 언제든지 그 환경으로 돌아갈 수 있게 도와주는 것
- 여러 사람이 협동 작업하는 환경에서 문서의 변경 사항을 관리
- 변경사항을 체계적으로 추적하고 통제하는 것
- 저장소가 로컬에 있어 네트워크가 끊어져도 작업 가능
- [참고] pro git book →추천 도서!

### 04. Git / GitHub 차이점

- git은 로컬 저장소
- github:  원격 저장소 (클라우드),버전 관리를 위한 인터넷 호스팅 서비스

### 05. Branch

- 여러 사람이 작업하는 환경에서, 독립적으로 어떤 작업을 진행하기 위한 개념입니다.

git branch [브랜치 명]  - 브랜치 생성

git brach -D  [브랜치 명] - 브랜치 삭제

git checkout [브랜치 명] -브랜치 변경




### 06. Merge - 병합

- 분기된 브랜치 병합하기
1.  git checkout main - 깃 main 브랜치로 변경
2. git merge 브랜치<br/>
3. 📌병합 충돌 주의 해서 merge 하기!

### Git 실습

1. git 설치
2. github Destop 설치
3. git repository 생성
- git 터미널 명령어
    1. 작업할 파일로 이동
    2. git init - 해당 디렉토리에 git이 바라보게 설정
    3. git status - 깃 상태 확인
    4. git add  .  - 파일 스테이징으로 추가
    5. git rm –cached 파일 - 스테이징에서 wrokind로 내려 보냄
    6. git commit -m “메세지” - 커밋
    7. git push - 푸쉬

### Git Desktop
